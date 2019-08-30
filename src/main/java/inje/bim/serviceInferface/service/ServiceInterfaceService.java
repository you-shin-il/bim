package inje.bim.serviceInferface.service;

import inje.bim.serviceInferface.dao.ServiceInterfaceDao;
import inje.bim.serviceInferface.model.SUserSearch;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceInterfaceService {
	@Autowired
	private ServiceInterfaceDao serviceInterfaceDao;

	/* 전체 사용자 조회 */
	public List<SUser> getAllUsers(SUserSearch searchSUser) throws PublicInterfaceNotFoundException, ServiceException {
		List<SUser> result = serviceInterfaceDao.getAllusers();
		return result.stream().filter(u -> searchSUser.equals(u))
							  .collect(Collectors.toList());
	}

}