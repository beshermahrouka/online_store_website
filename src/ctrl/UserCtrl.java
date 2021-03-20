package ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AddressBean;
import bean.UserBean;
import model.AddressModel;
import model.ShoppingCart;
import model.UserModel;

/**
 * Servlet implementation class UserCtrl
 */
@WebServlet("/UserCtrl")
public class UserCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	private UserBean currentUser;
	private AddressBean currentUserAddress;

	public UserCtrl() {
		super();
		// TODO Auto-generated constructor stub
	}

	private UserModel um;
	private AddressModel am;

	public void init() throws ServletException {
		try {
			this.um = new UserModel();
			this.am = new AddressModel();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// info of the user
		String username = request.getParameter("new_username");
		String usernamelog = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String new_password = request.getParameter("new_password");
		String province = request.getParameter("province");
		String country = request.getParameter("country");
		String postal = request.getParameter("postal");
		String first_name = request.getParameter("firstname");
		String last_name = request.getParameter("lastname");
		String street = request.getParameter("streetname");
	
		String phone = request.getParameter("phone");

	
		
	
		

		// condition to log in
		if (request.getParameter("login") != null ) {

			try {
				
							
				
				currentUser = um.getUser(usernamelog, password);
				currentUserAddress = am.getAddress(currentUser.getUserID());
				request.getSession().setAttribute("myAccount",
						"Account: " + currentUser.getFirstName() + " " + currentUser.getLastName());
				request.getSession().setAttribute("userCode", currentUser.getUserID());
				
				request.getSession().setAttribute("userinfo", currentUser);
				
				
				request.getSession().setAttribute("useraddress", currentUserAddress);
				
				
				if (currentUser.getUserName().equals("admin")) {
					
					request.getRequestDispatcher("/Analytics.jsp").forward(request, response);
					
				}
				
				
				else {
					
					
					request.getRequestDispatcher("/mainPage.jsp").forward(request, response);
					
				}
				
				
				
				
				
				
				
				
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				request.setAttribute("error", "Invalid.");
				request.getRequestDispatcher("loginPage.jsp").forward(request, response);
			}

		}

		// condition to logout
		else if (request.getParameter("logout") != null) {

			currentUser = null;
			currentUserAddress = null;
			username = null;
			password = null;
		
			usernamelog = null;


			request.getSession().removeAttribute("userinfo");
			request.getSession().removeAttribute("myAccount");
			request.getSession().removeAttribute("userCode");
			request.getSession().removeAttribute("useraddress");
			
		
			
			
			request.getRequestDispatcher("/mainPage.jsp").forward(request, response);

		}

		// condition to register
		else if (request.getParameter("register") != null  ) {
			
			
			
			if ((username.equals("admin"))) {
				request.setAttribute("error", "Registration Failed!");
				request.getRequestDispatcher("registerPage.jsp").forward(request, response);
				
				
			}
			
			else {

			try {
				currentUser = um.addUser(username, new_password, email, first_name, last_name, street, province,
						country, postal, phone);
				request.getSession().setAttribute("myAccount",
						"Account: " + currentUser.getFirstName() + " " + currentUser.getLastName());
				request.getSession().setAttribute("userCode", currentUser.getUserID());
				request.getSession().setAttribute("userinfo", currentUser);
				request.getSession().setAttribute("useraddress", currentUserAddress);
				request.getRequestDispatcher("/mainPage.jsp").forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("error", "Registration Failed!");
				request.getRequestDispatcher("registerPage.jsp").forward(request, response);
			}

		}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
