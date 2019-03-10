package servlet.comm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.comm.Comm_operation;
import bean.comm.Commodify;

public class CommServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String commaddid=(String)request.getParameter("commaddid");
		String commaddname0=(String)request.getParameter("commaddname");
		if(commaddid==null){
			commaddid="null";
		}
		if(commaddname0==null){
			commaddname0="null";
		}
		String commaddname = new String(commaddname0.getBytes("iso-8859-1"),"utf-8");
		String action = (String)request.getParameter("action");
		System.out.println("action是:"+action);
		if (action.equals("find")){
			String condition = " ";
			try{
				if (commaddid.equals("null")==false ){
					condition=" where commaddid="+commaddid;
				}
				if (commaddname.equals("null")==false ){
					condition="where commaddname like '%"+commaddname+"%'";
				}
			}catch(Exception e){
				System.out.println("添加失败");
			}
			System.out.println(condition);
			Comm_operation oper = new Comm_operation();
			List<Commodify> commlist = (List<Commodify>)oper.getCommodify(condition);
			request.setAttribute("commlist", commlist);
			System.out.println(commlist);
			RequestDispatcher rd = request.getRequestDispatcher("admin_business/commodify_query.jsp");
			rd.forward(request, response);
			return;
		}
		if(action.equals("commdel")){
			Comm_operation oper = new Comm_operation();
			int i = oper.delComm(commaddid);
			if(i>0){
				response.setContentType("text/html;charset=GBK");
				out.print("<script>alert('删除成功！'); window.location='CommServlet?action=find' </script>");
				return;
			}
		}
	}
}
