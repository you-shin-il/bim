package inje.bim.other.client.auth.service;

import inje.bim.other.client.auth.client.AuthInterfaceClient;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthInterfaceService {
	@Autowired
	private AuthInterfaceClient authInterfaceClient;

    /* 모든 사용자 조회 */
    public List<SUser> getAllUsers() throws UserException, PublicInterfaceNotFoundException, ServerException {
        return authInterfaceClient.getAllUsers();
    }

    /* 사용자 username 일치하는 것 만 조회 */
    public List<SUser> getSearchUser(String username) throws PublicInterfaceNotFoundException, ServerException, UserException {
        List<SUser> suserList = this.getAllUsers();
        return suserList.stream().filter(x -> x.getUsername().equals(username)).collect(Collectors.toList());
    }

    /* 비밀번호 변경 요청 */
    public void requestPasswordChange(String username, String resetUrl, boolean includeSiteAddress) {
        authInterfaceClient.requestPasswordChange(username, resetUrl, includeSiteAddress);
    }

}