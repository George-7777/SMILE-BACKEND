package com.gvayt.smile_server.service.impl;

import com.gvayt.smile_server.dto.kid.KidDTO;
import com.gvayt.smile_server.dto.kid.KidRegisterDTO;
import com.gvayt.smile_server.entity.Kid;
import com.gvayt.smile_server.exception.EmailNotFoundException;
import com.gvayt.smile_server.exception.KidAlreadyExitsException;
import com.gvayt.smile_server.exception.LoginNotFoundException;
import com.gvayt.smile_server.repository.KidRepository;
import com.gvayt.smile_server.repository.ParentRepository;
import com.gvayt.smile_server.service.KidService;
import com.gvayt.smile_server.util.KidMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class KidServiceImpl implements KidService {
    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private KidRepository kidRepository;

    @Override
    public KidDTO registerKid(KidRegisterDTO kidRegisterDTO, String parentEmail) {
        if (kidRepository.findByLogin(kidRegisterDTO.getLogin()).isPresent()) {
            throw new KidAlreadyExitsException(kidRegisterDTO.getLogin());
        }
        Kid kid = KidMapper.convertToEntity(kidRegisterDTO);
        kid.setHashPassword(passwordEncoder.encode(kidRegisterDTO.getPassword()));
        kid.setParent(parentRepository.findByEmail(parentEmail).orElseThrow(
                () -> new EmailNotFoundException(parentEmail)
        ));
        Kid saved = kidRepository.save(kid);

        return KidMapper.convertToDto(saved);
    }

    @Override
    public KidDTO getKidByLogin(String login) {
        return KidMapper.convertToDto(kidRepository.findByLogin(login).orElseThrow(
                () -> new LoginNotFoundException(login)
        ));
    }
}
