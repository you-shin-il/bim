package inje.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
	@RequestMapping("/login/loginForm.do")
	public String loginForm(HttpServletRequest req) {
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//HttpSession session = req.getSession();
		return "login/loginForm";
	}

}