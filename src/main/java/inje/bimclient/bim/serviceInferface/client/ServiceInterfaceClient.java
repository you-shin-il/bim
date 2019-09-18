package inje.bimclient.bim.serviceInferface.client;

import inje.user.LoginUserDetail;
import org.bimserver.client.BimServerClient;
import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SRevisionSummary;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class ServiceInterfaceClient {
    @Autowired
    BimServerClient bimServerClient;

    public List<SUser> getAllusers() throws ServiceException, PublicInterfaceNotFoundException {
        LoginUserDetail loginUserDetail = (LoginUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return loginUserDetail.getBimServerClient().getServiceInterface().getAllUsers();
/*        SUser suser = BimServerClientContext.getBimServerClient().getAuthInterface().getLoggedInUser();
        System.out.println("suser : " + suser.getUsername());
        return bimServerClient.getServiceInterface().getAllUsers();*/
    }

    public SUser addUser(SUser sUser, Boolean selfRegistration, String resetUrl) throws ServiceException, PublicInterfaceNotFoundException {
        return bimServerClient.getServiceInterface().addUser(sUser.getUsername(), sUser.getName(), sUser.getUserType(), selfRegistration, resetUrl);
    }

    public boolean deleteUser(Long oid) throws PublicInterfaceNotFoundException, ServerException, UserException {
        return bimServerClient.getServiceInterface().deleteUser(oid);
    }

    public boolean unDeleteUser(Long oid) throws PublicInterfaceNotFoundException, ServerException, UserException {
        return bimServerClient.getServiceInterface().undeleteUser(oid);
    }

    public List<SRevision> getAllRevisionsOfProject(Long aLong) throws PublicInterfaceNotFoundException, ServerException, UserException {
        return bimServerClient.getServiceInterface().getAllRevisionsOfProject(aLong);
    }

    public List<SExtendedData> getAllExtendedDataOfRevision(Long aLong) throws PublicInterfaceNotFoundException, ServerException, UserException {
        return bimServerClient.getServiceInterface().getAllExtendedDataOfRevision(aLong);
    }

    public SRevisionSummary getRevisionSummary(Long aLong) throws PublicInterfaceNotFoundException, ServerException, UserException {
        return bimServerClient.getServiceInterface().getRevisionSummary(aLong);
    }

}