package com.hzy.demo.mapper;

import com.hzy.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 何峥言 on 2017/6/16.
 */
@Component
@Mapper
public interface UserMapper {
    /**
     * 获取所有用户
     * @return 用户集合
     */
    public List<User> getAllUsers();

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

    /**
     * 获取用户总数
     * @return
     */
    public int getUserCount();

}
