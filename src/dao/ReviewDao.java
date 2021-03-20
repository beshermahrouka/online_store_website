package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.HashMap;
import java.util.Map;
import java.sql.SQLException;

import javax.naming.InitialContext;

import javax.sql.DataSource;

import bean.ReviewBean;

public class ReviewDao {

	DataSource ds;
	

	public ReviewDao() throws ClassNotFoundException {
		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	public static String AvgBookRating(Map<Integer, ReviewBean> my_input) {
		
		float total_Rating = 0;

		//loop to add all rating  
		for (Map.Entry<Integer, ReviewBean> entry : my_input.entrySet()) {
			
			
			//update total 
			total_Rating = total_Rating + entry.getValue().getRating();
		}
		//divide to get avg rating 
		return total_Rating / my_input.size() + "";
	}

	public ReviewBean addNewReview(String bid, int userid, String username, int rating, String review_write)
			throws SQLException {
		ReviewBean review = null;
		try {

			Connection con = this.ds.getConnection();
			String col = "SELECT count(*) FROM review";
			PreparedStatement number_col = con.prepareStatement(col);
			ResultSet result = number_col.executeQuery();
			result.next();
			int count = result.getInt(1);
			count++;
			result.close();
			number_col.close();

			String q1 = "INSERT INTO Review values(?,?,?,?,?)";
			PreparedStatement p = con.prepareStatement(q1);
			p.setInt(1, count);
			p.setString(2, bid);
			p.setInt(3, userid);

			p.setInt(4, rating);
			p.setString(5, review_write);

			p.executeUpdate();

			 review = new ReviewBean(count, bid, userid, username, rating, review_write);

			p.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return review;
	}

	public Map<Integer, ReviewBean> retrieveByBID(String bid) throws SQLException {
		String query = "select * from review where bid like ?";

		Map<Integer, ReviewBean> rv = new HashMap<Integer, ReviewBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		p.setString(1, bid);
		ResultSet r = p.executeQuery();
		//result set one
		while (r.next()) {
			String username = "";
			
			int userid = r.getInt("userid");
			
			int reviewid = r.getInt("reviewid");
			//second query to get user name 
			String usernameQuery = "select username from users where userid = ?";
			
			
			PreparedStatement p2 = con.prepareStatement(usernameQuery);
			p2.setInt(1, userid);
			// second result set 
			ResultSet r2 = p2.executeQuery();
			while (r2.next()) {
				username = r2.getString("username");
			}
			//add to review bean
			ReviewBean new_review = new ReviewBean(reviewid, r.getString("bid"), userid, username, r.getInt("rating"),
					r.getString("reviewdesc"));
			rv.put(reviewid, new_review);
		}
		r.close();
		p.close();
		con.close();

		return rv;
	}
	

}
