package me.ruu.playground.controller;

import me.ruu.playground.model.User;
import me.ruu.playground.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/{id}")
    public String getUserByUserId(@PathVariable("id") Long userId){
        User user = userService.findUserByUserId(userId);
        return user.toString();
    }

    @GetMapping(value = "/users")
    public String getAllUsers(){
        List<User> userList = userService.getAllUsers();
        return userList.toString();
    }
}
