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
import id.noeandfriends.eproc.model.User;

@Controller
@RequestMapping("/register")
public class RegisterController extends AbstractContractorController {
	@RequestMapping("")
	public String index(Model model) {
		return "/pages/examples/register";
	}
	
	@PostMapping("/after")
	public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String instansi = request.getParameter("instansi");
		String npwp = request.getParameter("npwp");
		String phone = request.getParameter("phone");
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setInstansi(instansi);
		user.setNpwp(npwp);
		user.setPhone(phone);
		
		this.signup(user);
		
		response.sendRedirect("/login");
	}

}
