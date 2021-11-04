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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Controller
public class TaskController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskTimeListRepository taskTimeListRepository;

    @GetMapping("/tasks")
    public String tasks(@AuthenticationPrincipal User user, Model model) {
        Iterable<TasksTimeList> tasksTimeLists = taskTimeListRepository.findAllByUser(user);

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
