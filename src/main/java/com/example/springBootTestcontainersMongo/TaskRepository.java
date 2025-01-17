package com.example.springBootTestcontainersMongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface TaskRepository extends MongoRepository<Task, UUID> {
    @Query(value = "{ 'startDate': { '$lte' : ?0 }}")
    List<Task> getTasksStartedBeforeDate(Date beforeDate);

    List<Task> getTasksByState(String state);
}
