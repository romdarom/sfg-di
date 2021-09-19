package com.monfollet.springframework.guru.sfgdi.config;

import com.monfollet.springframework.guru.sfgdi.datasource.FakeDataSource;
import com.monfollet.springframework.guru.sfgdi.domain.Counter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class Config {

    @Bean
    FakeDataSource fakeDataSource(
            @Value("${guru.username}") final String username,
            @Value("${guru.password}") final String password,
            @Value("${guru.jdbcurl}") final String jdbcUrl) {
        final FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcUrl(jdbcUrl);
        return fakeDataSource;
    }

    @Bean
    public Counter counter() {
        return new Counter();
    }
}
