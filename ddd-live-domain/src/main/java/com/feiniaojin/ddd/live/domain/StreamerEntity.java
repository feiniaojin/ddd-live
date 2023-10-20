package com.feiniaojin.ddd.live.domain;

import com.feiniaojin.ddd.AbstractDomainMask;

/**
 * 主播
 */
public class StreamerEntity extends AbstractDomainMask {

    /**
     * 主播ID
     */
    private StreamerId streamerId;

    /**
     * 主播名称
     */
    private String streamerName;
}
