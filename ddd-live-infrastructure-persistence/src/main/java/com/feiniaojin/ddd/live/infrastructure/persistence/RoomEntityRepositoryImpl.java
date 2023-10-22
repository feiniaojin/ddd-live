package com.feiniaojin.ddd.live.infrastructure.persistence;

import com.feiniaojin.ddd.live.domain.RoomEntity;
import com.feiniaojin.ddd.live.domain.RoomEntityRepository;
import com.feiniaojin.ddd.live.domain.RoomId;
import com.feiniaojin.ddd.live.infrastructure.persistence.data.Room;
import com.feiniaojin.ddd.live.infrastructure.persistence.jdbc.RoomJdbcRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RoomEntityRepositoryImpl implements RoomEntityRepository {

    @Resource
    private RoomJdbcRepository roomJdbcRepository;

    @Override
    public RoomEntity load(RoomId entityId) {

        Room room = roomJdbcRepository.queryOneByBizId(entityId.getValue());

        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setRoomName(room.getRoomName());
        roomEntity.setRoomId(entityId);
        roomEntity.setCover(room.getCover());

        return roomEntity;
    }

    @Override
    public void save(RoomEntity roomEntity) {
        Room room = new Room();
        room.setId(roomEntity.getId());
        room.setRoomId(roomEntity.getRoomId().getValue());
        room.setRoomName(roomEntity.getRoomName());
        room.setCover(roomEntity.getCover());
        roomJdbcRepository.save(room);
    }
}
