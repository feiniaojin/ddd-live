package com.feiniaojin.ddd.live.domain;

public interface RoomEntityFactory {
    RoomEntity newInstance(String roomId, String roomName, String roomDescription, String cover);
}
