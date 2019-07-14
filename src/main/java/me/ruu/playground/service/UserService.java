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

    public int addUser(User user){
        return userDao.insertUser(user);
    }

    public int deleteUser(long userId){
        return userDao.deleteUser(userId);
    }

    public int updateUser(User user){
        return userDao.updateUser(user);
    }
}
