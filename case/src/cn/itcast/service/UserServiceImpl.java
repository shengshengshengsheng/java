package cn.itcast.service;

import cn.itcast.dao.IUserDao;
import cn.itcast.dao.UserDaoImpl;
import cn.itcast.domain.User;

import java.util.List;

/**
 * @author:Administrator
 * @date:2020/8/23
 * @description:
 */
public class UserServiceImpl implements IUserService{
    IUserDao userDao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.findUserByUserNameAndPassWord(user);
    }
}
