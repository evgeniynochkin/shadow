package com.oaksheet.shadow.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "taskstimelist")
public class TasksTimeList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date dateBegin;
    private Date dateFinish;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usermain_id")
    private User user;

    @OneToOne(fetch =  FetchType.EAGER)
    @JoinColumn(name = "task_id")
    private Task task;

    public TasksTimeList() {
    }

    public TasksTimeList(User user, Task task) {
        this.user = user;
        this.task = task;
    }
}
