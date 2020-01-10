package inje.bim.administrator.client.service.impl;

import inje.bim.administrator.client.service.AdminServiceInterface;
import inje.bim.administrator.client.service.client.AdminServiceInterfaceClient;
import inje.bim.other.client.service.model.SUserSearch;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SProjectSmall;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * ServiceInterfaceService
 * @author  유신일
 * @since	2019. 09. 10
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *      수정일        수정자    수정내용
 *  -------------  ------   ------
 *  2019. 09. 10.   유신일    최초 생성
 *  </pre>
 */
@Service
public class AdminServiceInterfaceImpl implements AdminServiceInterface {
    @Autowired
    private AdminServiceInterfaceClient adminServiceInterfaceClient;

    /**
     * 사용자 모두 조회
     * @return
     * @throws Exception
     */
    public List<SUser> getAllUsers() throws PublicInterfaceNotFoundException, ServiceException {
        return adminServiceInterfaceClient.getAllusers();
    }

    /**
     * 사용자 모두 조회(조건 조회)
     * @param searchSUser
     * @return
     * @throws Exception
     */
    public List<SUser> getAllUsers(SUserSearch searchSUser) throws PublicInterfaceNotFoundException, ServiceException {
        return this.getAllUsers().stream().filter(u -> searchSUser.equals(u))
                                          .sorted(Comparator.comparing(SUser::getUsername).thenComparing(SUser::getName))
                                          .collect(Collectors.toList());
    }

    /**
     * 사용자 상세 조회
     * @param oid
     * @return
     * @throws Exception
     */
    public Optional<SUser> userDetail(long oid) throws PublicInterfaceNotFoundException, ServiceException {
        return this.getAllUsers().stream().filter(u -> u.getOid() == oid)
                                          .findFirst();
    }

    /**
     * 사용자 추가
     * @param sUser
     * @param selfRegistration
     * @param resetUrl
     * @return
     * @throws Exception
     */
    public SUser addUser(SUser sUser, Boolean selfRegistration, String resetUrl) throws PublicInterfaceNotFoundException, ServiceException {
        return adminServiceInterfaceClient.addUser(sUser, selfRegistration, resetUrl);
    }

    /**
     * 사용자 삭제
     * @param oid
     * @return
     * @throws Exception
     */
    public Boolean deleteUser(Long oid) throws PublicInterfaceNotFoundException, ServiceException {
        return adminServiceInterfaceClient.deleteUser(oid);
    }

    /**
     * 사용자 삭제 취소
     * @param oid
     * @return
     * @throws Exception
     */
    public Boolean unDeleteUser(Long oid) throws PublicInterfaceNotFoundException, ServiceException {
        return adminServiceInterfaceClient.unDeleteUser(oid);
    }

    /**
     * 사용자 프로젝트 조회
     * @param oid
     * @return
     * @throws Exception
     */
    public List<SProject> getUsersProjects(Long oid) throws PublicInterfaceNotFoundException, ServerException, UserException {
        return adminServiceInterfaceClient.getUsersProjects(oid);
    }

    /**
     * 사용자 프로젝트 모든 revison 조회
     * @param oid
     * @return
     * @throws Exception
     */
    public List<SRevision> getAllRevisionsOfProject(Long oid) throws PublicInterfaceNotFoundException, ServerException, UserException {
        return adminServiceInterfaceClient.getAllRevisionsOfProject(oid);
    }

    /**
     * 모든 관련 프로젝트 조회
     * @param oid
     * @return
     * @throws Exception
     */
    public List<SProjectSmall> getAllRelatedProjects(Long oid) throws PublicInterfaceNotFoundException, ServerException, UserException {
        return adminServiceInterfaceClient.getAllRelatedProjects(oid);
    }
}