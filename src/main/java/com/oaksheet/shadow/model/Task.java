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
    private long timeNotification;
    private boolean isActive;

    @Enumerated
    private Typetask typesTask;

    @Enumerated
    private Importance importance;

    @ElementCollection(targetClass = Repit.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "repit", joinColumns = @JoinColumn(name = "tasks_id"))
    private Set<Repit> repits;

    public Task() { }

    public Task(String taskName, Typetask typesTask, Importance importance) {
        this.taskName = taskName;
        this.notification = false;
        this.typesTask = typesTask;
        this.repits.add(Repit.NONE);
        this.importance = importance;
        this.isActive = true;
    }
}
