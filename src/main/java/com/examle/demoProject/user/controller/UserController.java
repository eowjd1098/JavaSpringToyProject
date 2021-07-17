package com.examle.demoProject.user.controller;

import com.examle.demoProject.user.dto.User;
import com.examle.demoProject.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/users", method = RequestMethod.GET)
    List<User> users(User user){
        System.out.println(userService.toString());
        return  userService.getUserList(user);
    }




}
