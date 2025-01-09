package com.feiniaojin.ddd.live.application.service.live.dto;

import lombok.Data;

@Data
public class LiveModifyBasicCommand {

    private String liveId;

    private String description;

    private String liveCover;

    private String planStartTime;

    private String planEndTime;
}
