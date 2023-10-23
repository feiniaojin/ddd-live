package com.feiniaojin.ddd.live.infrastructure.persistence;

import com.feiniaojin.ddd.live.domain.StreamerEntity;
import com.feiniaojin.ddd.live.domain.StreamerEntityRepository;
import com.feiniaojin.ddd.live.domain.StreamerId;
import com.feiniaojin.ddd.live.infrastructure.persistence.data.Streamer;
import com.feiniaojin.ddd.live.infrastructure.persistence.jdbc.StreamerJdbcRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class StreamerEntityRepositoryImpl implements StreamerEntityRepository {

    @Resource
    private StreamerJdbcRepository jdbcRepository;

    @Override
    public StreamerEntity load(StreamerId entityId) {

        Streamer data = jdbcRepository.queryOneByBizId(entityId.getValue());

        StreamerEntity entity = new StreamerEntity();
        entity.setStreamerId(entityId);
        entity.setStreamerName(data.getStreamerName());
        entity.setAvatar(data.getAvatar());
        entity.setStreamerStatus(data.getStreamerStatus());

        entity.setId(data.getId());
        entity.setDeleted(data.getDeleted());
        entity.setVersion(data.getVersion());
        entity.setCreatedTime(data.getCreatedTime());
        entity.setModifiedTime(data.getModifiedTime());

        return entity;
    }

    @Override
    public void save(StreamerEntity streamerEntity) {

        Streamer streamer = new Streamer();

        streamer.setStreamerId(streamerEntity.getStreamerId().getValue());
        streamer.setStreamerName(streamerEntity.getStreamerName());
        streamer.setAvatar(streamerEntity.getAvatar());
        streamer.setStreamerStatus(streamerEntity.getStreamerStatus());

        streamer.setId(streamerEntity.getId());
        streamer.setVersion(streamerEntity.getVersion());
        streamer.setCreatedTime(streamerEntity.getCreatedTime());
        streamer.setModifiedTime(streamerEntity.getModifiedTime());
        streamer.setDeleted(streamerEntity.getDeleted());

        jdbcRepository.save(streamer);
    }
}
