package ctrl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CartBean;
import model.ShoppingCart;

/**
 * Servlet implementation class CtrlCart
 */
@WebServlet("/CtrlCart")
public class CtrlCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CtrlCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	private ShoppingCart sc;

	private boolean view = false;

	public void init() throws ServletException {
		try {
			this.sc = new ShoppingCart();
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
		
		
         
		
		
		
		
		
		

		if (request.getParameter("book") != null && request.getParameter("cart").equals("add")) {
			
			String bid = request.getParameter("book");
			try {

				sc.reset_total();

				if (request.getSession().getAttribute("list") != null) {
					ArrayList<CartBean> result = (ArrayList<CartBean>) request.getSession().getAttribute("list");

					sc.reset_chart();

					for (CartBean a : result) {
						sc.add(a);
					}
				}

				CartBean cb = sc.findById(bid);
				sc.add(cb);

				request.getSession().setAttribute("list", sc.getCart());
				request.getSession().setAttribute("cart_price", sc.getTotal());
				String target = "/shoppingCart.jsp";

				request.getRequestDispatcher(target).forward(request, response);
			} catch (Exception e) {
			}
		}

		if (request.getParameter("cart") != null && request.getParameter("cart").equals("view")) {

			String target = "/shoppingCart.jsp";
			request.getRequestDispatcher(target).forward(request, response);

		}

		if (request.getParameter("cart") != null && request.getParameter("cart").equals("remove")) {

			sc.removeAll(request.getParameter("book"));
			request.getSession().setAttribute("list", sc.getCart());
			request.getSession().setAttribute("cart_price", sc.getTotal());
			String target = "/shoppingCart.jsp";
			request.getRequestDispatcher(target).forward(request, response);

		}

		if (request.getParameter("cart") != null && request.getParameter("cart").equals("increment")) {

			sc.increment(request.getParameter("book"));
			request.getSession().setAttribute("list", sc.getCart());
			request.getSession().setAttribute("cart_price", sc.getTotal());
			String target = "/shoppingCart.jsp";
			request.getRequestDispatcher(target).forward(request, response);

		}

		if (request.getParameter("cart") != null && request.getParameter("cart").equals("decrement")) {

			sc.decrement(request.getParameter("book"));
			request.getSession().setAttribute("list", sc.getCart());
			request.getSession().setAttribute("cart_price", sc.getTotal());
			String target = "/shoppingCart.jsp";
			request.getRequestDispatcher(target).forward(request, response);

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
