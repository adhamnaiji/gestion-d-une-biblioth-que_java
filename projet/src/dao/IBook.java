package dao;

import java.util.List;

import metier.entity.Book;

public interface IBook {

	public void addBook(Book b);
	public Book getBook(int id);
	public List<Book> getAllBook();
	public List<Book> searchBook(String word, String type);
	public void updateBook(Book b);
	public void deleteBook(int id);
	public void addBookemp(Book b);
	public List<Book> getAllBook2();
	
}
