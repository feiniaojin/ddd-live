package com.feiniaojin.ddd.live.application.service.live.dto;

import lombok.Data;

@Data
public class LiveCreateCommand {
    private String roomId;

    private String streamerId;

    private String description;

    private String planStartTime;

    private String planEndTime;
}
