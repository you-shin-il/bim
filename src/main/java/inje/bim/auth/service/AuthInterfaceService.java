package inje.bim.auth.service;

import inje.bim.auth.dao.AuthInterfaceDao;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthInterfaceService {
	@Autowired
	private AuthInterfaceDao authInterfaceDao;

	/* 전체 사용자 조회 */
	public SUser login(String username, String password) throws UserException, PublicInterfaceNotFoundException, ServerException {
		return authInterfaceDao.login(username, password);
	}

}