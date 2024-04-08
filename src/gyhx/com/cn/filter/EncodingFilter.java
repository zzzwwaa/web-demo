/**package gyhx.com.cn.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


 * 编码字符集控制

@WebFilter("/*")
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        //让程序继续往下执行
        filterChain.doFilter(request,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁...");
    }
}
*/