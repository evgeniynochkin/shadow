package com.oaksheet.shadow.repository;

import com.oaksheet.shadow.model.Task;
import com.oaksheet.shadow.model.TasksTimeList;
import com.oaksheet.shadow.model.User;
import org.springframework.data.repository.CrudRepository;

public interface TaskTimeListRepository extends CrudRepository<TasksTimeList, Long> {
    Iterable<TasksTimeList> findAllByUser(User user);
}
