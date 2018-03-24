package id.noeandfriends.eproc.controller.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
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
	@PostMapping("/add")
	public String form_create_proposal(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		String judul = request.getParameter("proposalJudul");
//		String deskripsi = request.getParameter("proposalDeskripsi");
//		String biaya = request.getParameter("proposalBiaya");
//		String durasi = request.getParameter("proposalDurasi");
//		String File = request.getParameter("proposalFile"); 
		return "pages/tables/add_proposal";
	}
	@PostMapping("/edit")
	public String form_edit_proposal(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		String judul = request.getParameter("proposalJudul");
//		String deskripsi = request.getParameter("proposalDeskripsi");
//		String biaya = request.getParameter("proposalBiaya");
//		String durasi = request.getParameter("proposalDurasi");
//		String File = request.getParameter("proposalFile"); 
		return "pages/tables/edit_proposal";
	}
}
