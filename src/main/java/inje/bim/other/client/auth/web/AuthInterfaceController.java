package inje.bim.other.client.auth.web;

import inje.bim.other.client.auth.service.AuthInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AuthInterfaceController {
	@Autowired
	private AuthInterfaceService authInterfaceService;

}