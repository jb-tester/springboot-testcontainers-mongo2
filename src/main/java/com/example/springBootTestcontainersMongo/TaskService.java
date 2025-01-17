package com.example.springBootTestcontainersMongo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
@Transactional
    public void populateDb(){

        List<Task> tasks = List.of(
        new Task(UUID.randomUUID(), "task1", new Date(2022, Calendar.JANUARY, 1),"created")
        , new Task(UUID.randomUUID(), "task2", new Date(2022, Calendar.MARCH, 8),"created")
        , new Task(UUID.randomUUID(), "task3", new Date(2023, Calendar.MAY, 9),"created")
        , new Task(UUID.randomUUID(), "task4", new Date(2024, Calendar.OCTOBER, 19),"created")
        , new Task(UUID.randomUUID(), "task5", new Date(2023, Calendar.FEBRUARY, 12),"created"));
        taskRepository.saveAll(tasks);
    }
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    public List<Task> getTasksByState(String state){
        return taskRepository.getTasksByState(state);
    }
}
