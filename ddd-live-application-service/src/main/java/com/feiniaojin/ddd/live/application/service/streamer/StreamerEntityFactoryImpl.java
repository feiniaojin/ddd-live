package com.feiniaojin.ddd.live.application.service.streamer;

import com.feiniaojin.ddd.live.domain.RoomId;
import com.feiniaojin.ddd.live.domain.StreamerEntity;
import com.feiniaojin.ddd.live.domain.StreamerEntityFactory;
import com.feiniaojin.ddd.live.domain.StreamerId;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class StreamerEntityFactoryImpl implements StreamerEntityFactory {


    @Override
    public StreamerEntity newInstance(String roomId,
                                      String streamerId,
                                      String streamerName,
                                      String avatar) {

        StreamerEntity entity = new StreamerEntity();

        entity.setStreamerId(new StreamerId(streamerId));
        entity.setStreamerName(streamerName);
        entity.setAvatar(avatar);
        entity.setRoomId(new RoomId(roomId));

        entity.setDeleted(0);
        Date date = new Date();
        entity.setCreatedTime(date);
        entity.setModifiedTime(date);

        return entity;
    }
}
