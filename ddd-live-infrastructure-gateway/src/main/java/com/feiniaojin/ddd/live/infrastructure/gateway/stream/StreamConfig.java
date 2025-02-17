package com.feiniaojin.ddd.live.infrastructure.gateway.stream;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@ConfigurationProperties(prefix = "ddd-live.stream")
@Data
public class StreamConfig {


    /**
     * 推流域名
     */
    private String pushDomain;

    /**
     * 拉流域名
     */
    private String pullDomain;

    /**
     * 直播APP名称
     */
    private String appName;

    /**
     * 过期时间
     */
    private Long expireTime = 7 * 24 * 3600L;

    /**
     * 推流密钥
     */
    private String pushKey;

    /**
     * 拉流token
     */
    private String pullKey;

    @PostConstruct
    public void init() {

    }
}
