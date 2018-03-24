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
@RequestMapping("/user")
public class UserController extends AbstractContractorController {
	@RequestMapping("")
	public String index(Model model) {
		return "pages/examples/profile";
	}
	@PostMapping("/update")
	public void form_update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("userUsername");
		String email = request.getParameter("userEmail");
		String phone = request.getParameter("userPhone");
		String instansi = request.getParameter("userInstansi");
		String npwp = request.getParameter("userNPWP");
		String alamat = request.getParameter("userAlamat");
		response.sendRedirect("/user");
	}
}
