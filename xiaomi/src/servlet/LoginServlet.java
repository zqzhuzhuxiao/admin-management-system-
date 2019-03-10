package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Login;
import bean.User;

public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		String userid = (String)request.getParameter("userid");
		String password = (String)request.getParameter("password");
		User a = new User();
		a.setUserid(userid);
		a.setPassword(password);
		Login login = new Login();
		List<String> flaglist = login.getLoginflag(a);
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		if (flaglist.get(0).equals("ok")) {
			session.setAttribute("userid", flaglist.get(2));
			session.setAttribute("user_power", flaglist);
			session.setAttribute("username", flaglist.get(1));
			response.sendRedirect("index.jsp");
			return;
		}
		if (flaglist.get(0).equals("pwfalse")) {
			out.print("<script>alert('密码错误！'); window.location='index.jsp' </script>");
			return;
		}
		if (flaglist.get(0).equals("unfalse")) {
			out.print("<script>alert('用户名不存在！'); window.location='index.jsp' </script>");
			return;
		}
	}

}
