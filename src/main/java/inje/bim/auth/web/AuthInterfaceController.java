package inje.bim.auth.web;

import inje.bim.auth.service.AuthInterfaceService;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthInterfaceController {
	@Autowired
	private AuthInterfaceService authInterfaceService;

	@RequestMapping(value = "/authInterface/login.do")
	public void login() throws ChannelConnectionException, ServiceException, PublicInterfaceNotFoundException {
		authInterfaceService.login();
	}

}