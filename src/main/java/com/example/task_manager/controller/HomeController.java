package com.example.task_manager.controller;

import com.example.task_manager.model.TaskManager;
import com.example.task_manager.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @Autowired
    private TaskService taskService;

    @GetMapping({"","/","/home"})
    public String showHomePage(Model model){
        model.addAttribute("todo",new TaskManager());
        model.addAttribute("taskInfo", taskService.getAllTask());
        return "home";
    }

    @PostMapping("/save-task")
    public String saveTask( @ModelAttribute TaskManager taskManager){
        taskService.saveTask(taskManager);
        return "redirect:/home";

    }

    @GetMapping("/delete-task/{id}")
    public String deleteTask(@PathVariable int id){
        taskService.deleteTaskById(id);
        return "redirect:/home";
    }

    @GetMapping("/task-finished/{id}")
    public String taskCompleted(@PathVariable int id){
        taskService.markTaskAsCompleted(id);
        return "redirect:/home";
    }
}
