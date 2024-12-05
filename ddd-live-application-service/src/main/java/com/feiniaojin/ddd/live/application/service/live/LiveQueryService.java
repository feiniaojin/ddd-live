package com.feiniaojin.ddd.live.application.service.live;

import com.feiniaojin.ddd.live.application.service.live.dto.LiveQuery;
import com.feiniaojin.ddd.live.application.service.live.dto.LiveView;
import com.feiniaojin.ddd.live.domain.LiveStatusEnum;
import com.feiniaojin.ddd.live.domain.StreamGateway;
import com.feiniaojin.ddd.live.infrastructure.persistence.data.Live;
import com.feiniaojin.ddd.live.infrastructure.persistence.jdbc.LiveJdbcRepository;
import com.feiniaojin.ddd.live.infrastructure.persistence.mapper.LiveMapper;
import com.feiniaojin.gracefulresponse.data.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LiveQueryService {

    @Resource
    private StreamGateway streamGateway;

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
        paramMap.put("limitStart", (liveQuery.getPage() - 1) * liveQuery.getPageSize());
        paramMap.put("limitEnd", liveQuery.getPageSize());

        List<Live> liveList = liveMapper.pageList(paramMap);
        List<LiveView> views = this.dataToView(liveList);
        //填充推拉流地址（为了方便处理，直接在这里返回了，实际开发中一般单独提供接口获取推拉流地址）
        this.generateStreamUrl(views);
        pageBean.setList(views);
        pageBean.setTotal(count);
        return pageBean;
    }

    /**
     * 生成流相关地址
     *
     * @param views
     */
    private void generateStreamUrl(List<LiveView> views) {
        for (LiveView v : views) {
            v.setPushUrl(streamGateway.generatePushUrl(v.getLiveId()));
            v.setPullUrl(streamGateway.generatePullUrl(v.getLiveId()));
        }
    }

    private List<LiveView> dataToView(List<Live> liveList) {
        List<LiveView> views = new ArrayList<>(liveList.size());
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd -HH:mm:ss");
        for (Live live : liveList) {
            LiveView view = new LiveView();
            view.setId(live.getId());
            view.setLiveId(live.getLiveId());
            view.setLiveStatus(live.getLiveStatus());
            view.setStreamerId(live.getStreamerId());
            view.setRoomId(live.getRoomId());
            view.setDescription(live.getDescription());
            if (live.getPlanStartTime() != null) {
                view.setPlanStartTime(format.format(live.getPlanStartTime()));
            }
            if (live.getPlanEndTime() != null) {
                view.setPlanEndTime(format.format(live.getPlanEndTime()));
            }
            view.setLiveStatusShow(LiveStatusEnum.getNameByCode(live.getLiveStatus()));
            views.add(view);
        }
        return views;
    }
}
