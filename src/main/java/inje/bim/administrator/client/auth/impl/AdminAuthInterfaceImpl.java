package inje.bim.administrator.client.auth.impl;

import inje.bim.administrator.client.auth.AdminAuthInterface;
import inje.bim.administrator.client.auth.client.AdminAuthInterfaceClient;
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
 * AdminAuthInterfaceImpl
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
public class AdminAuthInterfaceImpl implements AdminAuthInterface {
    @Autowired
    private AdminAuthInterfaceClient adminAuthInterfaceClient;

    /**
     * 비밀번호 변경 요청
     *
     * @param username
     * @param resetUrl
     * @param includeSiteAddress
     * @return
     * @throws Exception
     */
    public void requestPasswordChange(String username, String resetUrl, boolean includeSiteAddress) {
        adminAuthInterfaceClient.requestPasswordChange(username, resetUrl, includeSiteAddress);
    }
}