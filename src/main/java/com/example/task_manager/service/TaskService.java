package com.example.task_manager.service;

import com.example.task_manager.model.TaskManager;
import com.example.task_manager.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepo;

    public void saveTask(TaskManager taskManager){
        taskRepo.saveTask(taskManager);
    }

    public List<TaskManager> getAllTask(){
        return taskRepo.getAllTask();
    }

    public void deleteTaskById(int id){
         taskRepo.deleteTaskById(id);
    }



    public void markTaskAsCompleted(int id) {
        taskRepo.markTaskAsCompleted(id);
    }
}
