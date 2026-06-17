package com.gvayt.smile_server.security;

import com.gvayt.smile_server.repository.KidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("kidSecurity")
@RequiredArgsConstructor
public class KidSecurityService {
    private final KidRepository kidRepository;

    public boolean canAccessKid(String login_kid, UserPrincipal principal) {
        if (principal.getRole().equals("KID")) {
            return principal.getUsername().equals(login_kid);
        }
        if (principal.getRole().equals("PARENT")) {
            return kidRepository.existsByLoginAndParentId(login_kid, Long.valueOf(principal.getId()));
        }
        return false;
    }
}
