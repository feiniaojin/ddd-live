package com.feiniaojin.ddd.live.application.service.live;

import lombok.Data;

@Data
public class LiveView {
    private Long id;

    private String liveId;

    private Integer liveStatus;
}
