package me.ruu.playground.service;

import me.ruu.playground.dao.UserMapper;
import me.ruu.playground.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userDao;

    public User findUserByUserId(long userId){
        User user = userDao.getUser(userId);
        return user;
    }

    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }
}
