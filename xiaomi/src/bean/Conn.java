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
			System.out.println("�ɹ����� MYSQL����");
			conn = DriverManager.getConnection(url, "root", "root");
			System.out.println("�ɹ���������");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("�Ҳ����ļ�λ��");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			System.out.println("�Ҳ����ļ�λ��");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("�Ҳ����ļ�λ��");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("��������쳣");
		}
		return conn;
		
	}
}
