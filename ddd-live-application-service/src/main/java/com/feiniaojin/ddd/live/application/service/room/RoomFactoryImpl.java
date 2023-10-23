package com.feiniaojin.ddd.live.application.service.room;

import com.feiniaojin.ddd.live.domain.RoomEntity;
import com.feiniaojin.ddd.live.domain.RoomEntityFactory;
import com.feiniaojin.ddd.live.domain.RoomId;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RoomFactoryImpl implements RoomEntityFactory {

    @Override
    public RoomEntity newInstance(String roomId, String roomName, String cover) {

        RoomEntity roomEntity = new RoomEntity();

        roomEntity.setRoomId(new RoomId(roomId));
        roomEntity.setRoomName(roomName);
        roomEntity.setCover(cover);

        roomEntity.setDeleted(0);
        Date date = new Date();
        roomEntity.setCreatedTime(date);
        roomEntity.setModifiedTime(date);
        return roomEntity;
    }
}
