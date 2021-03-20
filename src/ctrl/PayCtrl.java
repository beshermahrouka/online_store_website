package ctrl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AddressBean;
import bean.CartBean;
import bean.SoldBean;
import bean.UserBean;
import listener.Top;
import model.AddressModel;
import model.OrderModel;
import model.PayModel;
import model.UserModel;

/**
 * Servlet implementation class PayCtrl
 */
@WebServlet("/PayCtrl")
public class PayCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
    
    private OrderModel om;
    private UserModel um;
	private AddressModel am;
	private PayModel pm;

	public void init() throws ServletException {
		try {
			this.um = new UserModel();
			this.am = new AddressModel();
			this.pm = new PayModel();
			this.om = new OrderModel();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//transfer to string address from address model to address bean
		
		
		
		
		if (request.getParameter("soldmonth") != null) {
			
			Map<String, SoldBean> result =  new HashMap<String, SoldBean>();
			
			try {
			       result = this.pm.retrieveBooksSoldByMonth(request.getParameter("TheMonth"));
			       String t = request.getParameter("TheMonth");
			       request.setAttribute("m", t);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			List<SoldBean> results = new ArrayList<SoldBean>();
			
			for (String s : result.keySet()) {
				results.add(result.get(s));
			}
			int numberOfResults = result.size();
			request.setAttribute("numberOfResultsSold", numberOfResults);
		
			request.setAttribute("result_sold", results.toArray());
			
			
			String target = "/Analytics.jsp";

			request.getRequestDispatcher(target).forward(request, response);
						
			
		}
		
		else {
			
			
			
			
			
			

			
			 AddressBean currentUserAddress;
			 
			 currentUserAddress = (AddressBean) request.getSession().getAttribute("useraddress");
			 
			 
			 String user_address= "";
			 
			 try {
				 user_address = currentUserAddress.addressToString();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			
			
			String bill = request.getParameter("billing");
			System.out.print (bill);
			
			if (request.getParameter("pay") != null) {
				
				      if (bill.equals(user_address) &&( !request.getParameter("credit").equals(""))) {
				    	  
				    	  //add processed
				    	  UserBean u = (UserBean) request.getSession().getAttribute("userinfo");
				    	  Random rn = new Random();

				    	  try {
							this.om.addOrder(u.getLastName(), u.getFirstName(), "PROCESSED", rn.nextInt(40 - 1 + 1) + 1 + "");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				    	  
				    	  ArrayList<CartBean> result =  (ArrayList<CartBean>) request.getSession().getAttribute("list");
				    	  
				    	  for (CartBean x : result) {
				    		  
				    		  try {
								pm.addSold("12202016","12", x.getBid(), "PURCHASE");
								pm.addtop(x.getBid());
								request.getSession().setAttribute("new_top",x);
								request.getSession().setAttribute("newUpdate", Top.getTop());
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				    		  
				    		  
				    		  
				    	  }
				    	  
				    	  ArrayList<String> d = new ArrayList<String>();
				    	  try {
							d= this.pm.selectTop();
							request.getSession().setAttribute("newUpdate", d);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    	  
				    	  
			    	      request.setAttribute("paysuc", "Payment was successfull !!!!!!");
				    	  request.getSession().removeAttribute("list");
						  request.getSession().removeAttribute("cart_price");					  
						  String target = "/paymentPage.jsp";
					      request.getRequestDispatcher(target).forward(request, response);
						  
				    	  
				    	  
				    	  
				    	  
				    	  
				      }
				      else {
				    	  
				    	  
				    	  //add decline
				    	  UserBean u = (UserBean) request.getSession().getAttribute("userinfo");
				    	  Random rn = new Random();
				    	  try {
								this.om.addOrder(u.getLastName(), u.getFirstName(), "DENIED", rn.nextInt(40 - 1 + 1) + 1 + "");
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
				    	  
				    	  
				    	  
				    	
				    	  
				    	  
				    	  
				  
				    	  request.setAttribute("paysuc", "error !!!!!!!!!!!");
				    	  String target = "/paymentPage.jsp";

							request.getRequestDispatcher(target).forward(request, response);
				    	 
				    	  
				      }		
			
	}
			
			
			
		
			
			
		}
		
		
		
	
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
