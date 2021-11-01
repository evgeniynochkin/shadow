package com.oaksheet.shadow.service;

import com.oaksheet.shadow.model.User;
import com.oaksheet.shadow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByEmail(s);
    }

    //создание таблиц
    public void createUserTables(User user) {
        String sqlQuery = "CREATE TABLE " + user.getEmail() + "_todo_time (" +
                " date DATE() NOT NULL," +
                " time_begin TIME()," +
                " time_finish TIME()," +
                " todo_id BIGINT PRIMARY KEY)";

    }
}
