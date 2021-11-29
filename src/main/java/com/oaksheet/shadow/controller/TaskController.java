package com.oaksheet.shadow.controller;

import com.oaksheet.shadow.model.*;
import com.oaksheet.shadow.repository.TaskRepository;
import com.oaksheet.shadow.repository.TaskTimeListRepository;
import com.oaksheet.shadow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class TaskController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskTimeListRepository taskTimeListRepository;

    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/tasks")
    public String tasks(@AuthenticationPrincipal User user, Model model) {
        Iterable<TasksTimeList> tasksTimeLists = taskTimeListRepository.findAllByUser(user);
        List<Task> taskList = new ArrayList<>();
        for (TasksTimeList ttl : tasksTimeLists)
            taskList.add(ttl.getTask());
        model.addAttribute("timetasks", tasksTimeLists);
        model.addAttribute("tasks", taskList);
        return "tasks";
    }

    @GetMapping("/addtask")
    public String addTask(Model model) {
        List<Typetask> typetaskList = Arrays.asList(Typetask.values());
        model.addAttribute("typetasks", typetaskList);

        List<Importance> importanceList = Arrays.asList(Importance.values());
        model.addAttribute("importances", importanceList);

        List<RepitTask> repitTaskList = Arrays.asList(RepitTask.values());
        model.addAttribute("repits", repitTaskList);

        return "addtask";
    }

    @PostMapping("/addtask")
    public String addTask(@RequestParam String taskname,
                          @RequestParam String tasktext, Model model) {
        Task task = new Task(taskname, tasktext);
        taskRepository.save(task);
        return "tasks";
    }
}
