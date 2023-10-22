package com.feiniaojin.ddd.live.application.service.room.dto;

import lombok.Data;

@Data
public class RoomQuery {
    private Integer page = 1;
    private Integer pageSize = 10;

    private String roomId;
}
