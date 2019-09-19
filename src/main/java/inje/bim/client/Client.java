package inje.bim.client;

import inje.user.LoginUserDetail;
import org.bimserver.client.BimServerClient;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Client {
    public BimServerClient getBimServerClient() {
        return ((LoginUserDetail)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getBimServerClient();
    }
}