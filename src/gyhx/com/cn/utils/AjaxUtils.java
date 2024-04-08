package gyhx.com.cn.utils;

import gyhx.com.cn.model.UserModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 2009年-马松
 */
public class AjaxUtils {
	public static void ajaxJson(String jsonString, HttpServletResponse response) {
		ajax(jsonString, "application/json", response);
	}
	// ajax 输出文本
	public static void ajaxText(String text, HttpServletResponse response) {
		ajax(text, "text/plain",response);
	}

	// ajax 输出HTML
	public static void ajaxHtml(String html, HttpServletResponse response) {
		ajax(html, "text/html",response);
	}

	// ajax 输出XML
	public static void ajaxXml(String xml, HttpServletResponse response) {
		ajax(xml, "text/xml",response);
	}

	public static void ajax(String content, String type,
			HttpServletResponse response) {
		try {
			response.setContentType(type + ";charset=UTF-8");
			/**不设置缓存**/
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);

			response.getWriter().write(content);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * @param response
	 * @param info_str 返回的信息
	 * @param url 返回url地址
	 * @return
	 */
	public static String showInfo(HttpServletResponse response, String info_str, String url) {
		PrintWriter pout = null;
		try {
			//MIME类型
			response.setContentType("text/html;charset=UTF-8");
			pout = response.getWriter();
			pout.print("<script charset=\"UTF-8\" >alert('" + info_str + "');location.href='" + url + "';</script>");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pout != null) {
				pout.close();
			}
		}
		return null;
	}

	public static UserModel getSessionKey(HttpServletRequest request){
		Object user = request.getSession().getAttribute("loginUser");
		return (UserModel) user;
	}
}
