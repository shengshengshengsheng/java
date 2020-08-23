package cn.itcast.test;

import cn.itcast.domain.User;
import cn.itcast.service.IUserService;
import cn.itcast.service.UserServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author:Administrator
 * @date:2020/8/23
 * @description:
 */
public class IUserServiceTest {
    @Test
    public void testFindAll(){
        IUserService userService = new UserServiceImpl();
        List<User> userList = userService.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
