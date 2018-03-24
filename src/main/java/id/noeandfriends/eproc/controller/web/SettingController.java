package id.noeandfriends.eproc.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/setting")
public class SettingController {

	@RequestMapping("")
	public String index(Model model) {
		return "pages/UI/general";
	}
}
