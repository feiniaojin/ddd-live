package com.feiniaojin.ddd.live.domain;

import com.feiniaojin.ddd.AbstractDomainMask;
import lombok.Data;

import java.util.Date;

/**
 * 直播
 */
@Data
public class LiveEntity extends AbstractDomainMask {

    /**
     * 直播ID
     */
    private LiveId liveId;

    /**
     * 房间号
     */
    private String roomId;

    /**
     * 主播id
     */
    private String streamerId;

    /**
     * 直播介绍
     */
    private String description;

    /**
     * 计划开始时间
     */
    private Date planStartTime;

    /**
     * 计划结束时间
     */
    private Date planEndTime;

    /**
     * 直播状态,0未开播，1直播中，2已下播
     */
    private Integer liveStatus;

    public void create() {
        this.liveStatus = 0;
    }

    public void modifyBasic(String description, Date pst, Date pet) {
        this.description = description;
        this.planStartTime = pst;
        this.planEndTime = pet;
    }
}
