package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.UserBean;

public class LoginDao {
	DataSource ds;
	

	public LoginDao() throws ClassNotFoundException {

		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UserBean loginUser(String username, String password) throws SQLException {
		String query = "select * FROM users  where username=? and password=?";
		UserBean currentUser=null;
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		p.setString(1, username);
		p.setString(2, password);
		ResultSet r = p.executeQuery();
		

		while (r.next()) {
			 currentUser = new UserBean(Integer.parseInt(r.getString("USERID")), r.getString("USERNAME"),r.getString("PASSWORD"), r.getString("EMAIL"), r.getString("FIRSTNAME"), r.getString("LASTNAME"),r.getString("TYPE"));
		}

		r.close();
		p.close();
		con.close();
		return currentUser;
	}

	

}
