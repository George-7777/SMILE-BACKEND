package com.gvayt.smile_server.controller;

import com.gvayt.smile_server.dto.kid.KidDTO;
import com.gvayt.smile_server.service.KidService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kids")
@RequiredArgsConstructor
public class KidController {
    private final KidService kidService;

    @GetMapping("/{username}")
    public KidDTO getKid(@Param("username") String username) {
        return kidService.getKidByLogin(username);
    }
}
