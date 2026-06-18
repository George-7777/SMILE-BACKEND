package com.gvayt.smile_server.service;

import com.gvayt.smile_server.dto.parent.ParentDTO;
import com.gvayt.smile_server.dto.parent.ParentRegisterDTO;

public interface ParentService {
    ParentDTO registerParent(ParentRegisterDTO parentRegisterDTO);
    ParentDTO getParentByEmail(String email);
}
