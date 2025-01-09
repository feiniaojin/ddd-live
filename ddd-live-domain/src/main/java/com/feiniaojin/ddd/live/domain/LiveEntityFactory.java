package com.feiniaojin.ddd.live.domain;

public interface LiveEntityFactory {
    LiveEntity newInstance(String roomId,
                           String streamerId,
                           String title,
                           String description,
                           String liveCover,
                           String planStartTime,
                           String planEndTime);
}
