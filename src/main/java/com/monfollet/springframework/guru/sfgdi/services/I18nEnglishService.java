package com.monfollet.springframework.guru.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("EN")
@Service("i18nService")
public class I18nEnglishService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Greeting - EN";
    }
}
