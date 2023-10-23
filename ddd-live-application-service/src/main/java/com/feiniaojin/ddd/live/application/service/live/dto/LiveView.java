package com.feiniaojin.ddd.live.application.service.live.dto;

import lombok.Data;

@Data
public class LiveView {
    private Long id;

    private String roomId;

    private String StreamerId;

    private String liveId;

    private String description;

    private Integer liveStatus;

    /**
     * 推流地址
     */
    private String pushUrl;

    /**
     * 拉流地址
     */
    private String pullUrl;
}
