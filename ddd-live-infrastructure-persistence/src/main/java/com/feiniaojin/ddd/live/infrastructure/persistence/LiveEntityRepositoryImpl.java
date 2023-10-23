package com.feiniaojin.ddd.live.infrastructure.persistence;

import com.feiniaojin.ddd.live.domain.LiveEntity;
import com.feiniaojin.ddd.live.domain.LiveEntityRepository;
import com.feiniaojin.ddd.live.domain.LiveId;
import com.feiniaojin.ddd.live.infrastructure.persistence.data.Live;
import com.feiniaojin.ddd.live.infrastructure.persistence.jdbc.LiveJdbcRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class LiveEntityRepositoryImpl implements LiveEntityRepository {

    @Resource
    private LiveJdbcRepository liveRepository;

    @Override
    public LiveEntity load(LiveId entityId) {
        String liveIdValue = entityId.getValue();
        Live live = liveRepository.queryOneByBizId(liveIdValue);
        LiveEntity entity = new LiveEntity();

        entity.setLiveId(entityId);
        entity.setLiveStatus(live.getLiveStatus());
        entity.setRoomId(live.getRoomId());
        entity.setPlanStartTime(live.getPlanStartTime());
        entity.setPlanEndTime(live.getPlanEndTime());
        entity.setDescription(live.getDescription());
        entity.setStreamerId(live.getStreamerId());

        //维护层超类型
        entity.setId(live.getId());
        entity.setDeleted(live.getDeleted());
        entity.setVersion(live.getVersion());
        entity.setCreatedTime(live.getCreatedTime());
        entity.setModifiedTime(live.getModifiedTime());

        return entity;
    }

    @Override
    public void save(LiveEntity liveEntity) {
        Live live = new Live();

        live.setRoomId(liveEntity.getRoomId());
        live.setStreamerId(liveEntity.getStreamerId());
        live.setLiveId(liveEntity.getLiveId().getValue());
        live.setPlanStartTime(liveEntity.getPlanStartTime());
        live.setPlanEndTime(liveEntity.getPlanEndTime());
        live.setDescription(liveEntity.getDescription());
        live.setLiveStatus(liveEntity.getLiveStatus());

        live.setId(liveEntity.getId());
        live.setDeleted(liveEntity.getDeleted());
        live.setVersion(liveEntity.getVersion());
        live.setCreatedTime(liveEntity.getCreatedTime());
        live.setModifiedTime(liveEntity.getModifiedTime());

        liveRepository.save(live);
    }
}
