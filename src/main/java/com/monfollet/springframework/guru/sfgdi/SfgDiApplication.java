package com.monfollet.springframework.guru.sfgdi;

import com.monfollet.springframework.guru.sfgdi.controllers.*;
import com.monfollet.springframework.guru.sfgdi.domain.Counter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

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
    }

}
