package com.example.springBootTestcontainersMongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MongoDBContainer;

@TestConfiguration(proxyBeanMethods = false)
public class AppTest {

    @Bean
    @ServiceConnection
    MongoDBContainer mongoDbContainer() {
        MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:latest").withExposedPorts(27017);
        mongoDBContainer.start();
        System.out.println(mongoDBContainer.getReplicaSetUrl());
        return mongoDBContainer;

    }

    public static void main(String[] args) {
        SpringApplication.from(SpringbootTestcontainersMongoApplication::main).with(AppTest.class).run(args);
    }



}
