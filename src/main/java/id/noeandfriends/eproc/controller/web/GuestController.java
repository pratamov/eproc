package id.noeandfriends.eproc.controller.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuestController {
	
	@GetMapping(path="/docs")
	public void docs(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.sendRedirect("/swagger-ui.html");
	}
	
	@GetMapping(path="/")
	public void index(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.sendRedirect("/swagger-ui.html");
	}
	
}
