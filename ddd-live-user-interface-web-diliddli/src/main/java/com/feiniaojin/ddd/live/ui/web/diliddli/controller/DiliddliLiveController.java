package com.feiniaojin.ddd.live.ui.web.diliddli.controller;

import com.feiniaojin.ddd.live.application.service.live.LiveCommandService;
import com.feiniaojin.ddd.live.application.service.live.LiveQueryService;
import com.feiniaojin.ddd.live.application.service.live.dto.LiveQuery;
import com.feiniaojin.ddd.live.application.service.live.dto.LiveView;
import com.feiniaojin.gracefulresponse.data.PageBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/diliddli/live")
public class DiliddliLiveController {

    @Resource
    private LiveQueryService liveQueryService;

    @Resource
    private LiveCommandService commandService;

    @RequestMapping("/pageList")
    public PageBean<LiveView> pageList(LiveQuery query) {
        return liveQueryService.pageList(query);
    }

    @RequestMapping("/get")
    public LiveView get(LiveQuery query) {
        return liveQueryService.get(query);
    }
}
