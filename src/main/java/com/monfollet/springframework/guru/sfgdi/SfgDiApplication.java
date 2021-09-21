package com.monfollet.springframework.guru.sfgdi;

import com.monfollet.springframework.guru.sfgdi.config.SfgConfiguration;
import com.monfollet.springframework.guru.sfgdi.config.SfgConfigurationConstructor;
import com.monfollet.springframework.guru.sfgdi.controllers.*;
import com.monfollet.springframework.guru.sfgdi.datasource.FakeDataSource;
import com.monfollet.springframework.guru.sfgdi.domain.Counter;
import com.monfollet.springframework.guru.sfgdi.services.PrototypeBean;
import com.monfollet.springframework.guru.sfgdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ConfigurationPropertiesScan
// <=> @EnableConfigurationProperties(SfgConfigurationConstructor.class)
@ComponentScan(basePackages = {"com.monfollet.springframework.guru.other", "com.monfollet.springframework.guru.sfgdi"})
@SpringBootApplication
public class SfgDiApplication {

    public static void main(final String[] args) {
        final ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);


        Counter counter = (Counter) ctx.getBean("counter");
        System.out.println("counter = " + counter.getCount());

        counter = (Counter) ctx.getBean("counter");
        System.out.println("counter = " + counter.getCount());

        final I18nController i18nController = (I18nController) ctx.getBean("i18nController");
        System.out.println("------- I18nController");
        System.out.println(i18nController.sayHello());

        final MyController myController = (MyController) ctx.getBean("myController");

        System.out.println("------- Primary Bean");
        System.out.println(myController.sayHello());

        System.out.println("------ Property");
        final PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("--------- Setter");
        final SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());

        System.out.println("-------- Constructor");
        final ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());


        System.out.println("-------- Singleton bean");
        SingletonBean singletonBean = (SingletonBean) ctx.getBean("singletonBean");
        singletonBean.printScope();
        System.out.println("-------- Singleton bean");
        singletonBean = (SingletonBean) ctx.getBean("singletonBean");
        singletonBean.printScope();

        System.out.println("-------- Prototype bean");
        PrototypeBean prototypeBean = (PrototypeBean) ctx.getBean("prototypeBean");
        prototypeBean.printScope();


        System.out.println("-------- Prototype bean");
        prototypeBean = (PrototypeBean) ctx.getBean("prototypeBean");
        prototypeBean.printScope();


        System.out.println("-------- Fake data source bean");
        final FakeDataSource fakeDS = (FakeDataSource) ctx.getBean("fakeDataSource");
        System.out.println("username: " + fakeDS.getUsername());
        System.out.println("password: " + fakeDS.getPassword());
        System.out.println("jdbcUrl: " + fakeDS.getJdbcUrl());

        System.out.println("-------- Config props bean");
        final SfgConfiguration configByPropsBean = (SfgConfiguration) ctx.getBean("sfgConfiguration");
        System.out.println("username: " + configByPropsBean.getUsername());
        System.out.println("password: " + configByPropsBean.getPassword());
        System.out.println("jdbcUrl: " + configByPropsBean.getJdbcUrl());


        System.out.println("-------- Config props by constructor bean");
        final SfgConfigurationConstructor sfgConfigurationConstructor = ctx.getBean(SfgConfigurationConstructor.class);
        System.out.println("username: " + sfgConfigurationConstructor.getUsername());
        System.out.println("password: " + sfgConfigurationConstructor.getPassword());
        System.out.println("jdbcUrl: " + sfgConfigurationConstructor.getJdbcUrl());
    }

}
