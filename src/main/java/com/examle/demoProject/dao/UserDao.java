package com.examle.demoProject.dao;

import com.examle.demoProject.user.dto.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    List<User> getUserList(User user);
}
