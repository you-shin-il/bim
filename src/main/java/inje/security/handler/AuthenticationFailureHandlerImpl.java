package inje.security.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Configuration
/*
 * 아이디 또는 비번이 일치하지 않아서 인증이 불가능 한 경우
 */
public class AuthenticationFailureHandlerImpl extends SimpleUrlAuthenticationFailureHandler {
	private final Logger log = LoggerFactory.getLogger(AuthenticationFailureHandlerImpl.class);

	public AuthenticationFailureHandlerImpl() {
		log.info("AuthenticationFailureHandlerImpl");
		this.setDefaultFailureUrl("/login/loginForm.do?fail=true");
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse res, AuthenticationException ex) throws IOException, ServletException {
		log.info("Login Failed... - {}", req.getParameter("username"));
		HttpSession session = req.getSession();
		super.onAuthenticationFailure(req, res, ex);
	}
}