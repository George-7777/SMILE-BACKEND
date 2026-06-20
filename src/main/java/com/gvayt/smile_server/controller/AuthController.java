package com.gvayt.smile_server.controller;

import com.gvayt.smile_server.dto.kid.KidDTO;
import com.gvayt.smile_server.dto.kid.KidRegisterDTO;
import com.gvayt.smile_server.dto.parent.ParentDTO;
import com.gvayt.smile_server.dto.parent.ParentRegisterDTO;
import com.gvayt.smile_server.exception.parent.EmailNotFoundException;
import com.gvayt.smile_server.exception.kid.LoginNotFoundException;
import com.gvayt.smile_server.service.KidService;
import com.gvayt.smile_server.service.ParentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final ParentService parentService;
    private final KidService kidService;

    @PostMapping("/register/parent")
    public ParentDTO registerParent(@Valid @RequestBody ParentRegisterDTO request) {
        return parentService.registerParent(request);
    }

    @PostMapping("/register/kid")
    public KidDTO registerKid(@Valid @RequestBody KidRegisterDTO request, Authentication authentication) {
        return kidService.registerKid(request, authentication.getName());
    }

    @GetMapping("/login/parent")
    public ParentDTO loginParent(Authentication authentication) {
        return parentService.getParentByEmail(authentication.getName());
    }

    @GetMapping("/login/kid")
    public KidDTO loginKid(Authentication authentication) {
        return kidService.getKidByLogin(authentication.getName());
    }
}
