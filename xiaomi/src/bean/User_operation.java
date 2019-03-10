package bean;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User_operation {
	public User_operation(){
		
	}
	private List<User> userlist = new ArrayList<User>();
	Conn connect=new Conn();
	public List<User> getUserlist(String a) {
		System.out.println("开始连接");
		Connection conn=connect.connect();
		System.out.println(a);
		String sql="select * from user "+a;
		System.out.println(sql);
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				User user = new User();
				ResultSetMetaData rsmd=rs.getMetaData();
				int count=rsmd.getColumnCount();
				System.out.println(count);
				
				for (int i = 0; i < count; i++) {
					Field[] fild = user.getClass().getDeclaredFields();
					try{
						
						for (int j = 0; j < fild.length; j++) {
						String name=fild[j].getName();
						name = name.substring(0, 1).toUpperCase()+name.substring(1);
						String type=fild[j].getGenericType().toString();
						if (type.equals("class java.lang.String")) {
							Method m=user.getClass().getMethod("set"+name, String.class);
							m.invoke(user, rs.getString(j+1));
						}
						
						}
						
					}catch (Exception e) {
						System.out.println("类型异常");
					}
					
 				}
				userlist.add(user);
			}
		} catch (SQLException e) {
			System.out.println("查询异常");
		} try {
			if(conn!=null){
			conn.close();}
		} catch (SQLException e) {
			System.out.println("关闭conn异常");
		}
		return userlist;
	}
	public int delUser(String a){
		int i=0;
		Connection conn=connect.connect();
		String sql="delete  from user where userid = ?";
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
	public int addUser(User a){
		int i=0;
		Connection conn=connect.connect();
		String sql="insert into user value(?,?,?)";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,	a.getUsername());
			st.setString(2, a.getPassword());
			st.setString(3, a.getUserid());
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
	public int modtifyUser(User a){
		int i=0;
		Connection conn=connect.connect();
		String sql="update user set username=?,password=? where userid=?";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,	a.getUsername());
			st.setString(2, a.getPassword());
			st.setString(3, a.getUserid());
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
