package com.feiniaojin.ddd.live.infrastructure.gateway.stream;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LiveUrlGenerator {

    /**
     * 计算md5
     *
     * @param param
     * @return
     */
    public static String md5(String param) {
        if (param == null || param.length() == 0) {
            return null;
        }
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(param.getBytes());
            byte[] byteArray = md5.digest();

            BigInteger bigInt = new BigInteger(1, byteArray);
            // 参数16表示16进制
            String result = bigInt.toString(16);
            // 不足32位高位补零
            while (result.length() < 32) {
                result = "0" + result;
            }
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成推流地址
     *
     * @param pushDomain 推流域名
     * @param pushKey    推流域名配置的鉴权Key
     * @param appName    推流AppName
     * @param streamName 推流StreamName
     * @param expireTime 过期时间（单位是秒）
     */
    public static String generatePushUrl(String pushDomain, String pushKey, String appName, String streamName, long expireTime) {
        String pushUrl = "";
        //推流域名未开启鉴权功能的情况下
        if (StringUtils.isBlank(pushKey)) {
            pushUrl = "rtmp://" + pushDomain + "/" + appName + "/" + streamName;
        } else {
            long timeStamp = System.currentTimeMillis() / 1000L + expireTime;
            String stringToMd5 = "/" + appName + "/" + streamName + "-" + Long.toString(timeStamp) + "-0-0-" + pushKey;
            String authKey = md5(stringToMd5);
            pushUrl = "rtmp://" + pushDomain + "/" + appName + "/" + streamName + "?auth_key=" + Long.toString(timeStamp) + "-0-0-" + authKey;
        }
//        System.out.println("推流地址是： " + pushUrl);
        return pushUrl;
    }

    /**
     * 生成rtmp播放地址
     *
     * @param pullDomain 播放域名
     * @param pullKey    播放鉴权Key
     * @param appName    播放appName（同推流appName)
     * @param streamName 播放streamName，播放源流时，streamName 同推流streamName；播放转码流时，streamName 为推流streamName_{转码模板ID}
     * @param expireTime 过期时间（单位是秒）
     */
    public static String generalPullUrlRtmp(String pullDomain, String pullKey, String appName, String streamName, long expireTime) {
        String rtmpUrl = ""; //rtmp的拉流地址
        //播放域名未配置鉴权Key的情况下
        if (StringUtils.isBlank(pullKey)) {
            rtmpUrl = "rtmp://" + pullDomain + "/" + appName + "/" + streamName;
        } else {
            long timeStamp = System.currentTimeMillis() / 1000L + expireTime;
            String rtmpToMd5 = "/" + appName + "/" + streamName + "-" + Long.toString(timeStamp) + "-0-0-" + pullKey;
            String rtmpAuthKey = md5(rtmpToMd5);
            rtmpUrl = "rtmp://" + pullDomain + "/" + appName + "/" + streamName + "?auth_key=" + Long.toString(timeStamp) + "-0-0-" + rtmpAuthKey;
        }
//        System.out.println("RTMP播放地址为： " + rtmpUrl);
        return rtmpUrl;
    }

    /**
     * 生成Flv播放地址
     *
     * @param pullDomain 播放域名
     * @param pullKey    播放鉴权Key
     * @param appName    播放appName（同推流appName)
     * @param streamName 播放streamName，播放源流时，streamName 同推流streamName；播放转码流时，streamName 为推流streamName_{转码模板ID}
     * @param expireTime 过期时间（单位是秒）
     */
    public static String generalPullUrlFlv(String pullDomain, String pullKey, String appName, String streamName, long expireTime) {
        String flvUrl = ""; //flv的拉流地址
        //播放域名未配置鉴权Key的情况下
        if (StringUtils.isBlank(pullKey)) {
            flvUrl = "http://" + pullDomain + "/" + appName + "/" + streamName + ".flv";
        } else {
            long timeStamp = System.currentTimeMillis() / 1000L + expireTime;
            String flvToMd5 = "/" + appName + "/" + streamName + ".flv-" + Long.toString(timeStamp) + "-0-0-" + pullKey;
            String flvAuthKey = md5(flvToMd5);
            flvUrl = "http://" + pullDomain + "/" + appName + "/" + streamName + ".flv" + "?auth_key=" + Long.toString(timeStamp) + "-0-0-" + flvAuthKey;
        }
        return flvUrl;
    }

    /**
     * 生成播放地址
     *
     * @param pullDomain 播放域名
     * @param pullKey    播放鉴权Key
     * @param appName    播放appName（同推流appName)
     * @param streamName 播放streamName，播放源流时，streamName 同推流streamName；播放转码流时，streamName 为推流streamName_{转码模板ID}
     * @param expireTime 过期时间（单位是秒）
     */
    public static void general_pull_url(String pullDomain, String pullKey, String appName, String streamName, long expireTime) {
        String rtmpUrl = ""; //rtmp的拉流地址
        String hlsUrl = ""; //m3u8的拉流地址
        String flvUrl = ""; //flv的拉流地址
        //播放域名未配置鉴权Key的情况下
        if (pullKey == "") {
            rtmpUrl = "rtmp://" + pullDomain + "/" + appName + "/" + streamName;
            hlsUrl = "http://" + pullDomain + "/" + appName + "/" + streamName + ".m3u8";
            flvUrl = "http://" + pullDomain + "/" + appName + "/" + streamName + ".flv";
        } else {
            long timeStamp = System.currentTimeMillis() / 1000L + expireTime;
            String rtmpToMd5 = "/" + appName + "/" + streamName + "-" + Long.toString(timeStamp) + "-0-0-" + pullKey;
            String rtmpAuthKey = md5(rtmpToMd5);
            rtmpUrl = "rtmp://" + pullDomain + "/" + appName + "/" + streamName + "?auth_key=" + Long.toString(timeStamp) + "-0-0-" + rtmpAuthKey;

            String hlsToMd5 = "/" + appName + "/" + streamName + ".m3u8-" + Long.toString(timeStamp) + "-0-0-" + pullKey;
            String hlsAuthKey = md5(hlsToMd5);
            hlsUrl = "http://" + pullDomain + "/" + appName + "/" + streamName + ".m3u8" + "?auth_key=" + Long.toString(timeStamp) + "-0-0-" + hlsAuthKey;

            String flvToMd5 = "/" + appName + "/" + streamName + ".flv-" + Long.toString(timeStamp) + "-0-0-" + pullKey;
            String flvAuthKey = md5(flvToMd5);
            flvUrl = "http://" + pullDomain + "/" + appName + "/" + streamName + ".flv" + "?auth_key=" + Long.toString(timeStamp) + "-0-0-" + flvAuthKey;
        }
        System.out.println("RTMP播放地址为： " + rtmpUrl);
        System.out.println("m3u8播放地址为： " + hlsUrl);
        System.out.println("flv播放地址为： " + flvUrl);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //生成长度为5的随机字符串作为appName和streamName（字母和数字组合）
        String appName = RandomStringUtils.randomAlphanumeric(5);
        String streamName = RandomStringUtils.randomAlphanumeric(5);


        long expireTime = 24 * 3600L;
        String pullDomain = "pull.live.feiniaojin.com";
        String pullKey = System.getenv("ddd-live.pull-key");
        System.out.println("pullKey=" + pullKey);
        String pushDomain = "push.live.feiniaojin.com";
        String pushKey = System.getenv("ddd-live.push-key");
        System.out.println("pushKey=" + pushKey);

        LiveUrlGenerator.general_pull_url(pullDomain, pullKey, appName, streamName, expireTime);
        LiveUrlGenerator.generatePushUrl(pushDomain, pushKey, appName, streamName, expireTime);
    }
}
