package model;

import dao.BookDao;

import dao.ReviewDao;

import java.io.FileWriter;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;

import bean.BookBean;
import bean.ReviewBean;

public class ProductCatalogComponent {
	
	private BookDao bookDao;
	private ReviewDao reviewDao; 
	
	
	private static ProductCatalogComponent instance;
	
	
	
	public ProductCatalogComponent() throws ClassNotFoundException {
		this.bookDao = new BookDao();
		this.reviewDao = new ReviewDao();
	
	}
	
	
	
	public static ProductCatalogComponent getInstance()throws ClassNotFoundException{
		if (instance==null) {
		instance =new ProductCatalogComponent();
		instance.bookDao= new BookDao();
		instance.reviewDao = new ReviewDao();
		}
		return instance;
		}
	
	
	
	
	// Books
		public Map<String, BookBean> retrieveBookByCategory(String category) throws Exception {
			if(category.equalsIgnoreCase("All")) {
				return this.bookDao.retrieveAll();
			}
			return this.bookDao.retrieveAllByCategory(category);
		}
		
		public Map<String, BookBean> retrieveBookByBID(String bid) throws Exception {
			return this.bookDao.retrieveByBID(bid);
		}
	
	
		// Reviews
		public Map<Integer, ReviewBean> retrieveReviewByBID(String bid) throws Exception {
			return this.reviewDao.retrieveByBID(bid);
		}
		
		public ReviewBean addNewReview(String bid, int userid, String username, int rating, String review_write) throws Exception {
			return this.reviewDao.addNewReview(bid, userid, username, rating, review_write);
		}
		
		
		
		
			
		
		
		public String export_json(String bid) throws Exception {			
			Map<String, BookBean> result =retrieveBookByBID(bid);
			
		   JsonArrayBuilder builder =  Json.createArrayBuilder();
			
			for (String x : result.keySet()) {
				BookBean temp = result.get(x);
				builder.add(Json.createObjectBuilder().add("bid", temp.getBid()).add("title", temp.getTitle()).add("author", temp.getAuthor()).add("publisher", temp.getPublisher()).add("category", temp.getCategory()).add("price", temp.getPrice()));
				
			}
		
			
			JsonArray arr = builder.build();		
			System.out.println(arr.toString());
			return arr.toString();
			

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}
