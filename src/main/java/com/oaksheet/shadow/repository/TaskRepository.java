package com.oaksheet.shadow.repository;

import com.oaksheet.shadow.model.Task;
import com.oaksheet.shadow.model.TasksTimeList;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
    Task findById(TasksTimeList tasksTimeList);
}
