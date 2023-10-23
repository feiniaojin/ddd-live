package com.feiniaojin.ddd.live.ui.web.controller;

import com.feiniaojin.ddd.live.application.service.live.LiveCommandService;
import com.feiniaojin.ddd.live.application.service.live.LiveQueryService;
import com.feiniaojin.ddd.live.application.service.live.dto.LiveCreateCommand;
import com.feiniaojin.ddd.live.application.service.live.dto.LiveModifyBasicCommand;
import com.feiniaojin.ddd.live.application.service.live.dto.LiveQuery;
import com.feiniaojin.ddd.live.application.service.live.dto.LiveView;
import com.feiniaojin.gracefulresponse.data.PageBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/live")
public class LiveController {

    @Resource
    private LiveQueryService liveQueryService;

    @Resource
    private LiveCommandService commandService;

    @RequestMapping("/pageList")
    public PageBean<LiveView> pageList(LiveQuery query) {
        return liveQueryService.pageList(query);
    }

    @RequestMapping("/create")
    public void create(@RequestBody LiveCreateCommand command) {
        commandService.create(command);
    }

    @RequestMapping("/modifyBasic")
    public void modifyBasic(@RequestBody LiveModifyBasicCommand command) {
        commandService.modifyBasic(command);
    }
}
