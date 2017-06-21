package com.hzy.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.hzy.demo.domain.User;
import com.hzy.demo.mapper.UserMapper;
import com.hzy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 何峥言 on 2017/6/16.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUsers(int pageNumber,int pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        List<User> users =this.userMapper.getAllUsers();
        return users;
    }

    @Override
    public User getUserById(int id) {
        User user = this.userMapper.getUserById(id);
        return user;
    }

    @Override
    public boolean addUser(User user) {
        return this.userMapper.addUser(user);
    }

    @Override
    public boolean modifyUserById(User user) {
        return this.userMapper.modifyUserById(user);
    }

    @Override
    public boolean deleteUserById(int id) {
        return this.userMapper.deleteUserById(id);
    }

    public int getUserCount(){
        return this.userMapper.getUserCount();
    }
}
