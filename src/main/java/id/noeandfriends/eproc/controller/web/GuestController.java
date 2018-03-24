package id.noeandfriends.eproc.controller.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import id.noeandfriends.eproc.controller.AbstractContractorController;
import id.noeandfriends.eproc.controller.rest.ContractorRestController;

@Controller
public class GuestController extends AbstractContractorController {
	
	@GetMapping(path="/docs")
	public void docs(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.sendRedirect("/swagger-ui.html");
	}
	
	@GetMapping(path="/")
	public void index(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		HttpSession session = request.getSession(false);
		if(session != null)
			response.sendRedirect("/dashboard");
		else
			response.sendRedirect("/login");
	}
	
	@GetMapping(path="/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("/login");
	}
}
