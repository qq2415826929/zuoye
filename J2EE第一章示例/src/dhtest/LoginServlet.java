package dhtest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");			//设置请求编码
		//该类为项目与数据的接口（DAO接口），用于处理数据与数据库表的一些操作
		LoginDao loginDao = new LoginDao();
		Login l = loginDao.checkLogin(request.getParameter("name"), request.getParameter("password"));
		if(l!=null){									//如果登录成功
			HttpSession session = request.getSession();	//获得会话，用来保存当前登录用户的信息
			session.setAttribute("login", l);			//把获取的对象保存在 Session 中
            response.sendRedirect("main.jsp");			//验证成功跳转到欢迎主页 main.jsp
		}else{
			response.sendRedirect("error.jsp");			//验证失败跳转到错误处理页 error.jsp
		}
		
	    
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
	  
		
	}

}
