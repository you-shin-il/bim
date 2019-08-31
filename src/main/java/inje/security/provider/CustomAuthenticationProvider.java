package inje.security.provider;

import inje.bim.auth.service.AuthInterfaceService;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	private final Logger log = (Logger) org.slf4j.LoggerFactory.getLogger(CustomAuthenticationProvider.class);

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AuthInterfaceService authInterfaceService;

	private static final String ROLE_PREFIX = "ROLE_";

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String)authentication.getCredentials();
		SUser suser = null;

		try {
			suser = authInterfaceService.login(username, password);
		} catch (UserException e) {
			e.printStackTrace();
			log.debug("사용자 정보가 일치하지 않거나 삭제된 사용자 입니다.");
			throw new UsernameNotFoundException("사용자 정보가 일치하지 않거나 삭제된 사용자 입니다.");
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
			log.debug("공용 인터페이스를 찾을 수 없습니다.(BIMServer에 해당하는 api가 없음)");
		} catch (ServerException e) {
			e.printStackTrace();
			log.debug("BIMServer가 응답이 없습니다.(server down 추정)");
		}

		ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ADMIN"));
		log.debug("userType : " + suser.getUserType().name());
		System.out.println("userType : " + suser.getUserType().name());
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(suser, password, authorities);
		usernamePasswordAuthenticationToken.setDetails(suser);
		return usernamePasswordAuthenticationToken;
/*
		MemberVo memberVo = memberMapper.selectMember(id);
		
		if(memberVo == null) {
			throw new UsernameNotFoundException("사용자 ID(email)가 존재하지 않습니다.");
		}
		
		if(!passwordEncoder.matches(password, memberVo.getPassword())) {
			throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
		}
		
		List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
		memberVo.setMemberRoleVoList(securityMapper.selectMemberRoleVoList(memberVo.getRoleNo()));
		
		memberVo.getMemberRoleVoList().forEach(role -> grantedAuthorityList.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.getRoleName())));*/
		
/*		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(id, password, grantedAuthorityList);
		usernamePasswordAuthenticationToken.setDetails(memberVo);

		return usernamePasswordAuthenticationToken;*/
	}

	@Override
	public boolean supports(Class authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}