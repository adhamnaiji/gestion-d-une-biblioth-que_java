package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;


import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.BookImplements;
import dao.IBook;
import dao.SingletonConnection;
import interfacesgrafique_ex1.Connexion;
import metier.entity.Book;

public class InterfaceProject extends JFrame {
	
	//hatha el admin
	
	private static final long serialVersionUID = 1L;
	
	// ImageIcon
	ImageIcon icon = new ImageIcon("C:\\Users\\adham\\Desktop\\Projet_java\\projet\\src\\imgs\\projectIcon.png");
	ImageIcon btnIcon = new ImageIcon("C:\\Users\\adham\\Desktop\\Projet_java\\projet\\src\\imgs\\logo.png");
	ImageIcon homeIcon = new ImageIcon("C:\\Users\\adham\\Desktop\\Projet_java\\projet\\src\\imgs\\home.png");
	ImageIcon addIcon = new ImageIcon("C:\\Users\\adham\\Desktop\\Projet_java\\projet\\src\\imgs\\add.png");
	ImageIcon updateIcon = new ImageIcon("C:\\Users\\adham\\Desktop\\Projet_java\\projet\\src\\imgs\\update.png");
	ImageIcon deleteIcon = new ImageIcon("C:\\Users\\adham\\Desktop\\Projet_java\\projet\\src\\imgs\\delete.png");
	ImageIcon infoIcon = new ImageIcon("C:\\Users\\adham\\Desktop\\Projet_java\\projet\\src\\imgs\\info.png");
	ImageIcon logoutIcon = new ImageIcon("C:\\Users\\adham\\Desktop\\Projet_java\\projet\\src\\imgs\\logout.png");
	ImageIcon brrowingIcon = new ImageIcon("C:\\Users\\adham\\Desktop\\Projet_java\\projet\\src\\imgs\\imgs\\borrowing.png");
	
	// JPanel
	JPanel leftPanel = new JPanel(new GridLayout(0, 1));
	JPanel centerPanel = new JPanel(new GridLayout(1, 1));
	JPanel panelSearch = new JPanel();
	JPanel tabPanel = new JPanel(new GridLayout(1, 1));
	JPanel centerPanelAddProd = new JPanel();
	JPanel addFrm = new JPanel(new GridLayout(8, 1, 10, 10));
	JPanel centerPanelUpdateProd = new JPanel();
	JPanel updateFrm = new JPanel(new GridLayout(7, 1, 10, 10));

	// JLabel
	JLabel logo = new JLabel (btnIcon);
	JLabel lblTitle = new JLabel("Title : ");
	JLabel lblAuthor = new JLabel("Author : ");
	JLabel lblUrl = new JLabel("URL : ");
	JLabel lblTitleUpdate = new JLabel("Title : ");
	JLabel lblAuthorUpdate = new JLabel("Author : ");
	JLabel lblUrlUpdate = new JLabel("URL : ");
	
	// JTextField
	JTextField txtSearch = new JTextField(15);
	JTextField txtTitle = new JTextField(25);
	JTextField txtAuthor = new JTextField(25);
	JTextField txtUrl = new JTextField(25);
	JTextField txtTitleUpdate = new JTextField(25);
	JTextField txtAuthorUpdate = new JTextField(25);
	JTextField txtUrlUpdate = new JTextField(25);
	
	// JButton
	JButton jib=new JButton("importer");
	JButton home = new JButton(" Home ");
	JButton openPdf = new JButton(" Ouvrir PDF ");
	JButton add = new JButton(" Insertion ");
	JButton update = new JButton(" Modification ");
	JButton delete = new JButton(" Suppression ");
	JButton information = new JButton(" Ouvrir PDF ");
	JButton borrowing = new JButton(" Emprunt ");
	JButton logout = new JButton(" Se déconnecter ");
	JButton btnSearch = new JButton("Recherche");
	JButton btnAdd = new JButton("Ajouter");
	JButton btnUpdate = new JButton("Modifier");
	
	// JComboBox
	JComboBox<String> combo = new JComboBox<String>(new String[] {" Title", " Author"});
	
	// JTable
	IBook action = new BookImplements();
	TableModele tm = new TableModele();
	JTable tab = new JTable(tm);
	JScrollPane jsp = new JScrollPane(tab);

	public InterfaceProject() {
		// TODO Auto-generated constructor stub
		
		// Left Panel
		logo.setBorder(BorderFactory.createEmptyBorder());
		logo.setBackground(new Color(23, 43, 77));
		leftPanel.add(logo);
		home.setFocusPainted(false);
		home.setFont(home.getFont().deriveFont(14.0f));
		home.setIcon(homeIcon);
		home.setBorder(null);
		home.setBackground(new Color(23, 43, 77));
		home.setForeground(new Color(94, 114, 228));
		leftPanel.add(home);
		
		add.setFocusPainted(false);
		add.setIcon(addIcon);
		add.setBorder(null);
		add.setBackground(new Color(23, 43, 77));
		add.setForeground(new Color(94, 114, 228));
		leftPanel.add(add);
		
		update.setFocusPainted(false);
		update.setIcon(updateIcon);
		update.setBorder(null);
		update.setBackground(new Color(23, 43, 77));
		update.setForeground(new Color(94, 114, 228));
		leftPanel.add(update);
		
		delete.setFocusPainted(false);
		delete.setIcon(deleteIcon);
		delete.setBorder(null);
		delete.setBackground(new Color(23, 43, 77));
		delete.setForeground(new Color(94, 114, 228));
		delete.setBorder(new EmptyBorder(15, 15, 15,15));
		leftPanel.add(delete);
		
		information.setFocusPainted(false);
		information.setIcon(infoIcon);
		information.setBorder(null);
		information.setBackground(new Color(23, 43, 77));
		information.setForeground(new Color(94, 114, 228));
		leftPanel.add(information);
		
		borrowing.setFocusPainted(false);
		borrowing.setIcon(infoIcon);
		borrowing.setBorder(null);
		borrowing.setBackground(new Color(23, 43, 77));
		borrowing.setForeground(new Color(94, 114, 228));
		leftPanel.add(borrowing);
		
		logout.setFocusPainted(false);
		logout.setIcon(logoutIcon);
		logout.setBorder(null);
		logout.setBackground(new Color(23, 43, 77));
		logout.setForeground(new Color(94, 114, 228));
		leftPanel.add(logout);
		
		leftPanel.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		leftPanel.setBackground(new Color(23, 43, 77));
		
		
		
		
		
		// North Panel Search 
		panelSearch.add(combo);
		
		txtSearch.setBorder(null);
		txtSearch.setFont(txtSearch.getFont().deriveFont(18.0f));
		panelSearch.add(txtSearch);
		
		btnSearch.setFocusPainted(false);
		btnSearch.setBorder(null);
		btnSearch.setBackground(new Color(45, 206, 137));
		btnSearch.setForeground(new Color(244, 245, 247));
		btnSearch.setBorder(new EmptyBorder(4, 10, 4,10));
		panelSearch.add(btnSearch);
		
		panelSearch.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		panelSearch.setBackground(new Color(23, 43, 77));	
		
		
		
		// Center Panel	home 
		tab.getColumnModel().getColumn(0).setPreferredWidth(50);
		tab.getColumnModel().getColumn(1).setPreferredWidth(150);
		tab.getColumnModel().getColumn(2).setPreferredWidth(100);
		tab.getColumnModel().getColumn(3).setPreferredWidth(120);
		tab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tab.setFillsViewportHeight(true);
		tabPanel.add(jsp);
		centerPanel.add(tabPanel);
		centerPanel.setBackground(new Color(23, 43, 77));
		
		
		
		
		// center Panel add prod
		lblTitle.setForeground(new Color(94, 114, 228));
		addFrm.add(lblTitle);
		
		txtTitle.setFont(txtTitle.getFont().deriveFont(18.0f));
		txtTitle.setHorizontalAlignment(JTextField.CENTER);
		txtTitle.setBorder(BorderFactory.createLineBorder(new Color(94, 114, 228), 2));
		addFrm.add(txtTitle);
		
		lblAuthor.setForeground(new Color(94, 114, 228));
		addFrm.add(lblAuthor);
		
		txtAuthor.setFont(txtAuthor.getFont().deriveFont(18.0f));
		txtAuthor.setHorizontalAlignment(JTextField.CENTER);
		txtAuthor.setBorder(BorderFactory.createLineBorder(new Color(94, 114, 228), 2));
		addFrm.add(txtAuthor);
		
		lblUrl.setForeground(new Color(94, 114, 228));
		addFrm.add(lblUrl);
		
		jib.setFocusPainted(false);
		jib.setBackground(new Color(94, 114, 228));
		jib.setForeground(new Color(244, 245, 247));
		addFrm.add(jib);
		
		txtUrl.setFont(txtUrl.getFont().deriveFont(18.0f));
		txtUrl.setHorizontalAlignment(JTextField.CENTER);
		txtUrl.setBorder(BorderFactory.createLineBorder(new Color(94, 114, 228), 2));
		addFrm.add(txtUrl);
		
		
		
		btnAdd.setFocusPainted(false);
		btnAdd.setBackground(new Color(94, 114, 228));
		btnAdd.setForeground(new Color(244, 245, 247));
		addFrm.add(btnAdd);
		
		
		addFrm.setBackground(new Color(23, 43, 77));
		addFrm.setBorder(new EmptyBorder(15, 15, 15,15));
		centerPanelAddProd.add(addFrm);
		
		centerPanelAddProd.setBorder(new EmptyBorder(100, 15, 15,15));
		centerPanelAddProd.setBackground(new Color(23, 43, 77));
		
		
		// center Panel update prod
		lblTitleUpdate.setForeground(new Color(94, 114, 228));
		updateFrm.add(lblTitleUpdate);
		
		txtTitleUpdate.setFont(txtTitleUpdate.getFont().deriveFont(18.0f));
		txtTitleUpdate.setHorizontalAlignment(JTextField.CENTER);
		txtTitleUpdate.setBorder(BorderFactory.createLineBorder(new Color(94, 114, 228), 2));
		updateFrm.add(txtTitleUpdate);
		
		lblAuthorUpdate.setForeground(new Color(94, 114, 228));
		updateFrm.add(lblAuthorUpdate);
		
		txtAuthorUpdate.setFont(txtAuthorUpdate.getFont().deriveFont(18.0f));
		txtAuthorUpdate.setHorizontalAlignment(JTextField.CENTER);
		txtAuthorUpdate.setBorder(BorderFactory.createLineBorder(new Color(94, 114, 228), 2));
		updateFrm.add(txtAuthorUpdate);
		
		lblUrlUpdate.setForeground(new Color(94, 114, 228));
		updateFrm.add(lblUrlUpdate);
		
		txtUrlUpdate.setFont(txtUrlUpdate.getFont().deriveFont(18.0f));
		txtUrlUpdate.setHorizontalAlignment(JTextField.CENTER);
		txtUrlUpdate.setBorder(BorderFactory.createLineBorder(new Color(94, 114, 228), 2));
		updateFrm.add(txtUrlUpdate);
		
		btnUpdate.setFocusPainted(false);
		btnUpdate.setBackground(new Color(94, 114, 228));
		btnUpdate.setForeground(new Color(244, 245, 247));
		updateFrm.add(btnUpdate);
		
		updateFrm.setBackground(new Color(23, 43, 77));
		updateFrm.setBorder(new EmptyBorder(15, 15, 15,15));
		centerPanelUpdateProd.add(updateFrm);
		
		centerPanelUpdateProd.setBorder(new EmptyBorder(100, 15, 15,15));
		centerPanelUpdateProd.setBackground(new Color(23, 43, 77));
		
		
		
		// this Panel
		this.add(panelSearch, BorderLayout.NORTH);
		this.add(leftPanel, BorderLayout.WEST);
		this.add(centerPanel, BorderLayout.CENTER);
		
		
		
		/* Code */
		
		logout.addActionListener(e -> {
			this.dispose();
			new Connexion();
		});
		
		borrowing.addActionListener(e -> {
			 try 
			  {
			      String url = "jdbc:mysql://localhost:3306/booklibrary?autoReconnect=true&useSSL=false";
			      String user = "root";
			      String password = "";
			    
			      Connection con = DriverManager.getConnection(url, user, password);
			    
			      String query = "SELECT * FROM emprunte";
			    
			      Statement stm = con.createStatement();
			      ResultSet res = stm.executeQuery(query);
			    
			      String columns[] = { "id","id_b", "title", "author","url" };
			      String data[][] = new String[8][5];
			    
			      int i = 0;
			      while (res.next()/* && distinct valeur id_b*/) {
			        int id = res.getInt("id");
			        String id_b = res.getString("id_b");
			        String title = res.getString("title");
			        String author = res.getString("author");
			        String url2 = res.getString("url");
			        data[i][0] = id + "";
			        data[i][1] =id_b;
			        data[i][2] = title;
			        data[i][3] =author;
			        data[i][4] =url2;
			        i++;
			      }
			    
			      DefaultTableModel model = new DefaultTableModel(data, columns);
			      JTable table = new JTable(model);
			      table.setShowGrid(true);
			      table.setShowVerticalLines(true);
			      JScrollPane pane = new JScrollPane(table);
			      JFrame f = new JFrame("les livres emprunteés");
			      JPanel panel = new JPanel();
			      panel.add(pane);
			      f.add(panel);
			      f.setSize(500, 250);
			      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			      f.setVisible(true);
			    
			    } catch(SQLException e3) {
			      e3.printStackTrace();
			    }
			  
		});
		
		information.addActionListener(e -> {
			if (tab.getSelectedRow() == -1)
				JOptionPane.showMessageDialog(this, "Select an item");
			else {
				try {
					String url = (String) tab.getValueAt(tab.getSelectedRow(), 3);
			        File myFile = new File(url);
			        Desktop.getDesktop().open(myFile);
			    } catch (IOException ex) {
			        ex.printStackTrace();
			    }
			}
		});
		jib.addActionListener(e->{
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

			int returnValue = jfc.showOpenDialog(null);
			// int returnValue = jfc.showSaveDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = jfc.getSelectedFile();
				txtUrl.setText(selectedFile.getAbsolutePath());
			}
		});
		
		add.addActionListener(e -> {
			allVisibleFalse();
			centerPanelAddProd.setVisible(true);
			this.add(centerPanelAddProd, BorderLayout.CENTER);
			this.setTitle("Home - Add Book");
			
			
		});
		
		update.addActionListener(e -> {
			if (tab.getSelectedRow() == -1)
				JOptionPane.showMessageDialog(this, "Select an item");
			else {
				allVisibleFalse();
				centerPanelUpdateProd.setVisible(true);
				txtTitleUpdate.setText(String.valueOf(tab.getValueAt(tab.getSelectedRow(), 1)));
				txtAuthorUpdate.setText(String.valueOf(tab.getValueAt(tab.getSelectedRow(), 2)));
				txtUrlUpdate.setText(String.valueOf(tab.getValueAt(tab.getSelectedRow(), 3)));
				this.add(centerPanelUpdateProd, BorderLayout.CENTER);
				this.setTitle("Home - Update Book");
			}
		});
		
		home.addActionListener(e -> {
			allVisibleFalse();
			centerPanel.setVisible(true);
			this.add(centerPanel, BorderLayout.CENTER);
			this.setTitle("Home");
		});
		
		btnAdd.addActionListener(e -> {
			String Title = txtTitle.getText();
			String Author = txtAuthor.getText();
			String Url = txtUrl.getText();
			if (Title.equals("") || Author.equals("") || Url.equals(""))
				JOptionPane.showMessageDialog(this, "Typing Error!", "Error", JOptionPane.ERROR_MESSAGE);
			else {
				action.addBook(new Book(Title, Author, Url));
				tm.chargerTable(action.getAllBook());
				JOptionPane.showMessageDialog(this, "data successfully added", "Success", JOptionPane.INFORMATION_MESSAGE);
				allVisibleFalse();
				centerPanel.setVisible(true);
				this.add(centerPanel, BorderLayout.CENTER);
				clearAddFrm();
			}
		});
		
		btnUpdate.addActionListener(e -> {
			int id = (int) tab.getValueAt(tab.getSelectedRow(), 0);
			String TitleUpdate = txtTitleUpdate.getText();
			String AuthorUpdate = txtAuthorUpdate.getText();
			String UrlUpdate = txtUrlUpdate.getText();
			if (TitleUpdate.equals("") || AuthorUpdate.equals("") || UrlUpdate.equals(""))
				JOptionPane.showMessageDialog(this, "Typing Error!", "Error", JOptionPane.ERROR_MESSAGE);
			else {
				action.updateBook(new Book(id, TitleUpdate, AuthorUpdate, UrlUpdate));
				tm.chargerTable(action.getAllBook());
				JOptionPane.showMessageDialog(this, "data successfully updated", "Success", JOptionPane.INFORMATION_MESSAGE);
				allVisibleFalse();
				centerPanel.setVisible(true);
				this.add(centerPanel, BorderLayout.CENTER);
				clearAddFrm();
			}
		});
		
		delete.addActionListener(e -> {			
			if (tab.getSelectedRow() == -1)
				JOptionPane.showMessageDialog(this, "Select an item");
			else {
				int n = JOptionPane.showConfirmDialog(
						null,
			            "Are you sure you want to delete this item ?\n\nTitle : " +  
						tab.getValueAt(tab.getSelectedRow(), 1) + "\nAuthor : "
						+ tab.getValueAt(tab.getSelectedRow(), 2) + "\n\n",
			            "Confirm deletion",
			            JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					action.deleteBook((int) tab.getValueAt(tab.getSelectedRow(), 0));
					tm.chargerTable(action.getAllBook());
				}
			}
		});
		
		btnSearch.addActionListener(e -> {
			allVisibleFalse();
			centerPanel.setVisible(true);
			String word = txtSearch.getText();
			String type = combo.getSelectedItem().toString();
			tm.chargerTable(action.searchBook(word, type));
		});
		
		tab.addMouseListener(new MouseAdapter() {
	         public void mouseClicked(MouseEvent me) {
	        	 if(me.getClickCount()==1) {
	        		 int idd = (Integer) tab.getValueAt(tab.getSelectedRow(), 0);
	        	 }
	        	 else if (me.getClickCount() == 2) {
	               try {
						String url = (String) tab.getValueAt(tab.getSelectedRow(), 3);
				        File myFile = new File(url);
				        Desktop.getDesktop().open(myFile);
				    } catch (IOException ex) {
				        ex.printStackTrace();
				    }
	            }
	         }
	      });
				
		// form Configuration
		this.setSize(800,600);
		this.setVisible(true);
		this.setTitle("Home admin");	
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setIconImage(icon.getImage());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(23, 43, 77));
		tm.chargerTable(action.getAllBook());
	}
	public void allVisibleFalse() {
		centerPanel.setVisible(false);
		centerPanelAddProd.setVisible(false);
		centerPanelUpdateProd.setVisible(false);
	}
	
	public void clearAddFrm() {
		txtTitle.setText("");
		txtAuthor.setText("");
		txtUrl.setText("");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InterfaceProject();
	}

}