package com.feiniaojin.ddd.live.application.service.streamer;

import com.feiniaojin.ddd.live.application.service.streamer.dto.StreamerQuery;
import com.feiniaojin.ddd.live.application.service.streamer.dto.StreamerView;
import com.feiniaojin.ddd.live.infrastructure.persistence.data.Streamer;
import com.feiniaojin.ddd.live.infrastructure.persistence.mapper.StreamerMapper;
import com.feiniaojin.gracefulresponse.data.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StreamerQueryService {

    @Resource
    private StreamerMapper streamerMapper;

    public PageBean<StreamerView> pageList(StreamerQuery query) {
        PageBean<StreamerView> pageBean = new PageBean<>();
        pageBean.setPage(query.getPage());
        pageBean.setPageSize(query.getPageSize());

        Map<String, Object> paramMap = new HashMap<>();

        int count = streamerMapper.countForPageList(paramMap);
        pageBean.setTotal(count);
        if (count == 0) {
            return pageBean;
        }

        paramMap.put("limitStart", (query.getPage() - 1) * query.getPageSize());
        paramMap.put("limitEnd", query.getPageSize());

        if (StringUtils.isNoneBlank(query.getStreamerId())) {
            paramMap.put("streamerId", query.getStreamerId());
        }
        List<Streamer> dataList = streamerMapper.pageList(paramMap);
        List<StreamerView> views = this.dataToView(dataList);
        pageBean.setList(views);
        pageBean.setTotal(count);
        return pageBean;
    }

    private List<StreamerView> dataToView(List<Streamer> dataList) {
        List<StreamerView> views = new ArrayList<>(dataList.size());

        for (Streamer e : dataList) {
            StreamerView view = new StreamerView();
            view.setId(e.getId());
            view.setStreamerId(e.getStreamerId());
            view.setStreamerName(e.getStreamerName());
            views.add(view);
        }
        return views;
    }
}
