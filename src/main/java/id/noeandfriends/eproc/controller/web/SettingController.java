package id.noeandfriends.eproc.controller.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.noeandfriends.eproc.model.Login;
import id.noeandfriends.eproc.model.User;

@Controller
@RequestMapping("/setting")
public class SettingController {

	@RequestMapping("")
	public String index(Model model) {
		return "pages/UI/general";
	}
	
	@PostMapping("/create_account")
	public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("/setting");
	}
}
