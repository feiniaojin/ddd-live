package com.feiniaojin.ddd.live.application.service.streamer.dto;

import lombok.Data;

@Data
public class StreamerQuery {
    private Integer page = 1;

    private Integer pageSize = 10;

    private String streamerId;
}
