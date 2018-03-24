package id.noeandfriends.eproc.controller.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.noeandfriends.eproc.controller.rest.ContractorRestController;

@Controller
@RequestMapping("/setting")
public class SettingController extends ContractorRestController{

	@RequestMapping("")
	public String index(Model model) {
		return "pages/UI/general";
	}
	
	@PostMapping("/create_account")
	public void form_create_account(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nik = request.getParameter("ca_nik");
		String name = request.getParameter("ca_name");
		String tgl_lahir = request.getParameter("ca_tanggal_lahir");
		String ibu_name = request.getParameter("ca_ibu");
		String amount = request.getParameter("ca_amount");
		response.sendRedirect("/setting");
	}
	
	@PostMapping("/exisiting_account")
	public void form_existing_account(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String no_rek = request.getParameter("ea_no_rek");
		response.sendRedirect("/setting");
	}
	
	@PostMapping("/virtual_account")
	public void form_virtual_account(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String kode_institusi = request.getParameter("va_institusi");
		response.sendRedirect("/setting");
	}
	
	@PostMapping("/transfer")
	public void form_transfer(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String norek_tujuan = request.getParameter("tf_no_rek_tujuan");
		String amount = request.getParameter("tf_amount");
		response.sendRedirect("/setting");
	}
}
