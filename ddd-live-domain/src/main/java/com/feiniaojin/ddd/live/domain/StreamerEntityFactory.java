package com.feiniaojin.ddd.live.domain;

public interface StreamerEntityFactory {
    StreamerEntity newInstance(String roomId, String streamerName, String avatar);
}
