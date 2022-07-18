package presentation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import metier.entity.Book;

public class TableModele extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	List<Book> book = new ArrayList<Book>();
	String title[] = {"Id", "Title", "Author", "Url"};
	
	@Override
	public int getColumnCount() {
		return title.length;
	}

	@Override
	public int getRowCount() {
		return book.size();
	}

	@Override
	public Object getValueAt(int l, int c) {
		switch (c) {
		case 0:
			return book.get(l).getId();
		case 1:
			return book.get(l).getTitle();
		case 2:
			return book.get(l).getAuthor();
		case 3:
			return book.get(l).getUrl();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		return title[column];
	}
	
	public void chargerTable(List<Book> bookList) {
		book = bookList;
		fireTableDataChanged();
	}

}
