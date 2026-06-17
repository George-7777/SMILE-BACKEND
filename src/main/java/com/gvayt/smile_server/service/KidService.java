package com.gvayt.smile_server.service;

import com.gvayt.smile_server.dto.KidDTO;
import com.gvayt.smile_server.dto.KidRegisterDTO;

public interface KidService {
    KidDTO registerKid(KidRegisterDTO kidRegisterDTO, String parentEmail);
    KidDTO getKidByLogin(String login);
}
