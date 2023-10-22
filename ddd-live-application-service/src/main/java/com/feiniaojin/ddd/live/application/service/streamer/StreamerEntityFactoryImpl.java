package com.feiniaojin.ddd.live.application.service.streamer;

import com.feiniaojin.ddd.live.domain.StreamerEntity;
import com.feiniaojin.ddd.live.domain.StreamerEntityFactory;
import com.feiniaojin.ddd.live.domain.StreamerId;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class StreamerEntityFactoryImpl implements StreamerEntityFactory {


    @Override
    public StreamerEntity newInstance(String roomId, String streamerName, String avatar) {
        StreamerEntity entity = new StreamerEntity();
        entity.setStreamerName(streamerName);
        entity.setAvatar(avatar);
        String streamerId = RandomStringUtils.random(12);
        entity.setStreamerId(new StreamerId(streamerId));
        return entity;
    }
}
