package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.CartBean;
import bean.OrderBean;

public class OrderDao {
	
	
	private DataSource ds;

	public OrderDao() throws ClassNotFoundException {
		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
public OrderBean getOrdersByPartNumber (int id) throws SQLException {
	OrderBean result;
	
	
	String query = "SELECT id, lname, fname, status,address FROM PO WHERE id=?";

	Connection con = this.ds.getConnection();
	PreparedStatement p = con.prepareStatement(query);

	p.setInt(1, id);

	ResultSet r = p.executeQuery();

	while (r.next()) {
		String idOrder = r.getString("id");
		String lname = r.getString("lname");
		String fname = r.getString("fname");
		String statue = r.getString("status");
		String address = r.getString("address");


		result = new OrderBean(idOrder, lname, fname, statue, address);

		r.close();
		p.close();
		con.close();

		return result;
	
	

}	
	return null;
	
}	
public Void addOrder( String lname,String fname,String statue,String address) throws SQLException {
	try {

		Connection con = this.ds.getConnection();
		String col = "SELECT count(*) FROM PO";
		PreparedStatement number_col = con.prepareStatement(col);
		ResultSet result = number_col.executeQuery();
		result.next();
		int count = result.getInt(1);
		count++;
		result.close();
		number_col.close();

		String q1 = "INSERT INTO PO values(?,?,?,?,?)";
		PreparedStatement p = con.prepareStatement(q1);
		p.setInt(1, count);
		p.setString(2, lname);
		p.setString(3, fname);
		p.setString(4, statue);
		p.setString(5, address);
		p.executeUpdate();


		p.close();
		con.close();

	} catch (Exception e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return null;

}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
