package model;

import java.util.Map;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;

import bean.BookBean;
import bean.OrderBean;
import dao.BookDao;
import dao.OrderDao;
import dao.ReviewDao;

public class OrderModel {
	
	private OrderDao OrderDAO;
	private static OrderModel instance; 	
	
	public OrderModel() throws ClassNotFoundException {
		
		this.OrderDAO = new OrderDao();
		
	}
	
	
	
	
	
	public static OrderModel getInstance()throws ClassNotFoundException{
		if (instance==null) {
		instance =new OrderModel();
		instance.OrderDAO= new OrderDao();
		
		}
		return instance;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	public OrderBean getOrdersByPartNumber (int id) throws Exception {
		
		return this.OrderDAO.getOrdersByPartNumber(id);
			
	}
	
	
	
public Void addOrder( String lname,String fname,String statue,String address)  throws Exception {
		
		return this.OrderDAO.addOrder(lname, fname, statue, address);
			
	}
	
	
	
	
	

public String export_json(int id) throws Exception {			
	OrderBean result =getOrdersByPartNumber(id);
	
   JsonArrayBuilder builder =  Json.createArrayBuilder();
	
	builder.add(Json.createObjectBuilder().add("lname", result.getLname()).add("fname", result.getFname()).add("statue", result.getStatue()).add("address", result.getAddress()));
		
	

	
	JsonArray arr = builder.build();		
	System.out.println(arr.toString());
	return arr.toString();
	

}

	
	
	
	
	
	
	
	
	
	

}
