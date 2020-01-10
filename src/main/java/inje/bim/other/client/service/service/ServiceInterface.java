package inje.bim.other.client.service.service;

import inje.bim.other.client.service.model.SUserSearch;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SProjectSmall;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;

import java.util.List;
import java.util.Optional;

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
public interface ServiceInterface {
    /**
     * 사용자 모두 조회
     * @return
     * @throws Exception
     */
    public List<SUser> getAllUsers() throws PublicInterfaceNotFoundException, ServiceException;

    /**
     * 사용자 모두 조회(조건 조회)
     *
     * @param searchSUser
     * @return
     * @throws Exception
     */
    public List<SUser> getAllUsers(SUserSearch searchSUser) throws PublicInterfaceNotFoundException, ServiceException;

    /**
     * 사용자 상세 조회
     *
     * @param oid
     * @return
     * @throws Exception
     */
    public Optional<SUser> userDetail(long oid) throws PublicInterfaceNotFoundException, ServiceException;

    /**
     * 사용자 프로젝트 조회
     *
     * @param oid
     * @return
     * @throws Exception
     */
    public List<SProject> getUsersProjects(Long oid) throws PublicInterfaceNotFoundException, ServerException, UserException;

    /**
     * 사용자 프로젝트 모든 revison 조회
     *
     * @param oid
     * @return
     * @throws Exception
     */
    public List<SRevision> getAllRevisionsOfProject(Long oid) throws PublicInterfaceNotFoundException, ServerException, UserException;

    /**
     * 모든 관련 프로젝트 조회
     *
     * @param oid
     * @return
     * @throws Exception
     */
    public List<SProjectSmall> getAllRelatedProjects(Long oid) throws PublicInterfaceNotFoundException, ServerException, UserException;
}