package com.feiniaojin.ddd.live.domain;

/**
 * 对接音视频服务的防腐层
 */
public interface StreamGateway {
    String generatePushUrl(String streamId);

    String generatePullUrl(String streamId);
}
