package id.noeandfriends.eproc.controller.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.noeandfriends.eproc.controller.AbstractContractorController;
import id.noeandfriends.eproc.model.Login;
import id.noeandfriends.eproc.model.User;

@Controller
@RequestMapping("/register")
public class RegisterController extends AbstractContractorController{
	@RequestMapping("")
	public String index(Model model) {
		return "/pages/examples/register";
	}
	
	@PostMapping("/after")
	public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("/dashboard");
	}

}
