package bean;

public class SoldBean {
	
	
	public BookBean getBookBean() {
		return bookBean;
	}

	public void setBookBean(BookBean bookBean) {
		this.bookBean = bookBean;
	}

	

	
	private BookBean bookBean;
	
	
	
	
	public SoldBean() {
	}
	
	public SoldBean(BookBean book) {
		this.bookBean = book;
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
