package com.example.springBootTestcontainersMongo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootTestcontainersMongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTestcontainersMongoApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(TaskService taskService) {
        return args -> {
            System.out.println("--------------------------------------");
            taskService.populateDb();
            taskService.getAllTasks().forEach(System.out::println);
            System.out.println("--------------------------------------");
        };
    }
}
