package com.gvayt.smile_server.security;

import com.gvayt.smile_server.entity.Kid;
import com.gvayt.smile_server.entity.Parent;
import com.gvayt.smile_server.repository.KidRepository;
import com.gvayt.smile_server.repository.ParentRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private KidRepository kidRepository;

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        Parent parent = parentRepository.findByEmail(username).orElse(null);
        if (parent != null) {
            return new UserPrincipal(parent);
        }
        Kid kid = kidRepository.findByLogin(username).orElse(null);
        if (kid != null) {
            return new UserPrincipal(kid);
        }
        throw new UsernameNotFoundException("User not found: " + username);
    }
}
