package com.example.task_manager.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "todo_tasks")
public class TaskManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String task;
    private String status="In progress";
}
