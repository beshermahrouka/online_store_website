package dao;

import javax.naming.InitialContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import bean.BookBean;

import bean.SoldBean;

public class SoldDao {
	
	
	
	
	DataSource ds;
	BookDao book;

	public SoldDao() throws ClassNotFoundException {
		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
			book = new BookDao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	public Map<String, SoldBean> retrieveBooksSoldByMonth(String month) throws SQLException {
		
		String query = "select * from visitevent where eventtype like ? and month=? ";
		Map<String, SoldBean> rv = new HashMap<String, SoldBean>();
		Connection con =  this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		p.setString(1, "PURCHASE");
		p.setString(2, month);
	
		
		
		
		ResultSet r = p.executeQuery();
		while(r.next()){
			String bid = r.getString("bid");
			
		
				BookBean book2 =  book.retrieveBookByBID(bid);
				SoldBean s = new SoldBean(book2);
				rv.put(bid, s);
			
		}
		r.close();
		p.close();
		con.close();
		
		return rv;
	}
	
	
	
	
	
	
	
	public Void addSold( String day , String month, String bid , String eventtype) throws SQLException {
		try {

			Connection con = this.ds.getConnection();
			String col = "SELECT count(*) FROM VisitEvent";
			PreparedStatement number_col = con.prepareStatement(col);
			ResultSet result = number_col.executeQuery();
			result.next();
			int count = result.getInt(1);
			count++;
			result.close();
			number_col.close();

			String q1 = "INSERT INTO VisitEvent values(?,?,?,?,?)";
			PreparedStatement p = con.prepareStatement(q1);
			p.setInt(1, count);
			p.setString(2, day);
			p.setString(3, month);
			p.setString(4, bid);
			p.setString(5, eventtype);
			p.executeUpdate();


			p.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	
	}
	
	
	
	
	
	
//for listener 	
	
	public Void addtop( String bid) throws SQLException {
		try {

			Connection con = this.ds.getConnection();
			

			String q1 = "UPDATE TopBook SET soldnumber =soldnumber+1 WHERE bid=?" ;
			PreparedStatement p = con.prepareStatement(q1);		
			p.setString(1, bid);			
			p.executeUpdate();
			p.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	
	}	
	
	
	// for listener 
	public ArrayList<String> selectTop() throws SQLException {
		ArrayList<String> result = new ArrayList<String>();

			String query = "SELECT bid FROM TopBook ORDER BY soldnumber DESC";
			
			Connection con =  this.ds.getConnection();
			PreparedStatement p = con.prepareStatement(query);
			p.setMaxRows(10);
		
			ResultSet r = p.executeQuery();
			while(r.next()){
				String bid = r.getString("bid");
				
				result.add(bid);
			}
			r.close();
			p.close();
			con.close();
			
			return result;
	
	

	
	}
	

}
