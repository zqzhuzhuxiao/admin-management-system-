package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Login {
	public Login(){
		
	}
	private List<String> loginflag = new ArrayList<String>();
	Conn connect=new Conn();
	public List<String> getLoginflag(User a) {
		Connection conn=connect.connect();
		String sql="select * from user where userid=?";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,a.getUserid());
			ResultSet rs = st.executeQuery();
			if(rs.next()){
					
				if(rs.getString(2).equals(a.getPassword())){
					loginflag.add("ok");
					loginflag.add(rs.getString(1));
					loginflag.add(rs.getString(3));
					String sql1="select * from user_power where userid=?";
					PreparedStatement st1 = conn.prepareStatement(sql1);
					st1.setString(1,a.getUserid());
					ResultSet rs1 = st1.executeQuery();
					while(rs1.next()){
						loginflag.add(rs1.getString(2));
					}
					System.out.println(loginflag);
				}else{
					loginflag.add("pwfalse");
				}
				
			}else{
				loginflag.add("unfalse");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查询异常");
		}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("关闭conn异常");
			}
		
		return loginflag;
	}
	
}
