package inje.security.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class LogoutSuccessHandlerImpl extends SimpleUrlLogoutSuccessHandler {
	private final Logger log = LoggerFactory.getLogger(LogoutSuccessHandlerImpl.class);

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		log.info("logout");
		this.setDefaultTargetUrl("/login/loginForm.do?logout=true");
		super.onLogoutSuccess(request, response, authentication);
	}
	
}