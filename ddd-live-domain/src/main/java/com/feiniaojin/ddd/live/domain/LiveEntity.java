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
     * 计划开始时间
     */
    private Date planStartTime;

    /**
     * 计划结束时间
     */
    private Date planEndTime;

    /**
     * 直播状态
     */
    private Integer liveStatus;
}
