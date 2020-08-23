package cn.itcast.servlet;

import cn.itcast.domain.User;
import cn.itcast.service.IUserService;
import cn.itcast.service.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * @author:Administrator
 * @date:2020/8/23
 * @description:
 */
@WebServlet("/findAllContactHttpServlet")
public class FindAllContactHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IUserService userService =new UserServiceImpl();
        List<User> userList = userService.findAll();
        req.setAttribute("userList",userList);
        req.getRequestDispatcher("/list.jsp").forward(req,resp);
    }
}
