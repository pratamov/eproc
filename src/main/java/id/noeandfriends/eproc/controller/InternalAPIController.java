package id.noeandfriends.eproc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import id.noeandfriends.eproc.model.Account;
import id.noeandfriends.eproc.model.AccountRequest;
import id.noeandfriends.eproc.model.Login;
import id.noeandfriends.eproc.model.Procurement;
import id.noeandfriends.eproc.model.Proposal;
import id.noeandfriends.eproc.model.User;
import id.noeandfriends.eproc.model.external.AccountCreationRequest;
import id.noeandfriends.eproc.model.external.AccountCreationResponsePayload;
import id.noeandfriends.eproc.model.external.ApiResponse;
import id.noeandfriends.eproc.model.external.AtmLocation;
import id.noeandfriends.eproc.model.external.AtmLocationRequest;
import id.noeandfriends.eproc.model.external.BalanceInformationRequest;
import id.noeandfriends.eproc.model.external.BalanceInformationResponsePayload;
import id.noeandfriends.eproc.model.external.UserRegisterRequest;
import id.noeandfriends.eproc.model.external.UserRegisterResponsePayload;
import id.noeandfriends.eproc.repository.ProcurementRepository;
import id.noeandfriends.eproc.repository.ProposalRepository;
import id.noeandfriends.eproc.repository.UserRepository;

public class InternalAPIController extends ExternalAPIController{
	
	@Autowired
	ProcurementRepository procurementRepository;
	
	@Autowired
	ProposalRepository proposalRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping(path="/v2/signup")
	public ResponseEntity<User> signup(@RequestBody User user) {
		HttpHeaders headers = new HttpHeaders();
		user.setUserType(0);
		user = userRepository.save(user);
		return new ResponseEntity<User>(user, headers, HttpStatus.OK);
	}
	
	@PostMapping(path="/v2/login")
	public ResponseEntity<User> login(@ModelAttribute Login login) {
		HttpHeaders headers = new HttpHeaders();
		List<User> users = userRepository.findByEmailAndPasswordAndUserType(login.getEmail(), login.getPassword(), 0);
		User user = new User();
		if (users.size() > 0) {
			user = users.get(0);
		}
		return new ResponseEntity<User>(user, headers, HttpStatus.OK);
	}
	
	@GetMapping(path="/v2/users/{user_id}")
	public ResponseEntity<User> getUserDetail(@PathVariable String user_id) {
		HttpHeaders headers = new HttpHeaders();
		User user = userRepository.findById(user_id).get();
		
		return new ResponseEntity<User>(user, headers, HttpStatus.OK);
	}
	
	@GetMapping(path="/v2/users/{user_id}/procurements")
	public ResponseEntity<List<Procurement>> getListOfMyProcurements(@PathVariable String user_id) {
		HttpHeaders headers = new HttpHeaders();
		User user = userRepository.findById(user_id).get();
		List<Procurement> procurements = procurementRepository.findByUser(user);
		return new ResponseEntity<List<Procurement>>(procurements, headers, HttpStatus.OK);
	}
	
	@GetMapping(path="/v2/users/{user_id}/procurements/{procurement_id}")
	public ResponseEntity<Procurement> getProcurementDetails(@PathVariable String user_id, @PathVariable String procurement_id) {
		HttpHeaders headers = new HttpHeaders();
		Procurement procurement = procurementRepository.findById(procurement_id).get();
		return new ResponseEntity<Procurement>(procurement, headers, HttpStatus.OK);
	}
	
	@GetMapping(path="/v2/users/{user_id}/procurements/{procurement_id}/proposals")
	public ResponseEntity<List<Proposal>> getListOfProposals(@PathVariable String user_id, @PathVariable String procurement_id) {
		HttpHeaders headers = new HttpHeaders();
		Procurement procurement = procurementRepository.findById(procurement_id).get();
		List<Proposal> proposals = proposalRepository.findByProcurement(procurement);
		return new ResponseEntity<List<Proposal>>(proposals, headers, HttpStatus.OK);
	}
	
	@GetMapping(path="/v2/users/{user_id}/accounts")
	public ResponseEntity<Account> getAccount(@PathVariable String user_id) {
		HttpHeaders headers = new HttpHeaders();
		User user = userRepository.findById(user_id).get();
		Account account = new Account();
		String nomorRekening = user.getNomorRekening();
		if (nomorRekening != null) {
			BalanceInformationRequest request = new BalanceInformationRequest();
			request.setNomor_rekening(nomorRekening);
			ApiResponse<BalanceInformationResponsePayload> balance = this.balanceInformation(request);
			if (balance.getStatusCode() == 200) {
				account.setNama(balance.getPayload().getNama());
				account.setNomorRekening(balance.getPayload().getNomor_rekening());
				account.setSaldo(balance.getPayload().getSaldo());
				account.setUserId(user_id);
			}
		}
		return new ResponseEntity<Account>(account, headers, HttpStatus.OK);
	}
	
	@PostMapping(path="/v2/users/{user_id}/accounts")
	public ResponseEntity<Account> createAccount(@PathVariable String user_id, @RequestBody AccountRequest accountRequest) {
		HttpHeaders headers = new HttpHeaders();
		User user = userRepository.findById(user_id).get();
		Account account = new Account();
		String nomor_cif = "";
		String nomor_rekening = "";
		{
			UserRegisterRequest request = new UserRegisterRequest();
			ApiResponse<UserRegisterResponsePayload> response = userRegister(request);
			nomor_cif = response.getPayload().getCif_number();
		}
		{
			AccountCreationRequest request = new AccountCreationRequest();
			request.setAmount(accountRequest.getAmount());
			request.setNomor_cif(nomor_cif);
			ApiResponse<AccountCreationResponsePayload> response = accountCreation(request);
			nomor_rekening = response.getPayload().getNo_rekening();
		}
		{
			user.setNomorRekening(nomor_rekening);
			user = userRepository.save(user);
		}
		{
			BalanceInformationRequest request = new BalanceInformationRequest();
			request.setNomor_rekening(nomor_rekening);
			ApiResponse<BalanceInformationResponsePayload> response = balanceInformation(request);
			account.setNama(response.getPayload().getNama());
			account.setNomorRekening(response.getPayload().getNomor_rekening());
			account.setSaldo(response.getPayload().getSaldo());
			account.setUserId(user_id);
		}
		return new ResponseEntity<Account>(account, headers, HttpStatus.OK);
	}
	
	@PostMapping(path="/v2/users/{user_id}/accounts/{nomor_rekening}")
	public ResponseEntity<Account> connectAccount(@PathVariable String user_id, @PathVariable String nomor_rekening) {
		
		HttpHeaders headers = new HttpHeaders();
		User user = userRepository.findById(user_id).get();
		Account account = new Account();
		
		{
			BalanceInformationRequest request = new BalanceInformationRequest();
			request.setNomor_rekening(nomor_rekening);
			ApiResponse<BalanceInformationResponsePayload> response = balanceInformation(request);
			account.setNama(response.getPayload().getNama());
			account.setNomorRekening(response.getPayload().getNomor_rekening());
			account.setSaldo(response.getPayload().getSaldo());
			account.setUserId(user_id);
			user.setNomorRekening(nomor_rekening);
			user = userRepository.save(user);
		}
		
		return new ResponseEntity<Account>(account, headers, HttpStatus.OK);
		
	}
	
	@GetMapping(path="/v2/atm")
	public ResponseEntity<List<AtmLocation>> getAtmLocation(@RequestBody AtmLocationRequest request) {
		HttpHeaders headers = new HttpHeaders();
		List<AtmLocation> locations = this.atmLocation(request).getPayload().getData();
		return new ResponseEntity<List<AtmLocation>>(locations, headers, HttpStatus.OK);
	}
	
	
}