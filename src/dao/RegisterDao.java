package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.UserBean;

public class RegisterDao {
	DataSource ds;

	public RegisterDao() throws ClassNotFoundException {

		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UserBean addUser(String username, String password, String email, String first_name, String last_name,
			String street, String province, String country, String postal, String phoneNumber) throws SQLException {

		try {
			Connection con = this.ds.getConnection();
			String col = "SELECT count(*) FROM users";
			PreparedStatement number_col = con.prepareStatement(col);
			ResultSet result = number_col.executeQuery();
			result.next();
			int count = result.getInt(1);
			count++;
			result.close();
			number_col.close();

			String q1 = "INSERT INTO users values(?,?,?,?,?,?,?)";
			PreparedStatement p = con.prepareStatement(q1);
			p.setInt(1, count);
			p.setString(2, username);
			p.setString(3, password);
			p.setString(4, email);
			p.setString(5, first_name);
			p.setString(6, last_name);
			p.setString(7, "customer");
			p.executeUpdate();
			p.close();

			String q2 = "INSERT INTO Address values(?,?,?,?,?,?)";
			PreparedStatement p2 = con.prepareStatement(q2);
			p2.setInt(1, count);
			p2.setString(2, street);
			p2.setString(3, province);
			p2.setString(4, country);
			p2.setString(5, postal);
			p2.setString(6, phoneNumber);
			p2.executeUpdate();
			p2.close();

			con.close();
			return new UserBean(count, username, password, email, first_name, last_name, "customer");
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}

		return null;

	}

}
