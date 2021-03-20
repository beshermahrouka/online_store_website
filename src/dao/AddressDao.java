package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.AddressBean;
import bean.BookBean;
import bean.UserBean;

public class AddressDao {
	private DataSource ds;

	private AddressBean address;

	public AddressDao() throws ClassNotFoundException {
		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public AddressBean getAddress(int userID) throws SQLException {
		String query = "select * FROM address where id=?";

		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		p.setInt(1, userID);
		ResultSet r = p.executeQuery();

		while (r.next()) {
			address = new AddressBean(Integer.parseInt(r.getString("ID")), r.getString("STREET"),r.getString("PROVINCE"), r.getString("COUNTRY"), r.getString("ZIP"), r.getString("PHONE"));
		}

		r.close();
		p.close();
		con.close();
		return address;
	}

	public void setAddress(int userID, String password, String street, String province, String country, String postal,
			String phone) throws SQLException {

		Connection con = this.ds.getConnection();

		String q1 = "INSERT INTO Address values(?,?,?,?,?,?)";
		PreparedStatement p = con.prepareStatement(q1);
		p.setInt(1, userID);
		p.setString(2, street);
		p.setString(3, province);

		p.setString(4, country);
		p.setString(5, postal);
		p.setString(6, phone);

		p.executeUpdate();

		p.close();
		con.close();

	}
}
