package inje.bim.other.client.auth.client;

import inje.bim.other.client.Client;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * AuthInterfaceClient
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
 *  -------------  ------   ---------
 *  2019. 09. 10.   유신일    최초 생성
 *  </pre>
 */
@Component
public class AuthInterfaceClient {
    @Autowired
    Client bimServerClient;

    public List<SUser> getAllUsers() throws PublicInterfaceNotFoundException, ServerException, UserException {
        return bimServerClient.getBimServerClient().getServiceInterface().getAllUsers();
    }

	public SUser getUser(String username) {
        SUser result = null;
        try {
            List<SUser> users = bimServerClient.getBimServerClient().getServiceInterface().getAllUsers();
            result = users.stream().filter(x -> x.getUsername().equals(username)).findFirst().get();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (UserException e) {
            e.printStackTrace();
        } catch (PublicInterfaceNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void requestPasswordChange(String username, String resetUrl, boolean includeSiteAddress) {
        try {
            bimServerClient.getBimServerClient().getAuthInterface().requestPasswordChange(username, resetUrl, includeSiteAddress);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (UserException e) {
            e.printStackTrace();
        } catch (PublicInterfaceNotFoundException e) {
            e.printStackTrace();
        }
    }
}