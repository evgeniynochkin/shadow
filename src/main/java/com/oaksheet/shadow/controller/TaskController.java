package com.oaksheet.shadow.controller;

import com.oaksheet.shadow.model.Importance;
import com.oaksheet.shadow.model.Task;
import com.oaksheet.shadow.model.TasksTimeList;
import com.oaksheet.shadow.model.Typetask;
import com.oaksheet.shadow.repository.TaskRepository;
import com.oaksheet.shadow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/tasks")
    public String tasks(Model model) {
        Iterable<TasksTimeList> tasksTimeLists = taskRepository.findAll();
        model.addAttribute("tasks", tasksTimeLists);
        return "tasks";
    }

    @GetMapping("/addtask")
    public String addTask(Model model) {
        return "addtask";
    }

    @PostMapping("/addtask")
    public String addTask(@RequestParam String taskname, Model model) {
        Task task = new Task(taskname, Typetask.TIMETABLE, Importance.URGENTLY_IMPORTANTLY);
        return "tasks";
    }
}
