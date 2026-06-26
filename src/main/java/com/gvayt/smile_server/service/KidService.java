package com.gvayt.smile_server.service;

import com.gvayt.smile_server.dto.kid.KidDTO;
import com.gvayt.smile_server.dto.kid.KidRegisterDTO;

public interface KidService {
    KidDTO registerKid(KidRegisterDTO kidRegisterDTO, String parentEmail);
    KidDTO getKidByLogin(String login);
}
