package com.practice.multidbspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EntityScan("com.practice.multidbspringboot.*")
public class MultiDbSpringBootApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context=SpringApplication.run(MultiDbSpringBootApplication.class, args);
        System.out.println(context.getBeanDefinitionNames());
    }


}
