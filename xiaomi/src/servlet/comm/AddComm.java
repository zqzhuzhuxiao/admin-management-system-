package servlet.comm;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.Conn;
import bean.comm.Comm_operation;
import bean.comm.Commodify;

public class AddComm extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public AddComm(){
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> items = new ArrayList<FileItem>();
		try {
	        items = upload.parseRequest(request);//将所有表单域装入列表
	    } catch (FileUploadException e) {
	        System.out.println("表单填入列表失败");
	    }
		String commaddid = "";
		String commaddname = "";
		String commprice = "";
		String commurl = "";
		 for(FileItem item : items){
			 if(item.isFormField()){
				 String fieldName = item.getFieldName();
				 if (fieldName.equals("commtwo")){
					 String commtwo = item.getString("utf-8");
					 commtwo = commtwo.substring(0,6);
					 System.out.println(commtwo);
					 commaddid = getCommaddid(commtwo);
					 System.out.println("生成的商品ID是："+commaddid);
				 }
				 if (fieldName.equals("commaddname")){
            		 commaddname=item.getString("utf-8"); 
            		 System.out.println("生成的商品名称是："+commaddname);
            	   	 }
            	 if (fieldName.equals("commprice")){
            		 commprice=item.getString("utf-8"); 
            		 System.out.println("生成的商品价格是："+commprice);
            		 }
			 }else{
				 String fileName = item.getName();
				 String path = this.getServletContext().getRealPath("/img/business");
				 System.out.println(path);
				 File childDirectory = new File(path,commaddid);
				 if(!childDirectory.exists()){
		 	        	childDirectory.mkdirs();
		 	        }
				 try {
					 item.write(new File(childDirectory.toString(),commaddid+"_"+fileName));
		 	     } catch (Exception e) {
		 	    	 System.out.println("添加图片路径失败");
		 	     }
				 commurl="/xiaomi/img/business/"+commaddid+"/"+commaddid+"_"+fileName;
	 	     	 System.out.println(commurl);
			 }
		 }
		 Commodify comm = new Commodify();
		 comm.setCommaddid(commaddid);
		 comm.setCommaddname(commaddname);
		 comm.setCommprice(commprice);
		 comm.setCommurl(commurl);
		 Comm_operation oper = new Comm_operation();
		 int i =oper.addComm(comm);
		 if(i>0){
			 response.setContentType("text/html");
			 PrintWriter out = response.getWriter();
			 out.print("<script>alert('添加成功');window.location='/xiaomi/CommServlet?action=find'</script>");
		 }
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	public static String getCommaddid(String commtwo) {
		String commaddid="";
		try{
			Conn connect = new Conn();
			Connection conn=connect.connect();
			String sql = "select commaddid from comm_add where commaddid like ? order by commaddid DESC limit 1";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, commtwo+"%");
			ResultSet rs = st.executeQuery();
			if (rs.next()){
				long i = Long.parseLong(rs.getString(1));
				i++;
				commaddid= Long.toString(i);
			}
			else{
				commaddid=commtwo+"00000001";
			}
		}catch(Exception e){
			System.out.println("查询commaddid失败");
		}
		
		return commaddid;
	}
}
