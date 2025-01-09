package com.feiniaojin.ddd.live.application.service.room.dto;

import lombok.Data;

@Data
public class RoomView {
    private Long id;
    private String roomId;
    private String roomName;
    private String roomCover;
    private String roomDescription;
}
