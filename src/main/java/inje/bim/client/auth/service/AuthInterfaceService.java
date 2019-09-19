package inje.bim.client.auth.service;

import inje.bim.client.auth.client.AuthInterfaceClient;
import org.bimserver.interfaces.objects.SUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthInterfaceService {
	@Autowired
	private AuthInterfaceClient authInterfaceClient;

    /* 사용자 상세 */
    public SUser getUser(String username) {
        return authInterfaceClient.getUser(username);
    }
}