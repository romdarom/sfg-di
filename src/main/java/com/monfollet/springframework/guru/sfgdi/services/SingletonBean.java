package com.monfollet.springframework.guru.sfgdi.services;

import org.springframework.stereotype.Service;

@Service
public class SingletonBean {
    public SingletonBean() {
        System.out.println("Creating singleton bean");
    }

    public void printScope() {
        System.out.println("I'm a singleton");
    }

}
