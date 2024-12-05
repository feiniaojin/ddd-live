package com.feiniaojin.ddd.live.domain;

/**
 * 对接音视频服务的防腐层
 */
public interface StreamGateway {
    /**
     * 生成推流地址
     * @param liveId 直播ID
     * @return 安全加固后的推流地址
     */
    String generatePushUrl(String liveId);

    /**
     * 生成拉流地址
     * @param liveId 直播ID
     * @return 安全加固后的拉流地址
     */
    String generatePullUrl(String liveId);

    /**
     * 禁流，一般禁止推流
     * @param liveId 直播ID
     */
    void forbiddenStream(LiveId liveId);
}
