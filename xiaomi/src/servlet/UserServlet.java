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

public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UserServlet(){
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String userid=(String)request.getParameter("userid");
		String usernameo=(String)request.getParameter("username");
		System.out.println(userid+usernameo);
		if(userid==null){
			userid="null";
		}
		if(usernameo==null){
			usernameo="null";
		}
		String username = new String(usernameo.getBytes("iso-8859-1"),"utf-8");
		System.out.println(username);
		String action = (String)request.getParameter("action");
		System.out.println("action是:"+action);
		if(action.equals("find")){
			String condition="";
			try{
			if(userid.equals("null")==false){
				condition="where userid='"+userid+"'";
			}
			if(username.equals("null")==false){
				condition="where username like '%"+username+"%'";
			}
			}catch(Exception e){
				System.out.println("添加异常");
			}
			User_operation oper = new User_operation();
			List<User> userlist = oper.getUserlist(condition);
			request.setAttribute("userlist", userlist);
			System.out.println(userlist);
			RequestDispatcher rd = request.getRequestDispatcher("admin_boss/user-details.jsp");
			rd.forward(request, response);
			return;
		}
		if (action.equals("userdelete")) {
			response.setContentType("text/html;charset=GBK");
			User_operation oper = new User_operation();
			System.out.println(userid);
			int i = oper.delUser(userid);
			if (i>0) {
				out.print("<script>alert('删除成功！'); window.location='UserServlet?action=find'</script>");
				return;
			}
		}
	}

}
