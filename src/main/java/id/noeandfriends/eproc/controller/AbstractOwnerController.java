package id.noeandfriends.eproc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
	
	// -------------------------------------------------------------------
	
	@GetMapping(path="/v1/owners/procurements")
	public ResponseEntity<List<Procurement>> getProcurements() {
		HttpHeaders headers = new HttpHeaders();
		List<Procurement> procurements = procurementRepository.findAll();
		return new ResponseEntity<List<Procurement>>(procurements, headers, HttpStatus.OK);
	}

	@GetMapping(path="/v1/owners/procurements/{procurement_id}")
	public ResponseEntity<Procurement> getProcurement(@PathVariable String procurement_id) {
		HttpHeaders headers = new HttpHeaders();
		Procurement procurement = procurementRepository.findById(procurement_id).get();
		return new ResponseEntity<Procurement>(procurement, headers, HttpStatus.OK);
	}
	
	@PostMapping(path="/v1/owners/procurements")
	public ResponseEntity<Procurement> createProcurement(@RequestBody Procurement procurement) {
		HttpHeaders headers = new HttpHeaders();
		procurement = procurementRepository.save(procurement);
		return new ResponseEntity<Procurement>(procurement, headers, HttpStatus.OK);
	}
	
	@PutMapping(path="/v1/owners/procurements/{procurement_id}")
	public ResponseEntity<Procurement> updateProcurement(@PathVariable String procurement_id, @RequestBody Procurement procurement) {
		HttpHeaders headers = new HttpHeaders();
		Procurement oldProcurement = procurementRepository.findById(procurement_id).get();
		procurement.setId(oldProcurement.getId());
		procurement = procurementRepository.save(procurement);
		return new ResponseEntity<Procurement>(procurement, headers, HttpStatus.OK);
	}
	
	@DeleteMapping(path="/v1/owners/procurements/{procurement_id}")
	public ResponseEntity<Void> deleteProcurement(@PathVariable String procurement_id){
		HttpHeaders headers = new HttpHeaders();
		procurementRepository.deleteById(procurement_id);
		return new ResponseEntity<Void>(null, headers, HttpStatus.OK);
	}
	
	// -------------------------------------------------------------------
	
	
	@GetMapping(path="/v1/owners/proposals")
	public ResponseEntity<List<Proposal>> getProposals() {
		HttpHeaders headers = new HttpHeaders();
		List<Proposal> proposals = proposalRepository.findAll();
		return new ResponseEntity<List<Proposal>>(proposals, headers, HttpStatus.OK);
	}

	@GetMapping(path="/v1/owners/proposals/{proposal_id}")
	public ResponseEntity<Proposal> getProposal(@PathVariable String proposal_id) {
		HttpHeaders headers = new HttpHeaders();
		Proposal proposal = proposalRepository.findById(proposal_id).get();
		return new ResponseEntity<Proposal>(proposal, headers, HttpStatus.OK);
	}
	
	@PostMapping(path="/v1/owners/proposals")
	public ResponseEntity<Proposal> createProposal(@RequestBody Proposal proposal) {
		HttpHeaders headers = new HttpHeaders();
		proposal = proposalRepository.save(proposal);
		return new ResponseEntity<Proposal>(proposal, headers, HttpStatus.OK);
	}
	
	@PutMapping(path="/v1/owners/proposals/{proposal_id}")
	public ResponseEntity<Proposal> updateProposal(@PathVariable String proposal_id, @RequestBody Proposal proposal) {
		HttpHeaders headers = new HttpHeaders();
		Proposal oldProposal = proposalRepository.findById(proposal_id).get();
		proposal.setId(oldProposal.getId());
		proposal = proposalRepository.save(proposal);
		return new ResponseEntity<Proposal>(proposal, headers, HttpStatus.OK);
	}
	
	@DeleteMapping(path="/v1/owners/proposals/{proposal_id}")
	public ResponseEntity<Void> deleteProposal(@PathVariable String proposal_id){
		HttpHeaders headers = new HttpHeaders();
		proposalRepository.deleteById(proposal_id);
		return new ResponseEntity<Void>(null, headers, HttpStatus.OK);
	}
	
	// ----------------------------------------------------------------------------
	
	@GetMapping(path="/v1/owners/users")
	public ResponseEntity<List<User>> getUsers() {
		HttpHeaders headers = new HttpHeaders();
		List<User> users = userRepository.findAll();
		return new ResponseEntity<List<User>>(users, headers, HttpStatus.OK);
	}
	
	@PostMapping(path="/v1/owners/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		HttpHeaders headers = new HttpHeaders();
		user = userRepository.save(user);
		return new ResponseEntity<User>(user, headers, HttpStatus.OK);
	}
	
	@PutMapping(path="/v1/owners/users/{user_id}")
	public ResponseEntity<User> updateUser(@PathVariable String user_id, @RequestBody User user) {
		HttpHeaders headers = new HttpHeaders();
		User oldUser = userRepository.findById(user_id).get();
		user.setId(oldUser.getId());
		user = userRepository.save(user);
		return new ResponseEntity<User>(user, headers, HttpStatus.OK);
	}
	
	@DeleteMapping(path="/v1/owners/users/{user_id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String user_id){
		HttpHeaders headers = new HttpHeaders();
		userRepository.deleteById(user_id);
		return new ResponseEntity<Void>(null, headers, HttpStatus.OK);
	}
	
}
