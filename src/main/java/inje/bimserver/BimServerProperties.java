package inje.bimserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BimServerProperties {
    @Value("${bimserver.address}")
    private String address;
    @Value("${bimserver.username}")
    private String username;
    @Value("${bimserver.password}")
    private String password;

    public String getAddress() {
        return address;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}