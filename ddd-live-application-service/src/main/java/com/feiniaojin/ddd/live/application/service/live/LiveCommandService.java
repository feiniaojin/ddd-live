package com.feiniaojin.ddd.live.application.service.live;

import com.feiniaojin.ddd.live.application.service.live.dto.LiveCreateCommand;
import com.feiniaojin.ddd.live.application.service.live.dto.LiveModifyBasicCommand;
import com.feiniaojin.ddd.live.domain.LiveEntity;
import com.feiniaojin.ddd.live.domain.LiveEntityFactory;
import com.feiniaojin.ddd.live.domain.LiveEntityRepository;
import com.feiniaojin.ddd.live.domain.LiveId;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class LiveCommandService {

    @Resource
    private LiveEntityFactory entityFactory;

    @Resource
    private LiveEntityRepository entityRepository;

    public void create(LiveCreateCommand command) {

        LiveEntity entity = entityFactory.newInstance(command.getRoomId(),
                command.getStreamerId(),
                command.getDescription(),
                command.getPlanStartTime(),
                command.getPlanEndTime());
        entity.create();

        entityRepository.save(entity);
    }

    public void modifyBasic(LiveModifyBasicCommand command) {
        LiveEntity liveEntity = entityRepository.load(new LiveId(command.getLiveId()));
        Date pst = this.stringToTime(command.getPlanStartTime());
        Date pet = this.stringToTime(command.getPlanEndTime());
        liveEntity.modifyBasic(command.getDescription(), pst, pet);
        entityRepository.save(liveEntity);
    }

    private Date stringToTime(String inputTimeString) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return dateFormat.parse(inputTimeString);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
