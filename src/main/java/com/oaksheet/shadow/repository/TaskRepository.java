package com.oaksheet.shadow.repository;

import com.oaksheet.shadow.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {

}
