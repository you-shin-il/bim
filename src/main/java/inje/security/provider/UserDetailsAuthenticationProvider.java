package inje.security.provider;

import inje.bimserver.BimServerProperties;
import inje.user.LoginUserDetail;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

@Configuration
public class UserDetailsAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    private final Logger log = (Logger) org.slf4j.LoggerFactory.getLogger(UserDetailsAuthenticationProvider.class);

    @Autowired
    BimServerProperties bimServerProperties;

    private BimServerClient loginUserBimServerClient;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        log.info(String.format("additionalAuthenticationChecks requested on %s details with %s authentication", userDetails, authentication));
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        LoginUserDetail userDetail = null;

        try {
            String password = (String) authentication.getCredentials();
            userBimServerClient(username, password);
            loginUserBimServerClient.getAuthInterface().getLoggedInUser();
            SUser suser = getLoggedInUser();
            ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_" + suser.getUserType().name()));
            userDetail = new LoginUserDetail(loginUserBimServerClient, suser, username, password, authorities, true);
        } catch(Exception e) {
            log.error(e.getMessage());
            throw new AccountNotConfirmedException(e.getMessage());
        }

        return userDetail;
    }

    private void userBimServerClient(String username, String password) throws BimServerClientException, ServiceException, ChannelConnectionException {
        JsonBimServerClientFactory factory = new JsonBimServerClientFactory(bimServerProperties.getAddress());
        loginUserBimServerClient = factory.create(new UsernamePasswordAuthenticationInfo(username, password));
    }

    private SUser getLoggedInUser() throws PublicInterfaceNotFoundException, ServerException, UserException {
        return loginUserBimServerClient.getAuthInterface().getLoggedInUser();
    }

    public static class AccountNotConfirmedException extends AuthenticationException {
        public AccountNotConfirmedException(String message) {
            super(message);
        }
    }
}
