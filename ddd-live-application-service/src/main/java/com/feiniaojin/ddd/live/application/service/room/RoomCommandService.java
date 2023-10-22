package com.feiniaojin.ddd.live.application.service.room;

import com.feiniaojin.ddd.live.application.service.room.dto.RoomCreateCommand;
import com.feiniaojin.ddd.live.application.service.room.dto.RoomModifyCommand;
import com.feiniaojin.ddd.live.domain.RoomEntity;
import com.feiniaojin.ddd.live.domain.RoomEntityFactory;
import com.feiniaojin.ddd.live.domain.RoomEntityRepository;
import com.feiniaojin.ddd.live.domain.RoomId;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoomCommandService {

    @Resource
    private RoomEntityFactory factory;
    @Resource
    private RoomEntityRepository roomEntityRepository;

    public void create(RoomCreateCommand command) {
        RoomEntity roomEntity = factory.newInstance(command.getRoomId(), command.getRoomName(), command.getCover());
        roomEntity.create();
        roomEntityRepository.save(roomEntity);
    }

    public void modify(RoomModifyCommand command) {
        RoomEntity roomEntity = roomEntityRepository.load(new RoomId(command.getRoomId()));
        roomEntity.modify(command.getRoomName(), command.getCover());
        roomEntityRepository.save(roomEntity);
    }


}
