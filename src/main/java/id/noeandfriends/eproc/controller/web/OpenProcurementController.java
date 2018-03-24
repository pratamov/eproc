package id.noeandfriends.eproc.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import id.noeandfriends.eproc.controller.AbstractContractorController;
import id.noeandfriends.eproc.controller.rest.ContractorRestController;

@Controller
@RequestMapping("/open-procurement")
public class OpenProcurementController extends AbstractContractorController{
	
	@RequestMapping("")
	public String index(Model model) {
		return "procurement";
	}
	@RequestMapping("/detil")
	public String detil_procurement_page(Model model) {
		return "detil-procurement";
	}
	
}
