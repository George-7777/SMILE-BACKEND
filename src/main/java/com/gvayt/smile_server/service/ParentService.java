package com.gvayt.smile_server.service;

import com.gvayt.smile_server.dto.ParentDTO;
import com.gvayt.smile_server.dto.ParentRegisterDTO;

public interface ParentService {
    ParentDTO registerParent(ParentRegisterDTO parentRegisterDTO);
    ParentDTO getParentByEmail(String email);
}
