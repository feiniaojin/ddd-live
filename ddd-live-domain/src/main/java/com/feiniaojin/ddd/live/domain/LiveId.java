package com.feiniaojin.ddd.live.domain;

import com.feiniaojin.ddd.EntityId;

public class LiveId implements EntityId<String> {

    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
