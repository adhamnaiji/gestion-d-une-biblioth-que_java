package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entity.Book;

public class BookImplements implements IBook {

	@Override
	public void addBook(Book b) {
		Connection cx = SingletonConnection.getInstance();
		try {
			PreparedStatement st = cx.prepareStatement("insert into book(title, author, url) values(?, ?, ?)");
			st.setString(1, b.getTitle());
			st.setString(2, b.getAuthor());
			st.setString(3, b.getUrl());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void addBookemp(Book b) {
		Connection cx = SingletonConnection.getInstance();
		try {
			PreparedStatement st = cx.prepareStatement("insert into book(id,id_b,title, author, url) values(null,?, ?, ?)");
			st.setString(1, b.getTitle());
			st.setString(2, b.getAuthor());
			st.setString(3, b.getUrl());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Book getBook(int id) {
		Connection cx = SingletonConnection.getInstance();
		Book b = null;
		try {
			PreparedStatement ps = cx.prepareStatement("select * from book where id=? order by id");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				b = new Book();
				b.setId(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setUrl(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<Book> getAllBook() {
		Connection cx = SingletonConnection.getInstance();
		List<Book> bookList = new ArrayList<Book>();
		try {
			PreparedStatement ps = cx.prepareStatement("select * from book order by id");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book b = new Book();
				b.setId(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setUrl(rs.getString(4));
				bookList.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}
	
	
	@Override
	public List<Book> getAllBook2() {
		Connection cx = SingletonConnection.getInstance();
		List<Book> bookList = new ArrayList<Book>();
		try {
			PreparedStatement ps = cx.prepareStatement("select * from book order by id");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book b = new Book();
				b.setId(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setUrl(rs.getString(4));
				bookList.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}

	@Override
	public List<Book> searchBook(String word, String type) {
		Connection cx = SingletonConnection.getInstance();
		List<Book> bookList = new ArrayList<Book>();
		try {
			PreparedStatement ps;
			if (type.equals(" Title"))
				ps = cx.prepareStatement("select * from book where Title like ?");
			else
				ps = cx.prepareStatement("select * from book where Author like ?");
			ps.setString(1, "%" + word + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book b = new Book();
				b.setId(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setUrl(rs.getString(4));
				bookList.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}

	@Override
	public void updateBook(Book b) {
		Connection cx = SingletonConnection.getInstance();
		try {
			PreparedStatement st = cx.prepareStatement("update book set Title=?, Author=?, Url=? where id=?");
			st.setString(1, b.getTitle());
			st.setString(2, b.getAuthor());
			st.setString(3, b.getUrl());
			st.setInt(4, b.getId());
			st.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void deleteBook(int id) {
		Connection cx = SingletonConnection.getInstance();
		try {
			PreparedStatement st = cx.prepareStatement("delete from book where id=?");
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
