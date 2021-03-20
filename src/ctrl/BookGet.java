package ctrl;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.ReviewBean;
import bean.UserBean;
import dao.ReviewDao;
import model.ProductCatalogComponent;

/**
 * Servlet implementation class BookGet
 */
@WebServlet("/BookGet")
public class BookGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductCatalogComponent bookModel;
	String target = "/bookProducts.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookGet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws ServletException {
		try {
			this.bookModel = new ProductCatalogComponent();
		} catch (ClassNotFoundException e) {
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
		response.setContentType("text/plain");

		//get category and book parameter 
		String category = request.getParameter("category");
		String book = request.getParameter("book");
		request.setAttribute("category", category);

		if (category != null && !category.equals("")) {
			try {
				request.setAttribute("books", bookModel.retrieveBookByCategory(category));
				String target = "/bookProducts.jsp";
				request.getRequestDispatcher(target).forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		else if (book != null && !book.equals("")) {

			target = "/bookDetails.jsp";
			try {

				Map<Integer, ReviewBean> bookReviews = new TreeMap<Integer, ReviewBean>();
				
					//get the review of the book			
				bookReviews = bookModel.retrieveReviewByBID(book);
				
				//get the book and set parameter for the review 
				request.setAttribute("book", bookModel.retrieveBookByBID(book));
				request.setAttribute("review", bookReviews);
				
				//get the average rating 
				request.setAttribute("reviewAvg", ReviewDao.AvgBookRating(bookReviews));
				
				
				request.getRequestDispatcher(target).forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		else if (request.getParameter("addreview") != null) {

			try {

				
				
				String currentUser = (String) request.getSession().getAttribute("myAccount");
				int UserCode = (int) request.getSession().getAttribute("userCode");
				int rate = Integer.parseInt(request.getParameter("reviewRating"));
				//add review for the book
				this.bookModel.addNewReview(request.getParameter("reviewBookId"), UserCode, currentUser, rate,
						request.getParameter("myreview"));
				
				request.setAttribute("addreview", null);
				String target = "/mainPage.jsp";
				request.getRequestDispatcher(target).forward(request, response);

			} catch (Exception e) {

				e.printStackTrace();

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
