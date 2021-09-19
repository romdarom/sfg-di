package com.monfollet.springframework.guru.sfgdi.services;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Service
public class PrototypeBean {
    public PrototypeBean() {
        System.out.println("Creating a prototype bean!!!!!!!!!!!!!!");
    }


    public void printScope() {
        System.out.println("I'm a prototype");
    }
}
