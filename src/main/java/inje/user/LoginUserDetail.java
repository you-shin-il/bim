package inje.user;

import org.bimserver.client.BimServerClient;
import org.bimserver.interfaces.objects.SUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class LoginUserDetail implements UserDetails {
    private BimServerClient bimServerClient;
    private SUser suser;
    private String username;
    private String password;
    private List<SimpleGrantedAuthority> authorities;
    private boolean enabled = false;

    public LoginUserDetail(BimServerClient bimServerClient, SUser suser, String username, String password, List<SimpleGrantedAuthority> authorities, boolean enabled) {
        this.bimServerClient = bimServerClient;
        this.suser = suser;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public BimServerClient getBimServerClient() {
        return bimServerClient;
    }

    public SUser getSuser() {
        return suser;
    }

}
