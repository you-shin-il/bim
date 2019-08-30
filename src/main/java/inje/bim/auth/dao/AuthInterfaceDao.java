package inje.bim.auth.dao;

import org.bimserver.client.BimServerClient;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthInterfaceDao {
	@Autowired
	BimServerClient bimServerClient;

	public void login() {
		try {
			String token1 = bimServerClient.getAuthInterface().login("kyoyaiida@injeinc.co.kr", "1111");
			SUser suser = bimServerClient.getAuthInterface().getLoggedInUser();
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		}
	}

}