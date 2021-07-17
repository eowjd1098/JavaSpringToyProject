package com.examle.demoProject.user.service;

import com.examle.demoProject.dao.UserDao;
import com.examle.demoProject.user.dto.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUserList(User user) {
        return userDao.getUserList(user);
    }
}
