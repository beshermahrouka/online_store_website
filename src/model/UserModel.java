package model;
import bean.UserBean;
import dao.LoginDao;
import dao.RegisterDao;
public class UserModel {
	private LoginDao login;
	private RegisterDao register;
	public UserModel() throws ClassNotFoundException {
		this.login = new LoginDao();
		this.register = new RegisterDao();
	}
	public UserBean getUser(String username, String password) throws Exception {

		if ((username == null || username.equals("")) || (password == null||password.equals(""))) {
			
			throw new Exception("error");
		}
		else {
		UserBean result = this.login.loginUser(username, password);
		return result;
	}	
	}
	
	public UserBean addUser(String username, String pwd, String email, String fName, String lName, String street,
			String province, String country, String zip, String phoneNumber) throws Exception {
		
		if ((username == null || username.equals("")) || (pwd == null || pwd.equals("")) || (email ==null || email.equals(""))|| (fName == null||fName.equals("")) || (lName == null||lName.equals("")) || (street == null||street.equals("")) || (province == null||province.equals("")) || (country == null||country.equals("")) || (zip == null||zip.equals("")) || (phoneNumber == null||phoneNumber.equals(""))) {
						
			throw new Exception("error");			
		}			
		else {
				
		UserBean result = this.register.addUser(username, pwd, email, fName, lName, street, province, country, zip,
				phoneNumber);
		return result;
	}
	}			
}