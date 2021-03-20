package model;

import bean.AddressBean;
import dao.AddressDao;

public class AddressModel {
	private AddressDao addressDAO;
	
	
	public AddressModel() throws ClassNotFoundException {
		this.addressDAO = new AddressDao();
		
	}
	
	
	public AddressBean getAddress(int userID) throws Exception{
		return addressDAO.getAddress(userID);
	}
	
	
	
	
	
	
	
}
