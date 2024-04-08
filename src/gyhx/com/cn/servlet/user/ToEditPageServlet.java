package gyhx.com.cn.servlet.user;

import gyhx.com.cn.dao.UserDao;
import gyhx.com.cn.model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//editUser?id=11

/**
 * 挑战到编辑页面
 */
@MultipartConfig
@WebServlet("/editUser")
public class ToEditPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        UserDao userDao=new UserDao();
        UserModel user = userDao.queryUserById(id);

        req.setAttribute("user",user);

        req.getRequestDispatcher("/jsp/admin/editUser.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doGet(req,resp);
    }
}
