package inje.bim.administrator.client.service.client;

import org.bimserver.client.BimServerClient;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SProjectSmall;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ServiceInterfaceClient
 *
 * @author  유신일
 * @since   2019. 09. 10.
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
@Component
public class AdminServiceInterfaceClient {
    private ServiceInterface serviceInterface;

    public AdminServiceInterfaceClient(BimServerClient adminBimServerClient) throws PublicInterfaceNotFoundException {
        this.serviceInterface = adminBimServerClient.getServiceInterface();
    }

    /**
     * 사용자 전체 조회
     * @return
     * @throws Exception
     */
    public List<SUser> getAllusers() throws ServiceException {
        return serviceInterface.getAllUsers();
    }

    /**
     * 사용자 추가(비밀번호 미입력)
     * @param sUser
     * @param selfRegistration
     * @param resetUrl
     * @return
     * @throws Exception
     */
    public SUser addUser(SUser sUser, Boolean selfRegistration, String resetUrl) throws ServiceException {
        return serviceInterface.addUser(sUser.getUsername(), sUser.getName(), sUser.getUserType(), selfRegistration, resetUrl);
    }

    /**
     * 사용자 추가(비밀번호 입력)
     * @param sUser
     * @param password
     * @param selfRegistration
     * @param resetUrl
     * @return
     * @throws Exception
     */
    public SUser addUserWithPassword(SUser sUser, String password, Boolean selfRegistration, String resetUrl) throws ServiceException {
        return serviceInterface.addUserWithPassword(sUser.getUsername(), password, sUser.getName(), sUser.getUserType(), selfRegistration, resetUrl);
    }

    /**
     * 사용자 삭제
     * @param oid
     * @return
     * @throws Exception
     */
    public boolean deleteUser(Long oid) throws ServerException, UserException {
        return serviceInterface.deleteUser(oid);
    }

    /**
     * 사용자 삭제 취소
     * @param oid
     * @return
     * @throws Exception
     */
    public boolean unDeleteUser(Long oid) throws ServerException, UserException {
        return serviceInterface.undeleteUser(oid);
    }

    /**
     * 사용자 모두 조회
     * @return
     * @throws Exception
     */
    public List<SUser> getAllUsers() throws ServiceException {
        return serviceInterface.getAllUsers();
    }

    /**
     * 사용자 프로젝트 조회
     * @param oid
     * @return
     * @throws Exception
     */
    public List<SProject> getUsersProjects(Long oid) throws PublicInterfaceNotFoundException, ServerException, UserException {
        return serviceInterface.getUsersProjects(oid);
    }

    /**
     * 사용자 프로젝트 모든 revison 조회
     * @param oid
     * @return
     * @throws Exception
     */
    public List<SRevision> getAllRevisionsOfProject(Long oid) throws PublicInterfaceNotFoundException, ServerException, UserException {
        return serviceInterface.getAllRevisionsOfProject(oid);
    }

    /**
     * 모든 관련 프로젝트 조회
     * @param oid
     * @return
     * @throws Exception
     */
    public List<SProjectSmall> getAllRelatedProjects(Long oid) throws PublicInterfaceNotFoundException, ServerException, UserException {
        return serviceInterface.getAllRelatedProjects(oid);
    }

    /**
     * 프로젝트 생성
     * @param projectName
     * @param schema
     * @return
     * @throws Exception
     */
    public SProject addProject(String projectName, String schema) throws ServerException, UserException {
        return serviceInterface.addProject(projectName, schema);
    }
}