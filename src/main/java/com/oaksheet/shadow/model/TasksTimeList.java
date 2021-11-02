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

}
