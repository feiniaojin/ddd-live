package com.feiniaojin.ddd.live.ui.web.controller;

import com.feiniaojin.ddd.live.application.service.live.LiveQuery;
import com.feiniaojin.ddd.live.application.service.live.LiveQueryService;
import com.feiniaojin.ddd.live.application.service.live.LiveView;
import com.feiniaojin.gracefulresponse.data.PageBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/live")
public class LiveController {

    @Resource
    private LiveQueryService liveQueryService;

    @RequestMapping("/pageList")
    public PageBean<LiveView> pageList(LiveQuery query) {
        return liveQueryService.pageList(query);
    }


}
