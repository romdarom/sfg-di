package com.monfollet.springframework.guru.sfgdi.services;

import org.springframework.stereotype.Service;


public class ConstructorInjectedGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "greeting from ConstructorInjectedGreetingService";
    }
}
