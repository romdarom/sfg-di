package com.monfollet.springframework.guru.sfgdi.domain;

public class Counter {

    private static Integer count = 0;

    public Counter() {
        this.count = Counter.count + 1;
    }

    public Integer getCount() {
        return this.count;
    }
}
