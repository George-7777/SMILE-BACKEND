package com.gvayt.smile_server.security;

import com.gvayt.smile_server.entity.Kid;
import com.gvayt.smile_server.entity.Parent;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserPrincipal implements UserDetails {
    @Getter
    private final Integer id;
    private final String username;
    private final String passwordHash;
    @Getter
    private final String role;

    public UserPrincipal(Parent parent) {
        this.id = Math.toIntExact(parent.getId());
        this.username = parent.getEmail();
        this.passwordHash = parent.getHashPassword();
        this.role = "PARENT";
    }

    public UserPrincipal(Kid kid) {
        this.id = Math.toIntExact(kid.getId());
        this.username = kid.getLogin();
        this.passwordHash = kid.getHashPassword();
        this.role = "KID";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + role));
    }

    @Override
    public String getPassword() { return passwordHash; }

    @Override
    public String getUsername() { return username; }
}
