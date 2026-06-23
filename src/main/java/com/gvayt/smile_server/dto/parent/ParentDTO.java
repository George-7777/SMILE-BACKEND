package com.gvayt.smile_server.dto.parent;

import com.gvayt.smile_server.dto.kid.KidDTO;
import lombok.Data;

import java.util.List;

@Data
public class ParentDTO {
    private long id;
    private String fio;
    private String email;
    private List<KidDTO> kidList;
}
