package com.oaksheet.shadow.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String taskName;
    private String taskText;
    private boolean notification;
//    private long timeNotification;
    private boolean isActive;

    @Enumerated
    private Typetask typesTask;

    @Enumerated
    private Importance importance;

    @ElementCollection(targetClass = RepitTask.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "repit_task", joinColumns = @JoinColumn(name = "tasks_id"))
    private Set<RepitTask> repitTasks;

    public Task() { }

    public Task(String taskName, String taskText) {
        this.taskName = taskName;
        this.taskText = taskText;
        this.notification = false;
        this.typesTask = Typetask.TASK;
        this.repitTasks.add(RepitTask.NONE);
        this.importance = Importance.URGENTLY_IMPORTANTLY;
        this.isActive = true;
    }
}
