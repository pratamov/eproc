package id.noeandfriends.eproc.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import id.noeandfriends.eproc.model.Login;
import id.noeandfriends.eproc.model.User;
import id.noeandfriends.eproc.repository.ProcurementRepository;
import id.noeandfriends.eproc.repository.ProposalRepository;
import id.noeandfriends.eproc.repository.UserRepository;

@Controller
@RequestMapping("/{user_id}/dashboard")
public class DashboardController {
	
	@Autowired
	ProcurementRepository procurementRepository;
	
	@Autowired
	ProposalRepository proposalRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("")
	public String index(Model model, @PathVariable String user_id) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		User user = userRepository.findById(user_id).get();
		model.addAttribute("user", user);
		model.addAttribute("user_json", mapper.writeValueAsString(user));
		return "index";
	}
	
	
}
