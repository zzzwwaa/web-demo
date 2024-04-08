package gyhx.com.cn.servlet.work;

import gyhx.com.cn.dao.WorkDao;
import gyhx.com.cn.model.UserModel;
import gyhx.com.cn.model.WorkModel;
import gyhx.com.cn.utils.AjaxUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/addWork")
@MultipartConfig
public class AddWorkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name=req.getParameter("name");
        String content=req.getParameter("content");
        //获取图片
        Part file = req.getPart("file");
        String url="/img/work/"+file.getSubmittedFileName();
        file.write("D:/Java code 11/wenao"+url);
        //获取登录的用户
        UserModel user = AjaxUtils.getSessionKey(req);
        //拼装作品对象
        WorkModel work=new WorkModel(name,url,content,user.getId(),user.getName());
        //保存作品对象
        WorkDao workDao=new WorkDao();
        workDao.insertWork(work);

        //响应页面

        AjaxUtils.showInfo(resp,"添加成功!","/showWork");

    }
}
