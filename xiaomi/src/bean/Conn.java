package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
	private Connection conn=null;
	public Connection connect(){
		String url="jdbc:mysql://localhost:3306/sjk?useUnicode=true&characterEncoding=UTF8";
		String driverClass="com.mysql.jdbc.Driver";
		try {
			Class.forName(driverClass).newInstance();
			System.out.println("成功加载 MYSQL程序");
			conn = DriverManager.getConnection(url, "root", "root");
			System.out.println("成功创建连接");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("找不到文件位置");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			System.out.println("找不到文件位置");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("找不到文件位置");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("输入输出异常");
		}
		return conn;
		
	}
}
