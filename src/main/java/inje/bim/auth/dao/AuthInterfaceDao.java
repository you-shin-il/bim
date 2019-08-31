package inje.bim.auth.dao;

import org.bimserver.client.BimServerClient;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthInterfaceDao {
	@Autowired
	BimServerClient bimServerClient;

	public SUser login(String username, String password) throws PublicInterfaceNotFoundException, ServerException, UserException {
		SUser suser = bimServerClient.getAuthInterface().getLoggedInUser();
		bimServerClient.getAuthInterface().login(username, password);
		return suser;
	}

}