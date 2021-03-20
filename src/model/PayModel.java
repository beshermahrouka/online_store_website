package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import bean.SoldBean;
import dao.SoldDao;

public class PayModel {

	
	
private SoldDao SoldDAO;
	
	
	public PayModel() throws ClassNotFoundException {
		this.SoldDAO = new SoldDao();
		
	}
	
	
	public Map<String, SoldBean> retrieveBooksSoldByMonth(String month) throws SQLException {
		
		return this.SoldDAO.retrieveBooksSoldByMonth(month);
				
	}
	
	
	
	public Void addSold( String day ,String month, String bid , String eventtype) throws SQLException {

	return this.SoldDAO.addSold(day,month, bid, eventtype);	
		
	}
	
	
	
	
	
	//for listener 
	
	public Void addtop( String bid) throws Exception {
		
		
		return this.SoldDAO.addtop(bid);
	}
	
	// for listener 
	public ArrayList<String> selectTop() throws SQLException {
		
		
		return this.SoldDAO.selectTop();
		
		
	}
	
	
	
}
