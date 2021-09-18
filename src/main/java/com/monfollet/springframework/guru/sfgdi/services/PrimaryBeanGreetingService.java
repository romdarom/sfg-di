package com.monfollet.springframework.guru.sfgdi.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class PrimaryBeanGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Greeting from PrimaryBeanGreetingService";
    }
}
