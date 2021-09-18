package com.monfollet.springframework.guru.sfgdi.services;

import org.springframework.stereotype.Service;

@Service
public class SetterInjectedGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "greetings from SetterInjectedGreetingService";
    }
}
