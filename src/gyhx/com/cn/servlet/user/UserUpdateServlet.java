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

/**
 * 修改用户
 */
@MultipartConfig
@WebServlet("/updateUser")
public class UserUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("UTF-8");

        String id=req.getParameter("id");
        String name=req.getParameter("name");

        if(name==null){
            AjaxUtils.showInfo(resp,"用户名或者密码不能韦空!","/showUser");
            return;
        }
        UserDao userDao=new UserDao();
        boolean fs = userDao.updateUser(name, Integer.parseInt(id));
        if(fs){
            AjaxUtils.showInfo(resp,"修改成功!","/showUser");
        }else{
            AjaxUtils.showInfo(resp,"修改失败!","/showUser");
        }

    }
}
