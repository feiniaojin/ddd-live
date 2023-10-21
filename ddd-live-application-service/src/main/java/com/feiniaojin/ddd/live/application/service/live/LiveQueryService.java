package com.feiniaojin.ddd.live.application.service.live;

import com.feiniaojin.ddd.live.infrastructure.persistence.data.Live;
import com.feiniaojin.ddd.live.infrastructure.persistence.jdbc.LiveJdbcRepository;
import com.feiniaojin.ddd.live.infrastructure.persistence.mapper.LiveMapper;
import com.feiniaojin.gracefulresponse.data.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LiveQueryService {

    @Resource
    private LiveJdbcRepository liveJdbcRepository;

    @Resource
    private LiveMapper liveMapper;

    public PageBean<LiveView> pageList(LiveQuery liveQuery) {

        PageBean<LiveView> pageBean = new PageBean<>();
        pageBean.setPage(liveQuery.getPage());
        pageBean.setPageSize(liveQuery.getPageSize());

        Map<String, Object> paramMap = new HashMap<>();

        int count = liveMapper.countForPageList(paramMap);
        pageBean.setTotal(count);
        if (count == 0) {
            return pageBean;
        }

        List<Live> liveList = liveMapper.pageList(paramMap);
        List<LiveView> views = this.dataToView(liveList);
        pageBean.setList(views);
        pageBean.setTotal(count);
        return pageBean;
    }

    private List<LiveView> dataToView(List<Live> liveList) {
        List<LiveView> views = new ArrayList<>(liveList.size());

        for (Live live : liveList) {
            LiveView view = new LiveView();
            view.setId(live.getId());
            view.setLiveId(live.getLiveId());
            views.add(view);
        }
        return views;
    }
}
