package com.oaksheet.shadow.repository;

import com.oaksheet.shadow.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}