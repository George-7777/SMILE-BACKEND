package com.gvayt.smile_server.util;

import com.gvayt.smile_server.dto.KidDTO;
import com.gvayt.smile_server.dto.KidRegisterDTO;
import com.gvayt.smile_server.entity.Kid;
import lombok.experimental.UtilityClass;

@UtilityClass
public class KidMapper {
    public KidDTO convertToDto(Kid kid) {
        KidDTO kidDTO = new KidDTO();
        kidDTO.setId(kid.getId());
        kidDTO.setFio(kid.getFio());
        kidDTO.setLogin(kid.getLogin());
        kidDTO.setParent_id(kid.getParent().getId());

        return kidDTO;
    }

    public Kid convertToEntity(KidRegisterDTO kidRegisterDTO) {
        Kid kid = new Kid();
        kid.setFio(kidRegisterDTO.getFio());
        kid.setLogin(kidRegisterDTO.getLogin());
        kid.setHashPassword(kidRegisterDTO.getPassword());

        return kid;
    }
}
