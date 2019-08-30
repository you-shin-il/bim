package inje.bim.auth.service;

import inje.bim.auth.dao.AuthInterfaceDao;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthInterfaceService {
	@Autowired
	private AuthInterfaceDao authInterfaceDao;

	/* 전체 사용자 조회 */
	public void login() throws PublicInterfaceNotFoundException, ServiceException {
		authInterfaceDao.login();
	}

}