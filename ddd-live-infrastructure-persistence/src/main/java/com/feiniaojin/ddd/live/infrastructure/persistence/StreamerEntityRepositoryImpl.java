package com.feiniaojin.ddd.live.infrastructure.persistence;

import com.feiniaojin.ddd.live.domain.StreamerEntity;
import com.feiniaojin.ddd.live.domain.StreamerEntityRepository;
import com.feiniaojin.ddd.live.domain.StreamerId;
import org.springframework.stereotype.Component;

@Component
public class StreamerEntityRepositoryImpl implements StreamerEntityRepository {
    @Override
    public StreamerEntity load(StreamerId entityId) {
        return null;
    }

    @Override
    public void save(StreamerEntity streamerEntity) {

    }
}
