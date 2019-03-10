package bean.comm;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.Conn;

public class Comm_operation {
	public Comm_operation(){
		
	}
	private List<Commodify> commlist = new ArrayList<Commodify>();
	Conn connect = new Conn();
	public List<Commodify> getCommodify(String a){
		System.out.println("开始连接");
		Connection conn=connect.connect();
		try {
			System.out.println(a);
			String sql="select * from comm_add "+a;
			System.out.println(sql);
			PreparedStatement st = conn.prepareStatement(sql);
			//st.setString(1, a);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				ResultSetMetaData rsmd=rs.getMetaData();
				int coun=rsmd.getColumnCount();
				System.out.println(coun);
				Commodify comm = new Commodify();
				for (int i = 0; i < coun; i++) {
					Field[] field = comm.getClass().getDeclaredFields();
					try {
				         for (int j = 0; j < field.length; j++) { // 遍历所有属性
				             String name = field[j].getName(); // 获取属性的名字
				             name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
				             String type = field[j].getGenericType().toString(); // 获取属性的类型
				             if (type.equals("class java.lang.String")) { // 如果type是类类型，则前面包含"class "，后面跟类名
				                 Method m = comm.getClass().getMethod("set"+name,String.class);
				                 m.invoke(comm, rs.getString(j+1));}
				             if (type.equals("class java.lang.Integer")) {
				                 Method  m = comm.getClass().getMethod("set"+name,Integer.class);
				                     m.invoke(comm, rs.getInt(j+1)); }
				             // 如果有需要,可以仿照上面继续进行扩充,再增加对其它类型的判断
				             }
				      }catch(Exception e){
				    	  System.out.println("类型异常");
				      }
				}
				commlist.add(comm);
			}
		} catch (SQLException e) {
			System.out.println("查询失败");
		}
		try {
			if(conn!=null){conn.close();}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commlist;
	}
	public int delComm(String a){
		int i=0;
		Connection conn=connect.connect();
		String sql="delete  from comm_add where commaddid = ?";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, a);
			i = st.executeUpdate();
		} catch (SQLException e) {
			System.out.println("删除失败");
		}try {
			if(conn!=null){
				conn.close();}
		} catch (SQLException e) {
			System.out.println("关闭conn异常");
		}
		return i;
	}
	public int addComm(Commodify a){
		int i=0;
		Connection conn=connect.connect();
		String sql="insert into comm_add value(?,?,?,?)";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,	a.getCommaddid());
			st.setString(2, a.getCommaddname());
			st.setString(3, a.getCommprice());
			st.setString(4, a.getCommurl());
			i = st.executeUpdate();
		} catch (SQLException e) {
			System.out.println("添加失败");
		}try {
			if(conn!=null){
				conn.close();}
		} catch (SQLException e) {
			System.out.println("关闭conn异常");
		}
		return i;
	}
	
	
}
