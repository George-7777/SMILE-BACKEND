package com.gvayt.smile_server.util;

import com.gvayt.smile_server.dto.parent.ParentDTO;
import com.gvayt.smile_server.dto.parent.ParentRegisterDTO;
import com.gvayt.smile_server.entity.Parent;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ParentMapper {
    public ParentDTO convertToPublicDto(Parent parent) {
        ParentDTO parentDTO = new ParentDTO();
        parentDTO.setId(parent.getId());
        parentDTO.setFio(parent.getFio());
        parentDTO.setEmail(parent.getEmail());
        return parentDTO;
    }

    public Parent toEntity(ParentRegisterDTO request) {
        Parent parent = new Parent();
        parent.setFio(request.getFio());
        parent.setEmail(request.getEmail());
        parent.setHashPassword(request.getPassword());
        return parent;
    }
}
