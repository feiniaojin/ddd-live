package com.feiniaojin.ddd.live.ui.web.controller;

import com.feiniaojin.ddd.live.application.service.room.RoomCommandService;
import com.feiniaojin.ddd.live.application.service.room.RoomQueryService;
import com.feiniaojin.ddd.live.application.service.room.dto.RoomCreateCommand;
import com.feiniaojin.ddd.live.application.service.room.dto.RoomModifyCommand;
import com.feiniaojin.ddd.live.application.service.room.dto.RoomQuery;
import com.feiniaojin.ddd.live.application.service.room.dto.RoomView;
import com.feiniaojin.gracefulresponse.data.PageBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Resource
    private RoomQueryService queryService;

    @Resource
    private RoomCommandService commandService;

    @RequestMapping("/pageList")
    public PageBean<RoomView> pageList(RoomQuery query) {
        return queryService.pageList(query);
    }

    @RequestMapping("/create")
    public void create(RoomCreateCommand command) {
        commandService.create(command);
    }

    @RequestMapping("/modify")
    public void modify(RoomModifyCommand command) {
        commandService.modify(command);
    }
}
