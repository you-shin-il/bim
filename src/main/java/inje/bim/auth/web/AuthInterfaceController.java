package inje.bim.auth.web;

import inje.bim.auth.service.AuthInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AuthInterfaceController {
	@Autowired
	private AuthInterfaceService authInterfaceService;

}