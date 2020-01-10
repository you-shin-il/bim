package inje.bim.administrator.client.auth.client;

import org.bimserver.client.BimServerClient;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SProjectSmall;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.AuthInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * AdminAuthInterfaceClient
 *
 * @author  유신일
 * @since   2020. 01. 10.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *      수정일        수정자    수정내용
 *  -------------   ------   ---------
 *  2020. 01. 10.   유신일    최초 생성
 *  </pre>
 */
@Component
public class AdminAuthInterfaceClient {
    private AuthInterface authInterface;

    public AdminAuthInterfaceClient(BimServerClient adminBimServerClient) throws PublicInterfaceNotFoundException {
        this.authInterface = adminBimServerClient.getAuthInterface();
    }

    public void requestPasswordChange(String username, String resetUrl, boolean includeSiteAddress) {
        try {
            authInterface.requestPasswordChange(username, resetUrl, includeSiteAddress);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (UserException e) {
            e.printStackTrace();
        }
    }
}