package com.feiniaojin.ddd.live.application.service.room;

import com.feiniaojin.ddd.live.application.service.room.dto.RoomQuery;
import com.feiniaojin.ddd.live.application.service.room.dto.RoomView;
import com.feiniaojin.ddd.live.infrastructure.persistence.data.Room;
import com.feiniaojin.ddd.live.infrastructure.persistence.mapper.RoomMapper;
import com.feiniaojin.gracefulresponse.data.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoomQueryService {

    @Resource
    private RoomMapper roomMapper;

    public PageBean<RoomView> pageList(RoomQuery query) {

        PageBean<RoomView> pageBean = new PageBean<>();
        pageBean.setPage(query.getPage());
        pageBean.setPageSize(query.getPageSize());

        Map<String, Object> paramMap = new HashMap<>();

        if (StringUtils.isNoneBlank(query.getRoomId())) {
            paramMap.put("roomId", query.getRoomId());
        }

        int count = roomMapper.countForPageList(paramMap);
        pageBean.setTotal(count);
        if (count == 0) {
            return pageBean;
        }
        paramMap.put("limitStart", (query.getPage() - 1) * query.getPageSize());
        paramMap.put("limitEnd", query.getPageSize());

        List<Room> dataList = roomMapper.pageList(paramMap);
        List<RoomView> views = this.dataToView(dataList);
        pageBean.setList(views);
        pageBean.setTotal(count);
        return pageBean;
    }

    private List<RoomView> dataToView(List<Room> dataList) {
        List<RoomView> views = new ArrayList<>(dataList.size());

        for (Room e : dataList) {
            RoomView view = new RoomView();
            view.setId(e.getId());
            view.setRoomId(e.getRoomId());
            view.setRoomName(e.getRoomName());
            view.setRoomCover(e.getRoomCover());
            view.setRoomDescription(e.getRoomDescription());
            views.add(view);
        }
        return views;
    }

}
