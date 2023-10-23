package com.feiniaojin.ddd.live.domain;

public interface LiveEntityFactory {
    LiveEntity newInstance(String roomId,
                           String streamerId,
                           String description,
                           String planStartTime,
                           String planEndTime);
}
