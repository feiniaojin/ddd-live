package com.feiniaojin.ddd.live.domain;

import com.feiniaojin.ddd.EntityId;

public class RoomId implements EntityId<String> {

    private String value;


    public RoomId() {
    }

    public RoomId(String value) {
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
