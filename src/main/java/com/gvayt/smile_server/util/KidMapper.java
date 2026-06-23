package com.gvayt.smile_server.util;

import com.gvayt.smile_server.dto.kid.KidDTO;
import com.gvayt.smile_server.dto.kid.KidRegisterDTO;
import com.gvayt.smile_server.entity.Kid;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;

@UtilityClass
public class KidMapper {
    public KidDTO convertToDto(Kid kid) {
        KidDTO kidDTO = new KidDTO();
        kidDTO.setId(kid.getId());
        kidDTO.setFio(kid.getFio());
        kidDTO.setLogin(kid.getLogin());
        kidDTO.setParent_id(kid.getParent().getId());
        kidDTO.setTasks(kid.getTasks().stream().map(TaskMapper::convertToDto).toList());

        return kidDTO;
    }

    public Kid convertToEntity(KidRegisterDTO kidRegisterDTO) {
        Kid kid = new Kid();
        kid.setFio(kidRegisterDTO.getFio());
        kid.setLogin(kidRegisterDTO.getLogin());
        kid.setHashPassword(kidRegisterDTO.getPassword());
        kid.setTasks(new ArrayList<>());

        return kid;
    }
}
