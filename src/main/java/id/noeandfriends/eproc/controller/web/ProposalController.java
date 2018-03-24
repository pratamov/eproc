package id.noeandfriends.eproc.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import id.noeandfriends.eproc.controller.AbstractContractorController;
import id.noeandfriends.eproc.controller.rest.ContractorRestController;

@Controller
@RequestMapping("/proposal")
public class ProposalController extends AbstractContractorController {
	
	@RequestMapping("")
	public String index(Model model) {
		return "pages/tables/proposal";
	}
	@RequestMapping("/add")
	public String form_create_proposal(Model model) {
		return "pages/tables/add_proposal";
	}
	@RequestMapping("/edit")
	public String form_edit_proposal(Model model) {
		return "pages/tables/edit_proposal";
	}
}
