package cn.itcast.service;

import cn.itcast.domain.User;

import java.util.List;

/**
 * @author:Administrator
 * @date:2020/8/23
 * @description:
 */
public interface IUserService {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 用户登录验证
     * @param user
     * @return
     */
    User login(User user);
}
