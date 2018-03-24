package id.noeandfriends.eproc.controller;

import java.util.ArrayList;
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

import id.noeandfriends.eproc.model.Login;
import id.noeandfriends.eproc.model.Procurement;
import id.noeandfriends.eproc.model.Proposal;
import id.noeandfriends.eproc.model.User;
import id.noeandfriends.eproc.repository.ProcurementRepository;
import id.noeandfriends.eproc.repository.ProposalRepository;
import id.noeandfriends.eproc.repository.UserRepository;

public class AbstractOwnerController extends InternalAPIController {
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
			user = users.get(1);
		}
		return new ResponseEntity<User>(user, headers, HttpStatus.OK);
	}
	
	@GetMapping(path="/v2/users/{user_id}/proposals")
	public ResponseEntity<List<Proposal>> getListOfMyProposals(@PathVariable String user_id) {
		HttpHeaders headers = new HttpHeaders();
		
		User user = userRepository.findById(user_id).get();
		List<Proposal> proposals = new ArrayList<>();
		
		for (Procurement procurement : procurementRepository.findByUser(user)) {
			List<Proposal> props = proposalRepository.findByProcurement(procurement);
			proposals.addAll(props);
		}
		
		return new ResponseEntity<List<Proposal>>(proposals, headers, HttpStatus.OK);
	}
	
	@GetMapping(path="/v2/users/{user_id}/procurements")
	public ResponseEntity<List<Procurement>> getListOfMyProcurements(@PathVariable String user_id) {
		HttpHeaders headers = new HttpHeaders();
		User user = userRepository.findById(user_id).get();
		List<Procurement> procurements = procurementRepository.findByUser(user);
		return new ResponseEntity<List<Procurement>>(procurements, headers, HttpStatus.OK);
	}
}
