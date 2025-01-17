package com.example.springBootTestcontainersMongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Document
public class Task {
    @Id
    private UUID id;
    private String name;
    private Date startDate;
    private String state;

    public Task(UUID id, String name, Date startDate, String state) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.state = state;
    }

    /*public Task() {
    }*/

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", state='" + state + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(name, task.name) && Objects.equals(startDate, task.startDate) && Objects.equals(state, task.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startDate, state);
    }
}