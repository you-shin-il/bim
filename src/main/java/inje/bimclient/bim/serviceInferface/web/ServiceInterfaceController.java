package inje.bimclient.bim.serviceInferface.web;

import inje.bimclient.bim.serviceInferface.model.SUserSearch;
import inje.bimclient.bim.serviceInferface.service.ServiceInterfaceService;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ServiceInterfaceController {
	@Autowired
	private ServiceInterfaceService serviceInterfaceService;

	@RequestMapping(value = "/serviceInterface/getAllUsers.do")
	public String getAllUsers(ModelMap model, SUserSearch searchSUser) throws ChannelConnectionException, ServiceException, PublicInterfaceNotFoundException {
		List<SUser> result = serviceInterfaceService.getAllUsers(searchSUser);
		result.forEach(x -> {
			System.out.println("name : " + x.getName());
			System.out.println("username : " + x.getUsername());
			System.out.println("status : " + x.getState().name());
			System.out.println("userType : " + x.getUserType().name());
		});

		model.addAttribute("result", result);
		model.addAttribute("searchSUser", searchSUser);
		return "serviceInterface/getAllUsers";
		/*return "layout/exampleLayout";*/
	}

/*    @RequestMapping(value = "serviceInterface/getAllUsers.do")
    public String getAllUsers(@RequestBody SUserSearch searchSUser) throws ChannelConnectionException, ServiceException, PublicInterfaceNotFoundException {
	    List<SUser> result = serviceInterfaceService.getAllUsers(searchSUser);
	    result.forEach(x -> {
		    System.out.println("name : " + x.getName());
		    System.out.println("username : " + x.getUsername());
		    System.out.println("status : " + x.getState().name());
		    System.out.println("userType : " + x.getUserType().name());
	    });

		return "serviceInterface/getAllUsers";
    }*/

}