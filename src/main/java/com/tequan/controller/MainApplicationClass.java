package com.tequan.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan({"com.tequan.service", "com.tequan.controller"})
@EntityScan("com.tequan.model")
@EnableJpaRepositories("com.tequan.repository")
public class MainApplicationClass {

    public static void main(String[] args) {
    	SpringApplication.run(MainApplicationClass.class, args);
    }

}