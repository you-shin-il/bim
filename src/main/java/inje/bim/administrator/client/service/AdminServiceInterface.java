package inje.bim.administrator.client.service;

import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;

import java.util.List;

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
public interface AdminServiceInterface {
    /**
     * 사용자 모두 조회
     *
     * @return
     * @throws Exception
     */
    public List<SUser> getAllUsers() throws PublicInterfaceNotFoundException, ServiceException;

    /**
     * 사용자 추가
     *
     * @param sUser
     * @param selfRegistration
     * @param resetUrl
     * @return
     * @throws Exception
     */
    public SUser addUser(SUser sUser, Boolean selfRegistration, String resetUrl) throws PublicInterfaceNotFoundException, ServiceException;

    /**
     * 사용자 삭제
     *
     * @param oid
     * @return
     * @throws Exception
     */
    public Boolean deleteUser(Long oid) throws PublicInterfaceNotFoundException, ServiceException;

    /**
     * 사용자 삭제 취소
     *
     * @param oid
     * @return
     * @throws Exception
     */
    public Boolean unDeleteUser(Long oid) throws PublicInterfaceNotFoundException, ServiceException;


}