package rest;

import java.io.File;
import java.lang.reflect.Type;
import java.net.URI;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


import bean.UserBean;
import model.AddressModel;
import model.OrderModel;
import model.PayModel;
import model.ProductCatalogComponent;
import model.UserModel;
import bean.AddressBean;
import bean.BookBean;
import bean.SoldBean;

@Path("partner") // this is the path of the resource
public class Partner {

	@GET
	@Path("/getProduct/")
	@Produces("text/plain")
	public String getProduct(@QueryParam("bid") String bid) throws Exception {
		return ProductCatalogComponent.getInstance().export_json(bid);
	}

	@GET
	@Path("/getOrder/")
	@Produces("text/plain")
	public String getOrder(@QueryParam("id") int id) throws Exception {
		return OrderModel.getInstance().export_json(id);
	}



	
	  @GET  
	  @Path("/loginUser/")
	  @Produces("text/plain") 
	  public String login(@QueryParam("username") String username, @QueryParam("password") String password) {
		  try {
			UserModel u = new UserModel();
			UserBean temp = u.getUser(username, password);
			if(temp == null) {
				return "";
			}else {
				JsonArrayBuilder builder =  Json.createArrayBuilder();
				builder.add(Json.createObjectBuilder().add("firstname", temp.getFirstName()).add("lastname", temp.getLastName()).add("type", temp.getType()).add("userID", temp.getUserID()).add("username", temp.getUserName()).add("password", temp.getPassword()).add("email", temp.getEmail()));
				JsonArray arr = builder.build();	
				return arr.toString();
			}

		  } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return "";
	  }

	  
	  
	  	  
	  @GET
	  
	  @Path("/selectTop/")
	  
	  @Produces("text/plain")
	  
	  public String selectTop() {
		  try {
			PayModel p = new PayModel();
			ArrayList<String> temp = p.selectTop();
			JsonArrayBuilder builder =  Json.createArrayBuilder();
			
			for(int i =0; i <temp.size();i++) {
				builder.add(Json.createObjectBuilder().add("Book", temp.get(i)));
			}
			JsonArray arr = builder.build();	
			return arr.toString();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		return null;
		  
	  }
	  
	  @GET
	  
	  @Path("/booksByMonth/")
	  
	  @Produces("text/plain")
	  
	  public String booksByMonth(@QueryParam("month") String month) {
			try {
				PayModel p = new PayModel();
				Map<String,SoldBean> x = p.retrieveBooksSoldByMonth(month);
				
		        Iterator<Map.Entry<String, SoldBean>> itr = x.entrySet().iterator(); 
				JsonArrayBuilder builder =  Json.createArrayBuilder();
  
		        while(itr.hasNext()) 
		        { 
		             Entry<String, SoldBean> entry = itr.next(); 
		            builder.add(bookToJson(entry.getValue().getBookBean())); 
		        }
				JsonArray arr = builder.build();	
				return arr.toString();

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		  
		  return "";
	  }
	  
	  public JsonArrayBuilder bookToJson(BookBean b) {
			JsonArrayBuilder builder =  Json.createArrayBuilder();
			builder.add(Json.createObjectBuilder().add("bid", b.getBid()).add("title", b.getTitle()).add("author", b.getAuthor()).add("publisher", b.getPublisher()).add("coverart", b.getCoverart()).add("price", b.getPrice()).add("category", b.getCategory()).add("description", b.getDescription()));
			return builder;
			
	  }

	  @GET
	  
	  @Path("/getAddress/")
	  
	  @Produces("text/plain")
	  
	  public String getAddress(@QueryParam("userID") String userID) {
		  try {
			AddressModel a = new AddressModel();
			AddressBean temp = a.getAddress(Integer.parseInt(userID));
			if(temp == null) {
				return "";
			}else {
				JsonArrayBuilder builder =  Json.createArrayBuilder();
				builder.add(Json.createObjectBuilder().add("userID", temp.getUserID()).add("Street", temp.getStreet()).add("Province", temp.getProvince()).add("Country", temp.getCountry()).add("zip", temp.getZip()).add("phone", temp.getPhone()));
				JsonArray arr = builder.build();	
				return arr.toString();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		  
	  }

}



	  
