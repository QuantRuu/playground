package me.ruu.playground.controller;

import me.ruu.playground.model.User;
import me.ruu.playground.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/user")
    public String getAllUsers(){
        List<User> userList = userService.getAllUsers();
        return userList.toString();
    }

    @PutMapping(value = "/user")
    public String updateUser(@RequestBody User user){
        int result = userService.updateUser(user);
        if (result >= 1) {
            return "更新成功:" + user.getUserId();
        } else {
            return "更新失败";
        }
    }

    @DeleteMapping(value = "/user/{id}")
    public String deleteUser(@PathVariable("id") long userId){
        int result = userService.deleteUser(userId);
        if (result >= 1) {
            return "删除成功:" + userId;
        } else {
            return "删除失败";
        }
    }

    @PostMapping(value = "/user")
    public String addUser(@RequestBody User user){
        int result = userService.addUser(user);
        if (result >= 1) {
            return "新增成功:" + user.toString();
        } else {
            return "新增失败";
        }
    }

}
