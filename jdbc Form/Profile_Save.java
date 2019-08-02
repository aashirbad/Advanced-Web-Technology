

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Profile_Save {
	private static final long serialVersionUID = 1L;

	
	
	public int save(Profile_Bean profile) {
		Connection con = null;
		Statement st = null;
		int res = 0;
		try {
			con = ConnectDB.dbConn();
			st = con.createStatement();
			res = st.executeUpdate("INSERT INTO sev_profile (userid, name, email, mobile) VALUES ('"+profile.getId()+"', '"+profile.getName()+"', '"+profile.getMail()+"', "+profile.getMob()+")"); 
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	public List<Profile_Bean> fetchAll() {
		List<Profile_Bean> list=null;
		Connection con = null;
		Statement st = null;
		try {
			con = ConnectDB.dbConn();
			st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM sev_profile");
			if(rs != null) {
				list = new ArrayList<>();
			}
			while(rs.next()) {
				Profile_Bean pr = new Profile_Bean();
				pr.setId(rs.getString("userid"));
				pr.setName(rs.getString("name"));
				pr.setMail(rs.getString("email"));
				pr.setMob(rs.getString("mobile"));
				list.add(pr);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return list;
	
}
public static void main(String[] args) {
	Connection con = null;
	Statement st = null;
	try {
		con = ConnectDB.dbConn();
		st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM sev_profile");
		while(rs.next()) {
			String id = rs.getString("userid");
			String name = rs.getString("name");
			String email = rs.getString("email");
			long mobile = rs.getLong("mobile");
			System.out.println("Id : " +id + "\tName : "+ name+ "\tEmail : " +email + "\tMobile : " +mobile );
		}
	} catch (ClassNotFoundException | SQLException | IOException e) {
		e.printStackTrace();
	}finally {
		try {
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}

}
