package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import bean.User_operation;

public class ModifyServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ModifyServlet(){
		
	}
	
	@Override
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String URL=request.getHeader("Referer");
		PrintWriter out = response.getWriter();
		if (URL.indexOf("ModifyServlet")!=-1){
		String username0 = (String)request.getParameter("username");
		String username = new String(username0.getBytes("iso-8859-1"),"utf-8");
		String password = (String)request.getParameter("password");
		String userid= (String)request.getParameter("userid");
		User a = new User();
		a.setUserid(userid);
		a.setPassword(password);
		a.setUsername(username);
		User_operation reg = new User_operation();
		int i = reg.modtifyUser(a);
		System.out.println(a.getUserid()+a.getPassword()+a.getUsername());
		if(i>0){
			response.setContentType("text/html;charset=GBK");
			out.print("<script>alert('ÐÞ¸Ä³É¹¦£¡'); window.location='/xiaomi/UserServlet?&action=find' </script>");
			return;}
		}
		String action = (String)request.getParameter("action");
		if (action.equals("usermod")){    
			String userid=(String)request.getParameter("userid");    
			User_operation oper =new User_operation();    
			String condition="where userid='"+userid+"'";    
			List<User> userlist=(List<User>) oper.getUserlist(condition);
			request.setAttribute("userlist", userlist);    
			RequestDispatcher rd = request.getRequestDispatcher("public/modifyuser.jsp");    
			rd.forward(request, response);    
			return;   
			}
	}

	@Override
	public void init() throws ServletException {
		
	}
	
}
