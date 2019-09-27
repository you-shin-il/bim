package inje.bim.client.serviceInferface.client;

import inje.bim.client.Client;
import org.bimserver.interfaces.objects.*;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
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
    Client bimServerClient;

    public List<SUser> getAllusers() throws ServiceException, PublicInterfaceNotFoundException {
        return bimServerClient.getBimServerClient().getServiceInterface().getAllUsers();
    }

    public SUser addUser(SUser sUser, Boolean selfRegistration, String resetUrl) throws ServiceException, PublicInterfaceNotFoundException {
        return bimServerClient.getBimServerClient().getServiceInterface().addUser(sUser.getUsername(), sUser.getName(), sUser.getUserType(), selfRegistration, resetUrl);
    }

    public boolean deleteUser(Long oid) throws PublicInterfaceNotFoundException, ServerException, UserException {
        return bimServerClient.getBimServerClient().getServiceInterface().deleteUser(oid);
    }

    public boolean unDeleteUser(Long oid) throws PublicInterfaceNotFoundException, ServerException, UserException {
        return bimServerClient.getBimServerClient().getServiceInterface().undeleteUser(oid);
    }

    public List<SRevision> getAllRevisionsOfProject(Long aLong) throws PublicInterfaceNotFoundException, ServerException, UserException {
        return bimServerClient.getBimServerClient().getServiceInterface().getAllRevisionsOfProject(aLong);
    }

    public List<SExtendedData> getAllExtendedDataOfRevision(Long aLong) throws PublicInterfaceNotFoundException, ServerException, UserException {
        return bimServerClient.getBimServerClient().getServiceInterface().getAllExtendedDataOfRevision(aLong);
    }

    public SRevisionSummary getRevisionSummary(Long aLong) throws PublicInterfaceNotFoundException, ServerException, UserException {
        return bimServerClient.getBimServerClient().getServiceInterface().getRevisionSummary(aLong);
    }

    public List<SProject> getUsersProjects(Long aLong) throws PublicInterfaceNotFoundException, ServerException, UserException {
        return bimServerClient.getBimServerClient().getServiceInterface().getUsersProjects(aLong);
    }

}