package com.example.springBootTestcontainersMongo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.*;

@Testcontainers
@SpringBootTest
public class MongoTest {

    @Container
    public static MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:latest"));



    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
        registry.add("spring.data.mongodb.database", () -> "testdb");
        System.out.println(mongoDBContainer.getReplicaSetUrl("testdb"));
    }

    // just to avoid its initialization
    @MockitoBean
    CommandLineRunner commandLineRunner;

    @Autowired
    private TaskRepository repository;

    @Test
    public void checkTasksByDate(){

        Task Task1 = new Task(UUID.randomUUID(), "test task1", new Date(2022, Calendar.DECEMBER, 15),"created");
        Task Task2 = new Task(UUID.randomUUID(), "test task2", new Date(2023, Calendar.MAY, 8),"created");
        repository.save(Task1);
        repository.save(Task2);
        System.out.println("*********** tasks: ******************");
        for (Task task : repository.findAll()) {
            System.out.println(task);
        }
        System.out.println("*************************************");
        Date deadline = new Date(2023, Calendar.JANUARY,1);

        List<Task> Tasks = new ArrayList<>();
        repository.getTasksStartedBeforeDate(deadline).forEach(p -> Tasks.add(p));

        Assertions.assertThat(Tasks).hasSize(1);
        Assertions.assertThat(Tasks.get(0).getName()).isEqualTo("test task1");
    }

}
