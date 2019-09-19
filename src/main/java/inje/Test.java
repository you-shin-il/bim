package inje;

import inje.user.LoginUserDetail;
import org.bimserver.client.BimServerClient;
import org.springframework.security.core.context.SecurityContextHolder;

public class Test {
    public static BimServerClient bimServerClient = ((LoginUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getBimServerClient();
}