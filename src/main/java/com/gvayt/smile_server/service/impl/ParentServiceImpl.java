package com.gvayt.smile_server.service.impl;

import com.gvayt.smile_server.dto.parent.ParentDTO;
import com.gvayt.smile_server.dto.parent.ParentRegisterDTO;
import com.gvayt.smile_server.entity.Parent;
import com.gvayt.smile_server.exception.EmailNotFoundException;
import com.gvayt.smile_server.exception.ParentAlreadyExitsException;
import com.gvayt.smile_server.repository.ParentRepository;
import com.gvayt.smile_server.service.ParentService;
import com.gvayt.smile_server.util.ParentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ParentServiceImpl implements ParentService {
    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ParentDTO registerParent(ParentRegisterDTO parentRegisterDTO) {
        if (parentRepository.findByEmail(parentRegisterDTO.getEmail()).isPresent()) {
            throw new ParentAlreadyExitsException(parentRegisterDTO.getEmail());
        }
        Parent parent = ParentMapper.toEntity(parentRegisterDTO);
        parent.setHashPassword(passwordEncoder.encode(parent.getHashPassword()));
        Parent saved = parentRepository.save(parent);
        return ParentMapper.convertToPublicDto(saved);
    }

    @Override
    public ParentDTO getParentByEmail(String email) {
        return ParentMapper.convertToPublicDto(
                parentRepository.findByEmail(email).orElseThrow(() -> new EmailNotFoundException(email))
        );
    }
}
