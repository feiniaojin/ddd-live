package com.feiniaojin.ddd.live.domain;

import com.feiniaojin.ddd.EntityId;

public class StreamerId implements EntityId<String> {

    private String value;

    public StreamerId() {
    }

    public StreamerId(String value) {
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
