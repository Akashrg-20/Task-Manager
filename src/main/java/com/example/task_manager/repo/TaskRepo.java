package com.example.task_manager.repo;

import com.example.task_manager.model.TaskManager;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TaskRepo {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void saveTask(TaskManager taskManager) {
        entityManager.persist(taskManager);
    }

    public List<TaskManager> getAllTask() {
        return entityManager.createQuery("FROM TaskManager", TaskManager.class).getResultList();
    }


    public void deleteTaskById(int id){
        TaskManager taskManager =entityManager.find(TaskManager.class,id);
        entityManager.remove(taskManager);

    }

    public void markTaskAsCompleted(int id) {
        String sql="UPDATE todo_tasks SET status=? WHERE id=?";
        jdbcTemplate.update(sql,"Completed",id);


    }
}
