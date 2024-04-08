package gyhx.com.cn.servlet.user;

import gyhx.com.cn.dao.UserDao;
import gyhx.com.cn.model.UserModel;
import gyhx.com.cn.utils.AjaxUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//servlet
@MultipartConfig
@WebServlet("/admin/login")
public class UserLoginServlet extends HttpServlet {
     //ctrl+o
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      this.doPost(req,resp);
    }

     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码
        req.setCharacterEncoding("UTF-8");


        String name = req.getParameter("name");

        String password = req.getParameter("password");
        //开始调用数据库
        UserDao userDao=new UserDao();
        UserModel user = userDao.login(name, password);
        //把数据放在请求域。
        HttpSession session = req.getSession();
        session.setAttribute("loginUser",user);
        AjaxUtils.showInfo(resp,"恭喜你登录成功!","/jsp/admin/index.jsp");

    }
    }
/**  if(user.getName()!=null){
           //跳转到首页

        }else{
            //跳转到登录页面
            AjaxUtils.showInfo(resp,"登录失败!","/jsp/admin/login.jsp");
        }
*/


