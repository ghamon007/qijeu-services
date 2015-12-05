package com.game.qijeu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class QijeuServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(QijeuServicesApplication.class, args);
    }
}
