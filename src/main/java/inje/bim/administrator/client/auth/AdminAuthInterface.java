package inje.bim.administrator.client.auth;

import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;

import java.util.List;

/**
 * AdminAuthInterface
 * @author  유신일
 * @since	2020. 01. 10
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *      수정일        수정자    수정내용
 *  -------------  ------     --------
 *  2020. 01. 10.   유신일    최초 생성
 *  </pre>
 */
public interface AdminAuthInterface {
    /**
     * 비밀번호 변경 요청
     *
     * @param username
     * @param resetUrl
     * @param includeSiteAddress
     * @return
     * @throws Exception
     */
    public void requestPasswordChange(String username, String resetUrl, boolean includeSiteAddress);

}