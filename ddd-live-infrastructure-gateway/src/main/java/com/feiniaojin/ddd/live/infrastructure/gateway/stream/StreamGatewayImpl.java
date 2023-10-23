package com.feiniaojin.ddd.live.infrastructure.gateway.stream;

import com.feiniaojin.ddd.live.domain.StreamGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class StreamGatewayImpl implements StreamGateway {

    private final Logger logger = LoggerFactory.getLogger(StreamGatewayImpl.class);

    @Resource
    private StreamConfig streamConfig;

    @Override
    public String generatePushUrl(String streamId) {
        String pushDomain = streamConfig.getPushDomain();
        String pushKey = streamConfig.getPushKey();
        String appName = streamConfig.getAppName();
        Long expireTime = streamConfig.getExpireTime();
        String generatePushUrl = LiveUrlGenerator.generatePushUrl(pushDomain, pushKey, appName, streamId, expireTime);
        logger.debug("生成推流地址成功,streamId={},generatePushUrl={}", streamId, generatePushUrl);
        return generatePushUrl;
    }

    /**
     * 生成拉流地址
     * 默认生成flv格式的拉流地址
     *
     * @param streamId
     * @return
     */
    @Override
    public String generatePullUrl(String streamId) {
        String pullDomain = streamConfig.getPullDomain();
        String pullKey = streamConfig.getPullKey();
        String appName = streamConfig.getAppName();
        Long expireTime = streamConfig.getExpireTime();
        String pullUrlFlv = LiveUrlGenerator.generalPullUrlFlv(pullDomain, pullKey, appName, streamId, expireTime);
        logger.debug("生成拉地址成功,streamId={},generatePushUrl={}", streamId, pullUrlFlv);
        return pullUrlFlv;
    }
}
