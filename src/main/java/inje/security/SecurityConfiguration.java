package inje.security;

import inje.security.provider.UserDetailsAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsAuthenticationProvider userDetailsAuthenticationProvider;

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
		http.csrf().disable().authorizeRequests();
		http.authorizeRequests().mvcMatchers("/user/**","/login/**", "/css/**", "/js/**", "/img/**", "/bootstrap/**").permitAll()
								.mvcMatchers("/serviceInterface/**").hasAnyRole("ADMIN", "USER") //내부적으로 접두어 "ROLE_"가 붙는다.
                                .mvcMatchers("/project/**").hasAnyRole("ADMIN", "USER") //내부적으로 접두어 "ROLE_"가 붙는다.
                                .mvcMatchers("/openapi/**").hasAnyRole("ADMIN", "USER") //내부적으로 접두어 "ROLE_"가 붙는다.
								.anyRequest()
								.authenticated();

		http.formLogin().loginPage("/login/loginForm.do")
						.loginProcessingUrl("/authenticate")
						.defaultSuccessUrl("/server/serviceInterface/getAllUsers.do")
						.usernameParameter("username")
						.passwordParameter("password");
	}

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(userDetailsAuthenticationProvider);
    }
}