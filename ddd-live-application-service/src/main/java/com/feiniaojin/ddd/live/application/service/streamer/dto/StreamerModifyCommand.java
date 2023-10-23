package com.feiniaojin.ddd.live.application.service.streamer.dto;

import lombok.Data;

@Data
public class StreamerModifyCommand {

    private String streamerId;
    private String roomId;
    private String streamerName;
    private String avatar;
}
