package bean;

public class UserBean {
	private String firstName;
	private String lastName;
	private String type;
	private int userID;
	private String userName;
	private String password;
	private String email;

	
	public UserBean(int userID, String userName, String password, String email, String firstName, String lastName, String type) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.type = type;
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.email = email;
		
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
