package bean;

public class AddressBean {
	private int userID;
	private String street;
	private String province;
	private String country;
	private String zip;
	private String phone;

	public AddressBean(int userID, String street, String province,
			String country, String zip, String phone) {
		this.userID = userID;
		this.street = street;
		this.province = province;
		this.country = country;
		this.zip = zip;
		this.phone = phone;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
	public String addressToString() throws Exception {
		
		
		String result = "" + this.getStreet() + " " + this.getProvince() + " " + this.getCountry() + " " +this.getZip(); 		
		return result;				
	}
	
	
	
	
	
	
	
	
	
	

}
