package com.gvayt.smile_server.dto.kid;

import lombok.Data;

@Data
public class KidDTO {
    private long id;
    private String fio;
    private String login;
    private long parent_id;
}
