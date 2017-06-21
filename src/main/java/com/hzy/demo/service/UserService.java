package com.hzy.demo.service;

import com.hzy.demo.domain.User;

import java.util.List;

/**
 * Created by 何峥言 on 2017/6/16.
 */

public interface UserService {
    /**
     * 获取所有用户
     * @return 用户集合
     */
    public List<User> getAllUsers(int pageNumber,int pageSize);

    /**
     * 根据用户Id获取用户
     * @param id
     * @return 用户对象
     */
    public User getUserById(int id);

    /**
     * 添加用户
     * @param user
     * @return 是否成功
     */
    public boolean addUser(User user);

    /**
     * 根据用户Id修改用户信息
     * @param user
     * @return 是否成功
     */
    public boolean modifyUserById(User user);

    /**
     * 根据用户ID删除用户
     * @param id
     * @return 是否成功
     */
    public boolean deleteUserById(int id);

    public int getUserCount();

}
