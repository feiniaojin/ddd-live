package com.feiniaojin.ddd.live.application.service.live;

import com.feiniaojin.ddd.live.domain.LiveEntity;
import com.feiniaojin.ddd.live.domain.LiveEntityFactory;
import com.feiniaojin.ddd.live.domain.LiveId;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class LiveEntityFactoryImpl implements LiveEntityFactory {

    @Override
    public LiveEntity newInstance(String roomId,
                                  String streamerId,
                                  String description,
                                  String planStartTime,
                                  String planEndTime) {
        LiveEntity entity = new LiveEntity();

        String random = RandomStringUtils.randomAlphanumeric(9);
        entity.setLiveId(new LiveId(random));

        entity.setRoomId(roomId);
        entity.setStreamerId(streamerId);
        entity.setDescription(description);

        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            entity.setPlanStartTime(dateFormat.parse(planStartTime));
            entity.setPlanEndTime(dateFormat.parse(planEndTime));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        entity.setLiveStatus(0);
        Date date = new Date();
        entity.setCreatedTime(date);
        entity.setModifiedTime(date);
        return entity;
    }
}
