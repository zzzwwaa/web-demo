package gyhx.com.cn.servlet.news;

import gyhx.com.cn.dao.NewDao;
import gyhx.com.cn.utils.AjaxUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;




@WebServlet("/updateNews")
public class NewsUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id=req.getParameter("id");
        String name=req.getParameter("name");
        String content=req.getParameter("content");

        NewDao newDao=new NewDao();
        boolean fs = newDao.updateNews(name,content, Integer.parseInt(id));
        if(fs){
            AjaxUtils.showInfo(resp,"修改成功!","/showNews");
        }else{
            AjaxUtils.showInfo(resp,"修改失败!","/showNews");
        }

    }
}
