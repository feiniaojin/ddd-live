package com.feiniaojin.ddd.live.application.service.streamer;

import com.feiniaojin.ddd.live.application.service.streamer.dto.StreamerCreateCommand;
import com.feiniaojin.ddd.live.application.service.streamer.dto.StreamerModifyCommand;
import com.feiniaojin.ddd.live.domain.StreamerEntity;
import com.feiniaojin.ddd.live.domain.StreamerEntityFactory;
import com.feiniaojin.ddd.live.domain.StreamerEntityRepository;
import com.feiniaojin.ddd.live.domain.StreamerId;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StreamerCommandService {

    @Resource
    private StreamerEntityFactory factory;

    @Resource
    private StreamerEntityRepository repository;

    public void create(StreamerCreateCommand command) {

        StreamerEntity entity = factory.newInstance(command.getRoomId(),
                command.getStreamerName(),
                command.getAvatar());
        entity.create();
        repository.save(entity);
    }

    public void modify(StreamerModifyCommand command) {
        StreamerEntity entity = repository.load(new StreamerId(command.getStreamerId()));
        entity.modify(command.getStreamerName(), command.getAvatar());
        repository.save(entity);
    }
}
