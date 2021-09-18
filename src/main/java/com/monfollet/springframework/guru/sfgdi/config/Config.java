package com.monfollet.springframework.guru.sfgdi.config;

import com.monfollet.springframework.guru.sfgdi.domain.Counter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class Config {

    @Bean
    public Counter counter() {
        return new Counter();
    }
}
