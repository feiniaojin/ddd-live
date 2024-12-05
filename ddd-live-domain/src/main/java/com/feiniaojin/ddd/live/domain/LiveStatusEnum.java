package com.feiniaojin.ddd.live.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum LiveStatusEnum {
    INIT(0, "待开播");
    private final int code;
    private final String name;

    private static final Map<Integer, String> m = Arrays.stream(LiveStatusEnum.values()).collect(
            Collectors.toMap(LiveStatusEnum::getCode, LiveStatusEnum::getName));

    LiveStatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String getNameByCode(int code) {
        String string = m.get(code);
        if (StringUtils.isBlank(string)) {
            throw new RuntimeException();
        }
        return string;
    }
}
