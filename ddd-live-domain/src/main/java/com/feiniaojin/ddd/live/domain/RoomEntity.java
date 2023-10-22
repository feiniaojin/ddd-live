package com.feiniaojin.ddd.live.domain;

import com.feiniaojin.ddd.AbstractDomainMask;
import lombok.Data;

/**
 * 直播间
 */
@Data
public class RoomEntity extends AbstractDomainMask {
    /**
     * 房间号
     */
    private RoomId roomId;
    /**
     * 房间名称
     */
    private String roomName;

    /**
     * 直播间封面
     */
    private String cover;

    /**
     * 房间状态，1有效，0失效
     */
    private Integer roomStatus;

    public void create() {
        this.roomStatus = 1;
    }

    public void modify(String roomName, String cover) {
        this.roomName = roomName;
        this.cover = cover;
    }
}
