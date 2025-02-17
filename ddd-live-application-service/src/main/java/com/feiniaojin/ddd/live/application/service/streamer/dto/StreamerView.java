package com.feiniaojin.ddd.live.application.service.streamer.dto;

import lombok.Data;

@Data
public class StreamerView {

    private Long id;
    /**
     * 主播号，业务主键
     */
    private String streamerId;
    /**
     * 主播名称
     */
    private String streamerName;

    private String avatar;

    private String roomId;

    /**
     * 主播状态，0禁用，1可用
     */
    private Integer streamerStatus;
}
