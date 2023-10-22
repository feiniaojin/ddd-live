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
        return entity;
    }

    @Override
    public void save(LiveEntity liveEntity) {
        Live live = new Live();
        //
        live.setId(liveEntity.getId());

        liveRepository.save(live);
    }
}
