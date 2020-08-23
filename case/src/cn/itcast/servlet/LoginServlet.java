package cn.itcast.servlet;

import cn.itcast.domain.User;
import cn.itcast.service.IUserService;
import cn.itcast.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author:Administrator
 * @date:2020/8/23
 * @description:
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("user");
        String password = req.getParameter("password");
        IUserService userService = new UserServiceImpl();
        String verifyCode = req.getParameter("verifycode");
        HttpSession session = req.getSession();
        String rightVerifyCode = (String) session.getAttribute("verifyCode");
        session.removeAttribute("verifyCode");
        if(rightVerifyCode!=null && rightVerifyCode.equalsIgnoreCase(verifyCode)){
            //验证码正确
            User user = userService.login(new User(username,password));
            if(user!=null){
                //账号密码正确
                session.setAttribute("loginUser",user);
                resp.sendRedirect("index.jsp");
            }else {
                req.setAttribute("login_msg","账号或密码有误,请重新输入");
            }
        }else {
            req.setAttribute("login_msg","验证码有误,请重新输入");
        }
    }
}
