package com.feiniaojin.ddd.live.application.service.room.dto;

import lombok.Data;

@Data
public class RoomModifyCommand {
    private String roomId;

    private String roomName;

    private String cover;
}
