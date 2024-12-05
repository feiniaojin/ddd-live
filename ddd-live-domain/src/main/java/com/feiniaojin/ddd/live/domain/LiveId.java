package com.feiniaojin.ddd.live.domain;

import com.feiniaojin.ddd.EntityId;
import org.apache.commons.lang3.StringUtils;

public class LiveId implements EntityId<String> {

    private String value;

    public LiveId() {
    }

    public LiveId(String value) {
        if (StringUtils.isBlank(value)) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
