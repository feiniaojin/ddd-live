package com.feiniaojin.ddd.live.application.service.streamer.dto;

import lombok.Data;

@Data
public class StreamerCreateCommand {
    private String roomId;
    private String streamerName;
    private String avatar;
}
