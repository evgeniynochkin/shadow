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

    @ElementCollection(targetClass = Typetask.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "type_task", joinColumns = @JoinColumn(name = "tasks_id"))
    private Set<Typetask> typesTask;

    @ElementCollection(targetClass = Repit.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "repit", joinColumns = @JoinColumn(name = "tasks_id"))
    private Set<Repit> repits;

    @ElementCollection(targetClass = Importance.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "importance", joinColumns = @JoinColumn(name = "tasks_id"))
    private Set<Importance> importances;

    public Task() { }

    public Task(String taskName, Set<Typetask> typesTask, Set<Importance> importances) {
        this.taskName = taskName;
        this.notification = false;
        this.typesTask = typesTask;
        this.repits.add(Repit.NONE);
        this.importances = importances;
        this.isActive = true;
    }
}
