package inje.bimclient.bim.auth.service;

import inje.bimclient.bim.auth.dao.AuthInterfaceDao;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthInterfaceService {
	@Autowired
	private AuthInterfaceDao authInterfaceDao;

	/* 로그인 */
	public SUser login(String username, String password) throws UserException, PublicInterfaceNotFoundException, ServerException {
		return authInterfaceDao.login(username, password);
	}

    /* 사용자 상세 */
    public SUser getUser(String username) {
        return authInterfaceDao.getUser(username);
    }
}