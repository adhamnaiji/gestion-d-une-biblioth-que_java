package metier.entity;

public class Book {
	
	private int id,id_b;
	private String Title, Author, Url;
	//
	public Book() {
		
	}
	//
	
	public Book(String Title, String Author, String Url) {
	
		this.Title = Title;
		this.Author = Author;
		this.Url = Url;
	}
	//
	public Book(int id, String Title, String Author, String Url) {
		this.id = id;
		this.Title = Title;
		this.Author = Author;
		this.Url = Url;
	}
	
	public int getId() {
		return id;
	}
		
	public String getTitle() {
		return Title;
	}
	
	public String getAuthor() {
		return Author;
	}
	
	public String getUrl() {
		return Url;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setTitle(String Title) {
		this.Title = Title;
	}
	
	public void setAuthor(String Author) {
		this.Author = Author;
	}
	
	public void setUrl(String Url) {
		this.Url = Url;
	}

	public int getId_b(int id_b) {
		
		return id_b;
	}
	
}
