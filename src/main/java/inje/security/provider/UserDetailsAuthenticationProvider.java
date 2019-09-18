package inje.security.provider;

import inje.bimclient.bim.auth.service.AuthInterfaceService;
import inje.user.LoginUserDetail;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.ServiceException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${bimserver.address}")
    private String bimserverAddress;

    @Autowired
    private AuthInterfaceService authInterfaceService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        log.info(String.format("additionalAuthenticationChecks requested on %s details with %s authentication", userDetails, authentication));
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        BimServerClient bimServerClient = null;
        String password = (String) authentication.getCredentials();
        SUser suser = authInterfaceService.getUser(username);

        if(suser == null) {
            throw new AccountNotConfirmedException("없는 사용자 입니다.");
        }

        try {
            bimServerClient = userBimServerClient(username, password);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new AccountNotConfirmedException(e.getMessage());
        }

        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + suser.getUserType().name()));
        return new LoginUserDetail(bimServerClient, suser, username, password, authorities, true);
    }

    private BimServerClient userBimServerClient(String username, String password) throws BimServerClientException, ServiceException, ChannelConnectionException {
        JsonBimServerClientFactory factory = new JsonBimServerClientFactory(bimserverAddress);
        BimServerClient bimServerClient = factory.create(new UsernamePasswordAuthenticationInfo(username, password));
        return bimServerClient;
    }

    public static class AccountNotConfirmedException extends AuthenticationException {
        public AccountNotConfirmedException(String message) {
            super(message);
        }
    }

}