package id.noeandfriends.eproc.controller.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping("")
	public String index(Model model) {
		return "pages/examples/profile";
	}
	@PostMapping("/update")
	public void form_update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("/user");
	}
}
