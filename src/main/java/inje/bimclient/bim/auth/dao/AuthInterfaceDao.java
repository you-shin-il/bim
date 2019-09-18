package inje.bimclient.bim.auth.dao;

import org.bimserver.client.BimServerClient;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthInterfaceDao {
	@Autowired
	BimServerClient bimServerClient;

	public SUser login(String username, String password) throws PublicInterfaceNotFoundException, ServerException, UserException {
		SUser suser = bimServerClient.getAuthInterface().getLoggedInUser();
		bimServerClient.getAuthInterface().login(username, password);
		return suser;
	}

	public SUser getUser(String username) {
        SUser result = null;
        try {
            List<SUser> users = bimServerClient.getServiceInterface().getAllUsers();
            result = users.stream().filter(x -> x.getUsername().equals(username)).findFirst().get();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (UserException e) {
            e.printStackTrace();
        } catch (PublicInterfaceNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }
}