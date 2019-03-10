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
		System.out.println("��ʼ����");
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
				         for (int j = 0; j < field.length; j++) { // ������������
				             String name = field[j].getName(); // ��ȡ���Ե�����
				             name = name.substring(0, 1).toUpperCase() + name.substring(1); // �����Ե����ַ���д�����㹹��get��set����
				             String type = field[j].getGenericType().toString(); // ��ȡ���Ե�����
				             if (type.equals("class java.lang.String")) { // ���type�������ͣ���ǰ�����"class "�����������
				                 Method m = comm.getClass().getMethod("set"+name,String.class);
				                 m.invoke(comm, rs.getString(j+1));}
				             if (type.equals("class java.lang.Integer")) {
				                 Method  m = comm.getClass().getMethod("set"+name,Integer.class);
				                     m.invoke(comm, rs.getInt(j+1)); }
				             // �������Ҫ,���Է������������������,�����Ӷ��������͵��ж�
				             }
				      }catch(Exception e){
				    	  System.out.println("�����쳣");
				      }
				}
				commlist.add(comm);
			}
		} catch (SQLException e) {
			System.out.println("��ѯʧ��");
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
			System.out.println("ɾ��ʧ��");
		}try {
			if(conn!=null){
				conn.close();}
		} catch (SQLException e) {
			System.out.println("�ر�conn�쳣");
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
			System.out.println("���ʧ��");
		}try {
			if(conn!=null){
				conn.close();}
		} catch (SQLException e) {
			System.out.println("�ر�conn�쳣");
		}
		return i;
	}
	
	
}
