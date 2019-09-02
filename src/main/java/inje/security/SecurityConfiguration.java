package inje.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	/*@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;*/

/*	@Autowired
	private CustomLoginSuccessHandler customLoginSuccessHandler;*/

/*	@Autowired
	private AuthenticationFailureHandlerImpl authenticationFailureHandlerImpl;*/

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/images/**", "/css/**", "/js/**", "/webjars/**");
	}

	/*
	 loginPage("loginPage") 					// 로그인 페이지
	 loginProcessingUrl("loginProcessingUrl") 	// 로그인 페이지 form action에 입력할 주소 지정
	 defaultSuccessUrl("String") 				// 로그인 성공시 이동될 페이지
	*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		* 	SYSTEM(0),
		    ADMIN(1),
		    USER(2),
		    READ_ONLY(3);
		* */
		http.csrf().disable().authorizeRequests()
								.mvcMatchers("/login/**", "/css/**", "/js/**", "/img/**").permitAll()
								.mvcMatchers("/serviceInterface/**").hasAnyRole("ADMIN", "USER") //내부적으로 접두어 "ROLE_"가 붙는다.
								.anyRequest()
								.authenticated();
//								.antMatchers("/**/**").hasRole("SYSTEM")
//								.antMatchers("/**/**").hasRole("ADMIN")
//								.antMatchers("/**/**").hasRole("USER")
//								.antMatchers("/**/**").hasRole("READ_ONLY");

		http.formLogin().loginPage("/login/loginForm.do")
						.loginProcessingUrl("/authenticate")
						.defaultSuccessUrl("/serviceInterface/getAllUsers.do")
						.usernameParameter("username")
						.passwordParameter("password");
						/*.successHandler(customLoginSuccessHandler)*/
						/*.failureHandler(authenticationFailureHandlerImpl);*/

		/*http.logout().logoutSuccessHandler(logoutSuccessHandlerImpl)
					 .invalidateHttpSession(true);//세션 삭제 여부*/

		//http.sessionManagement().maximumSessions(1).expiredUrl("/login/loginForm.do?userOver=true");//다중접속 가능한 수 및 다중 접속 시 먼저 접속된 사용자 url
		//http.exceptionHandling().accessDeniedHandler(accessDeniedHandlerImpl);//권한이 없을경우 handler

		//http.sessionManagement().invalidSessionUrl("/");//세션종료시 로그아웃?
		//http.exceptionHandling().accessDeniedPage("/accessDeniedPage.do");//권한이 없을경우 이동 url
/*		http.sessionManagement().sessionAuthenticationErrorUrl("/sessionAuthenticationErrorUrl.do");
		http.sessionManagement().invalidSessionUrl("/");//세션종료시 로그아웃?
		http.sessionManagement().maximumSessions(1).expiredUrl("/sessionExpired.do");*/
	}


}