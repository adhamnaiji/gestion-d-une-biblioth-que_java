package presentation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import metier.entity.Book1;

public class TableModele2 extends AbstractTableModel {
	
	
	private static final long serialVersionUID = 1L;
	List<Book1> emprunte = new ArrayList<Book1>();
	String title[] = {"Id","Id_b", "Title", "Author", "Url"};
	
	@Override
	public int getColumnCount() {
		return title.length;
	}

	@Override
	public int getRowCount() {
		return emprunte.size();
	}

	@Override
	public Object getValueAt(int l, int c) {
		switch (c) {
		case 0:
			return emprunte.get(l).getId();
		case 1:
			return emprunte.get(l).getId_b(c);
		case 2:
			return emprunte.get(l).getTitle();
		case 3:
			return emprunte.get(l).getAuthor();
		case 4:
			return emprunte.get(l).getUrl();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		return title[column];
	}
	
	public void chargerTable(List<Book1> bookList) {
		emprunte = bookList;
		fireTableDataChanged();
	}


}
