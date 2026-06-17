package com.gvayt.smile_server.controller;

import com.gvayt.smile_server.dto.KidDTO;
import com.gvayt.smile_server.dto.KidRegisterDTO;
import com.gvayt.smile_server.dto.ParentDTO;
import com.gvayt.smile_server.dto.ParentRegisterDTO;
import com.gvayt.smile_server.service.KidService;
import com.gvayt.smile_server.service.ParentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<?> registerParent(@Valid @RequestBody ParentRegisterDTO request) {
        try {
            ParentDTO response = parentService.registerParent(request);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/register/kid")
    public ResponseEntity<?> registerKid(@Valid @RequestBody KidRegisterDTO request, Authentication authentication) {
        try {
            KidDTO response = kidService.registerKid(request, authentication.getName());
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/login/parent")
    public ResponseEntity<ParentDTO> loginParent(Authentication authentication) {
        return ResponseEntity.ok(parentService.getParentByEmail(authentication.getName()));
    }

    @GetMapping("/login/kid")
    public ResponseEntity<KidDTO> loginKid(Authentication authentication) {
        return ResponseEntity.ok(kidService.getKidByLogin(authentication.getName()));
    }
}
