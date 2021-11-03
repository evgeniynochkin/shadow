package com.oaksheet.shadow.repository;

import com.oaksheet.shadow.model.TasksTimeList;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<TasksTimeList, Long> {
}
