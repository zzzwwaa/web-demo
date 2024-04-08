package gyhx.com.cn.servlet.work;

import gyhx.com.cn.dao.WorkDao;
import gyhx.com.cn.utils.AjaxUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@MultipartConfig
@WebServlet("/updateWork")
public class WorkUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id=req.getParameter("id");
        String content=req.getParameter("content");
        String name=req.getParameter("name");
        //获取图片
        Part file = req.getPart("file");
        String url="/img/work/"+file.getSubmittedFileName();
        file.write("D:/Java code 11/wenao"+url);

        if(content==null){
            AjaxUtils.showInfo(resp,"作品内容不能为空！","/showWork");
            return;
        }
        WorkDao workDao=new WorkDao();
        boolean fs = workDao.updateWork(name,url,content,Integer.parseInt(id));
        if(fs){
            AjaxUtils.showInfo(resp,"修改成功!","/showWork");
        }else{
            AjaxUtils.showInfo(resp,"修改失败!","/showWork");
        }

    }
}
