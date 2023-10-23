package com.feiniaojin.ddd.live.domain;

import com.feiniaojin.ddd.AbstractDomainMask;
import lombok.Data;

/**
 * 主播
 */
@Data
public class StreamerEntity extends AbstractDomainMask {

    /**
     * 主播ID
     */
    private StreamerId streamerId;

    /**
     * 主播名称
     */
    private String streamerName;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 主播账号状态，0失效，1有效
     */
    private Integer streamerStatus;

    public void create() {
        this.streamerStatus = 1;
    }

    /**
     * 修改基础信息
     * @param streamerName
     * @param avatar
     */
    public void modify(String streamerName, String avatar) {
        this.streamerName = streamerName;
        this.avatar = avatar;
    }
}
