package com.feiniaojin.ddd.live.application.service.live;

import lombok.Data;

@Data
public class LiveQuery {
    private String liveId;

    private Integer page = 1;

    private Integer pageSize = 10;
}
