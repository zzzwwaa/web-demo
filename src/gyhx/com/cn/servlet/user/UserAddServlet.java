package gyhx.com.cn.servlet.user;

import gyhx.com.cn.dao.UserDao;
import gyhx.com.cn.utils.AjaxUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@MultipartConfig
@WebServlet("/admin/addUser")
public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码
        req.setCharacterEncoding("UTF-8");
        //获取请求的name
        String name = req.getParameter("name");

        String passoword = req.getParameter("password");

        //开始调用数据库的业务
        UserDao userDao=new UserDao();
        userDao.insertUser(name,passoword);

        AjaxUtils.showInfo(resp,"添加成功!","/showUser");

    }
}
