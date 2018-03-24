package id.noeandfriends.eproc.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/open-procurement")
public class OpenProcurementController {
	@RequestMapping("")
	public String index(Model model) {
		return "procurement";
	}
	@RequestMapping("/detil")
	public String detil_procurement_page(Model model) {
		return "procurement/detil-procurement";
	}
}
