package cn.itcast.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author:Administrator
 * @date:2020/8/23
 * @description:
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //服务器通知浏览器不要缓存
        resp.setHeader("pragma","no-cache");
        resp.setHeader("cache-control","no-cache");
        resp.setHeader("expires","0");
        int height = 30;
        int width = 80;
        BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.pink);
        graphics.fillRect(0,0,width,height);
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0,0,width-1,height-1);
        String checkCode = this.getCheckCode();
        req.getSession().setAttribute("verifyCode",checkCode);
        System.out.println("生成的验证码是:"+checkCode);
        graphics.setColor(Color.BLACK);
        int len = checkCode.length();
        for (int i = 0; i < len; i++) {
            graphics.drawString(String.valueOf(checkCode.charAt(i)),width/(len-i)-8,height/2);
        }
        ImageIO.write(bufferedImage,"jpg",resp.getOutputStream());
    }

    private String getCheckCode() {
        String string = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        int length = string.length();
        for (int i = 4; i > 0; i--) {
            Character character = string.charAt(random.nextInt(length));
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
}
