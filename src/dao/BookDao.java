package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.BookBean;

public class BookDao {
	DataSource ds;

	public BookDao() throws ClassNotFoundException {
		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	
	public Map<String, BookBean> retrieveAll() throws SQLException {
		String query = "select * from book";
		Map<String, BookBean> rv = new HashMap<String, BookBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while (r.next()) {
			String bid = r.getString("bid");
			BookBean bean = new BookBean(bid, r.getString("title"), r.getString("author"), r.getString("publisher"),r.getString("coverart"), r.getFloat("price"), r.getString("category"), r.getString("description"));
			rv.put(bid, bean);
		}
		r.close();
		p.close();
		con.close();

		return rv;
	}
	
	public Map<String, BookBean> retrieveAllByCategory(String category) throws SQLException {
		String query = "select * from book where category like ?";
		Map<String, BookBean> rv = new HashMap<String, BookBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		p.setString(1, category);
		ResultSet r = p.executeQuery();
		while (r.next()) {
			String bid = r.getString("bid");
			BookBean bean = new BookBean(bid, r.getString("title"), r.getString("author"), r.getString("publisher"),r.getString("coverart"), r.getFloat("price"), r.getString("category"), r.getString("description"));
			rv.put(bid, bean);
		}
		r.close();
		p.close();
		con.close();

		return rv;
	}


	public Map<String, BookBean> retrieveByBID(String bookid) throws SQLException {
		String query = "select * from book where bid like ?";
		Map<String, BookBean> rv = new HashMap<String, BookBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		p.setString(1, bookid);
		ResultSet r = p.executeQuery();
		while (r.next()) {
			String bid = r.getString("bid");
			BookBean bean = new BookBean(bid, r.getString("title"), r.getString("author"), r.getString("publisher"),r.getString("coverart"), r.getFloat("price"), r.getString("category"), r.getString("description"));
			rv.put(bid, bean);
		}
		r.close();
		p.close();
		con.close();

		return rv;
	}
	
	
	
	
	
	public BookBean retrieveBookByBID(String bookid) throws SQLException {
		String query = "select * from book where bid like ?";
		BookBean bean = new BookBean();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		p.setString(1, bookid);
		ResultSet r = p.executeQuery();
		while (r.next()) {
			String bid = r.getString("bid");
			 bean = new BookBean(bid, r.getString("title"), r.getString("author"), r.getString("publisher"),r.getString("coverart"), r.getFloat("price"), r.getString("category"), r.getString("description"));
			
		}
		r.close();
		p.close();
		con.close();

		return bean;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
