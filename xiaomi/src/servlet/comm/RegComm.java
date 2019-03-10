package servlet.comm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Conn;

public class RegComm extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parentid = (String)request.getParameter("parentid");
		parentid = new String(parentid.getBytes("iso-8859-1"),"utf-8");
		if (parentid.equals("0")==false){
		parentid=parentid.substring(0,3);}
		Conn connect = new Conn();
		System.out.println("开始连接……");
		Connection conn=connect.connect();
		String commodifylist="";
		try{
			String sql = "select * from commodify where parentid=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, parentid);
			ResultSet rs = st.executeQuery();
			 while (rs.next()){
				 String commid=rs.getString(1);
				 String commname=rs.getString(2);
				 commodifylist=commodifylist+commid+commname+"/";
			 }
			 System.out.println(commodifylist);
		}
		catch(Exception e){
			System.out.println("查询失败");
		}
		PrintWriter out = response.getWriter();
		out.print(commodifylist);
		
	}

	

}
