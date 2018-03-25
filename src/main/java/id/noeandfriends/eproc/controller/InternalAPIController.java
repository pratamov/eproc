package id.noeandfriends.eproc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;

import id.noeandfriends.eproc.model.Account;
import id.noeandfriends.eproc.model.AccountRequest;
import id.noeandfriends.eproc.model.TransferRequest;
import id.noeandfriends.eproc.model.TransferResponse;
import id.noeandfriends.eproc.model.Procurement;
import id.noeandfriends.eproc.model.Proposal;
import id.noeandfriends.eproc.model.User;
import id.noeandfriends.eproc.model.external.AccountCreationRequest;
import id.noeandfriends.eproc.model.external.AccountCreationResponsePayload;
import id.noeandfriends.eproc.model.external.AccountStatementRequest;
import id.noeandfriends.eproc.model.external.AccountStatementResponsePayload;
import id.noeandfriends.eproc.model.external.ApiResponse;
import id.noeandfriends.eproc.model.external.AtmLocation;
import id.noeandfriends.eproc.model.external.AtmLocationRequest;
import id.noeandfriends.eproc.model.external.BalanceInformationRequest;
import id.noeandfriends.eproc.model.external.BalanceInformationResponsePayload;
import id.noeandfriends.eproc.model.external.InhouseTransferRequest;
import id.noeandfriends.eproc.model.external.InhouseTransferResponsePayload;
import id.noeandfriends.eproc.model.external.Transaction;
import id.noeandfriends.eproc.model.external.UserRegisterRequest;
import id.noeandfriends.eproc.model.external.UserRegisterResponsePayload;
import id.noeandfriends.eproc.repository.ProcurementRepository;
import id.noeandfriends.eproc.repository.ProposalRepository;
import id.noeandfriends.eproc.repository.UserRepository;

public abstract class InternalAPIController extends ExternalAPIController{
	
	@Autowired
	ProcurementRepository procurementRepository;
	
	@Autowired
	ProposalRepository proposalRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping(path="/v2/users/{user_id}")
	public ResponseEntity<User> getUserDetail(@PathVariable String user_id) {
		HttpHeaders headers = new HttpHeaders();
		User user = userRepository.findById(user_id).get();
		
		return new ResponseEntity<User>(user, headers, HttpStatus.OK);
	}
	
	@PostMapping(path="/v2/users/{user_id}/procurements")
	public ResponseEntity<Procurement> createProcurements(@PathVariable String user_id, @RequestBody Procurement procurement) {
		HttpHeaders headers = new HttpHeaders();
		User user = userRepository.findById(user_id).get();
		procurement.setUser(user);
		procurement = procurementRepository.save(procurement);
		return new ResponseEntity<Procurement>(procurement, headers, HttpStatus.OK);
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
	
	@PostMapping(path="/v2/users/{user_id}/procurements/{procurement_id}/proposals")
	public ResponseEntity<Proposal> createProposals(@PathVariable String user_id, @PathVariable String procurement_id, @RequestBody Proposal proposal) {
		HttpHeaders headers = new HttpHeaders();
		User user = userRepository.findById(user_id).get();
		proposal.setContractor(user);
		proposal = proposalRepository.save(proposal);
		Procurement procurement = procurementRepository.findById(procurement_id).get();
		proposal.setProcurement(procurement);
		return new ResponseEntity<Proposal>(proposal, headers, HttpStatus.OK);
	}
	
	@GetMapping(path="/v2/users/{user_id}/accounts")
	public ResponseEntity<Account> getAccount(@PathVariable String user_id) throws JsonProcessingException {
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
	public ResponseEntity<Account> createAccount(@PathVariable String user_id, @RequestBody AccountRequest accountRequest) throws JsonProcessingException {
		HttpHeaders headers = new HttpHeaders();
		User user = userRepository.findById(user_id).get();
		Account account = new Account();
		String nomor_cif = "";
		String nomor_rekening = "";
		{
			UserRegisterRequest request = new UserRegisterRequest();
			request.setNama(accountRequest.getNama());
			request.setNama_ibu_kandung(accountRequest.getNamaIbuKandung());
			request.setNik(accountRequest.getNik());
			request.setTgl_lahir(accountRequest.getTglLahir());
			ApiResponse<UserRegisterResponsePayload> response = userRegister(request);
			nomor_cif = response.getPayload().getCif_number();
		}
		{
			AccountCreationRequest request = new AccountCreationRequest();
			request.setAmount(accountRequest.getAmount());
			request.setNomor_cif(nomor_cif);
			ApiResponse<AccountCreationResponsePayload> response = accountCreation(request);
			nomor_rekening = response.getPayload().getNomor_rekening();
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
	public ResponseEntity<Account> connectAccount(@PathVariable String user_id, @PathVariable String nomor_rekening) throws JsonProcessingException {
		
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
	public ResponseEntity<List<AtmLocation>> getAtmLocation(@RequestParam("latitude") double latitude, @RequestParam("longitude") double longitude, @RequestParam("radius_per_km") int radius_per_km) throws JsonProcessingException {
		HttpHeaders headers = new HttpHeaders();
		AtmLocationRequest request = new AtmLocationRequest();
		request.setLatitude(latitude);
		request.setLongitude(longitude);
		request.setRadius_per_km(radius_per_km);
		List<AtmLocation> locations = this.atmLocation(request).getPayload().getData();
		return new ResponseEntity<List<AtmLocation>>(locations, headers, HttpStatus.OK);
	}
	
	@PostMapping(path="/v2/users/{user_id}/transfers")
	public ResponseEntity<TransferResponse> inhouseTransfer(@PathVariable String user_id, @RequestBody TransferRequest transferRequest) throws JsonProcessingException{
		HttpHeaders headers = new HttpHeaders();
		User user = userRepository.findById(user_id).get();
		
		InhouseTransferRequest request = new InhouseTransferRequest();
		request.setAmount(transferRequest.getAmount());
		request.setRekening_asal(user.getNomorRekening());
		request.setRekening_tujuan(transferRequest.getRekeningTujuan());
		
		InhouseTransferResponsePayload responsePayload = this.inhouseTransfer(request).getPayload();
		
		TransferResponse response = new TransferResponse();
		response.setRefNumber(responsePayload.getRef_number());
		response.setSuccess(responsePayload.isSuccess());
		
		return new ResponseEntity<TransferResponse>(response, headers, HttpStatus.OK);
	}
	
	@GetMapping(path="/v2/users/{user_id}/account-statement")
	public ResponseEntity<List<Transaction>> getTransactionHistory(@PathVariable String user_id, @RequestParam("start_date") String start_date, @RequestParam("end_date") String end_date) throws JsonProcessingException{
		HttpHeaders headers = new HttpHeaders();
		User user = userRepository.findById(user_id).get();
		
		AccountStatementRequest request = new AccountStatementRequest();
		request.setEnd_date(end_date);
		request.setRekening(user.getNomorRekening());
		request.setStart_date(start_date);
		
		List<Transaction> response = this.accountStatement(request).getPayload().getData_transaksi();
		return new ResponseEntity<List<Transaction>>(response, headers, HttpStatus.OK);
	}
	
}