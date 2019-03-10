package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.User;
import bean.User_operation;

public class RegServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			PrintWriter out = response.getWriter();
			String userid = (String)request.getParameter("userid");
			String username = (String)request.getParameter("username");
			username = new String(username.getBytes("iso-8859-1"),"utf-8");
			String password = (String)request.getParameter("password");
			User a = new User();
			a.setUserid(userid);
			a.setPassword(password);
			a.setUsername(username);
			User_operation reg = new User_operation();
			int i = reg.addUser(a);
				if(i>0){
					response.setContentType("text/html;charset=GBK");
					out.print("<script>alert('×¢²á³É¹¦£¡'); window.location='/xiaomi/UserServlet?&action=find' </script>");
					return;
				}
	}

}
