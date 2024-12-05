package com.feiniaojin.ddd.live.application.service.live.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LiveView {
    private Long id;

    private String roomId;

    private String StreamerId;

    private String liveId;

    private String description;

    private Integer liveStatus;

    private String liveStatusShow;

    /**
     * 计划开播时间
     */
    private String planStartTime;
    /**
     * 计划下播时间
     */
    private String planEndTime;

    /**
     * 推流地址
     */
    private String pushUrl;

    /**
     * 拉流地址
     */
    private String pullUrl;
}
