package bean;

public class OrderBean {
	
	private String id;
	private String lname;
	private String fname;
	private String Statue;
	private String address;
	
	
	public OrderBean() {
		
	}
	
	
	public OrderBean(String id, String lname,String fname,String statue,String address) {
	
	this.id = id;
	this.lname =lname;
	this.fname = fname;
	this.Statue = statue;
	this.address = address;
		
	
}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getStatue() {
		return Statue;
	}


	public void setStatue(String statue) {
		Statue = statue;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}




}