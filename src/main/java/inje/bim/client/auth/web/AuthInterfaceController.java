package inje.bim.client.auth.web;

import inje.bim.client.auth.service.AuthInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AuthInterfaceController {
	@Autowired
	private AuthInterfaceService authInterfaceService;

}