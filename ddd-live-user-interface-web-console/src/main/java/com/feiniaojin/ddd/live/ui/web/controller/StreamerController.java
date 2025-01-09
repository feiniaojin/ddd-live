package com.feiniaojin.ddd.live.ui.web.controller;

import com.feiniaojin.ddd.live.application.service.streamer.StreamerCommandService;
import com.feiniaojin.ddd.live.application.service.streamer.dto.StreamerCreateCommand;
import com.feiniaojin.ddd.live.application.service.streamer.dto.StreamerModifyCommand;
import com.feiniaojin.ddd.live.application.service.streamer.dto.StreamerQuery;
import com.feiniaojin.ddd.live.application.service.streamer.StreamerQueryService;
import com.feiniaojin.ddd.live.application.service.streamer.dto.StreamerView;
import com.feiniaojin.gracefulresponse.data.PageBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/streamer")
public class StreamerController {

    @Resource
    private StreamerQueryService queryService;

    @Resource
    private StreamerCommandService commandService;

    @RequestMapping("/pageList")
    public PageBean<StreamerView> pageList(StreamerQuery query) {
        return queryService.pageList(query);
    }

    @RequestMapping("/create")
    public void create(@RequestBody StreamerCreateCommand command) {
        commandService.create(command);
    }

    @RequestMapping("/modify")
    public void modify(@RequestBody StreamerModifyCommand command) {
        commandService.modify(command);
    }
}
