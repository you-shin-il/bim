package inje.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	@RequestMapping("/login/loginForm.do")
	public String loginForm(HttpServletRequest req) {
		return "login/loginForm";
	}

}