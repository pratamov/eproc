package id.noeandfriends.eproc.controller.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.noeandfriends.eproc.controller.AbstractContractorController;
import id.noeandfriends.eproc.controller.rest.ContractorRestController;
import id.noeandfriends.eproc.model.Login;
import id.noeandfriends.eproc.model.User;

@Controller
@RequestMapping("/login")
public class LoginController extends AbstractContractorController{
	
	@RequestMapping("")
	public String index(Model model, HttpServletRequest request) {
		return "/pages/examples/login";
	}
	
	@PostMapping("/after")
	public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Login login = new Login();
		login.setEmail(email);
		login.setPassword(password);
		
		User user = this.login(login).getBody();
		
		HttpSession session = request.getSession();
        session.setAttribute("uid", user.getId());
        
		response.sendRedirect("/dashboard");
	}
	
}
