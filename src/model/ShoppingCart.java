package model;

import java.sql.SQLException;
import java.util.ArrayList;
import bean.CartBean;
import dao.CartDao;

public class ShoppingCart {

	private ArrayList<CartBean> cart;

	private CartDao cd;
	private float total;

	public ShoppingCart() throws ClassNotFoundException {
		cart = new ArrayList<CartBean>();
		total = 0;
		this.cd = new CartDao();
	}

	public void add(CartBean cartb) throws Exception {
		
		String bid = cartb.getBid();
		for (CartBean element : cart) {
			if (bid.equals(element.getBid())) {
				
				
				element.setQuantity(element.getQuantity() + 1);
				
				total = total + cartb.getPrice();
				return;
			}
		}

		cart.add(cartb);
		total = total + cartb.getPrice();
	}

	public CartBean findById(String id) throws SQLException {
		
		
		return cd.findById(id);
	}

	public void increment(String id) {

		for (CartBean element : cart) {
			if (id.equals(element.getBid())) {
				
				
				element.setQuantity(element.getQuantity() + 1);
				
				total = total + element.getPrice();
				return;
			}
		}
	}

	public void removeAll(String id) {
		for (CartBean element : cart) {
			
			if (id.equals(element.getBid())) {
				
				
				total = total - element.getQuantity() * element.getPrice();
				
				cart.remove(element);
				
				return;
			}
		}
	}

	public void decrement(String id) {
		for (CartBean element : cart) {
			
			
			if (id.equals(element.getBid())) {
				
				total = total - element.getPrice();
				

				if (element.getQuantity() == 1) {
					
					cart.remove(element);
					
				} else {
					element.setQuantity(element.getQuantity() - 1);
					
				}
				return;
			}
		}
	}

	public float getTotal() {
		return total;
	}

	public void reset_total() {

		total = 0;
	}

	public void reset_chart() {

		cart = new ArrayList<CartBean>();

	}

	public ArrayList<CartBean> getCart() {
		return cart;
	}

}
