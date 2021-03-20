package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;

import javax.sql.DataSource;

import bean.CartBean;

public class CartDao {

	private DataSource ds;

	public CartDao() throws ClassNotFoundException {
		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CartBean findById(String bid) throws SQLException {
		String query = "SELECT title, author, coverart, price FROM Book WHERE bid=?";

		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);

		p.setString(1, bid);

		ResultSet r = p.executeQuery();

		while (r.next()) {
			String title = r.getString("title");
			String author = r.getString("author");
			String coverart = r.getString("coverart");
			float price = Float.parseFloat(r.getString("price"));

			CartBean cb = new CartBean(bid, title, author, coverart, price, 1);

			r.close();
			p.close();
			con.close();

			return cb;

		}
		return null;
	}

}
