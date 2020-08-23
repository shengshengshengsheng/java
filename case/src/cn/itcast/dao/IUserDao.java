package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;

public interface IUserDao {
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
     * 通过用户名和密码查询用户信息
     * @param user
     * @return
     */
    User findUserByUserNameAndPassWord(User user);
}
