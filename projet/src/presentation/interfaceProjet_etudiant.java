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
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import dao.BookImplements;
import dao.IBook;
import dao.SingletonConnection;
import interfacesgrafique_ex1.Connexion;
import metier.entity.Book;
public class interfaceProjet_etudiant extends JFrame {
	
	//hatha el user
	private static final long serialVersionUID = 1L;
	
	// ImageIcon
	ImageIcon icon = new ImageIcon("C:\\Users\\adham\\Desktop\\Projet_java\\projet\\src\\imgs\\projectIcon.png");
	ImageIcon btnIcon = new ImageIcon("C:\\Users\\adham\\Desktop\\Projet_java\\projet\\src\\imgs\\logo.png");
	ImageIcon homeIcon = new ImageIcon("C:\\Users\\adham\\Desktop\\Projet_java\\projet\\src\\imgs\\home.png");
	ImageIcon infoIcon = new ImageIcon("C:\\Users\\adham\\Desktop\\Projet_java\\projet\\src\\imgs\\info.png");
	ImageIcon logoutIcon = new ImageIcon("C:\\Users\\adham\\Desktop\\Projet_java\\projet\\src\\imgs\\logout.png");
	ImageIcon brrowingIcon = new ImageIcon("C:\\Users\\adham\\Desktop\\Projet_java\\projet\\src\\imgs\\imgs\\borrowing.png");
	
	// JPanel
	JPanel leftPanel = new JPanel(new GridLayout(0, 1));
	JPanel centerPanel = new JPanel(new GridLayout(1, 1));
	JPanel panelSearch = new JPanel();
	JPanel tabPanel = new JPanel(new GridLayout(1, 1));
	JPanel centerPanelAddProd = new JPanel();
	JPanel addFrm = new JPanel(new GridLayout(7, 1, 10, 10));
	JPanel centerPanelUpdateProd = new JPanel();
	JPanel updateFrm = new JPanel(new GridLayout(7, 1, 10, 10));

	// JLabel
	JLabel logoe = new JLabel ("page etudiant");
	JLabel logo = new JLabel (btnIcon);
	
	
	// JTextField
	JTextField txtSearch = new JTextField(15);
	JTextField txtTitle = new JTextField(25);
	JTextField txtAuthor = new JTextField(25);
	JTextField txtUrl = new JTextField(25);
	JTextField txtTitleUpdate = new JTextField(25);
	JTextField txtAuthorUpdate = new JTextField(25);
	JTextField txtUrlUpdate = new JTextField(25);
	
	// JButton
	JButton home = new JButton(" Home ");
	JButton openPdf = new JButton(" Ouvrir PDF ");
	JButton information = new JButton(" Ouvrir PDF ");
	JButton borrowing = new JButton(" Emprunt ");
	JButton logout = new JButton(" Se connecter ");
	JButton btnSearch = new JButton("Recherche");
	
	
	// JComboBox
	JComboBox<String> combo = new JComboBox<String>(new String[] {" Title", " Author"});
	
	// JTable
	IBook action = new BookImplements();
	TableModele tm = new TableModele();
	JTable tab = new JTable(tm);
	JScrollPane jsp = new JScrollPane(tab);

	public interfaceProjet_etudiant() {
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
		
		
		
		
			
		
		
		updateFrm.setBackground(new Color(23, 43, 77));
		updateFrm.setBorder(new EmptyBorder(15, 15, 15,15));
		centerPanelUpdateProd.add(updateFrm);
		
		centerPanelUpdateProd.setBorder(new EmptyBorder(100, 15, 15,15));
		centerPanelUpdateProd.setBackground(new Color(23, 43, 77));
		
		
		
		// this Panel
		this.add(panelSearch, BorderLayout.NORTH);
		this.add(leftPanel, BorderLayout.WEST);
		this.add(centerPanel, BorderLayout.CENTER);
		
		
		
		
		logout.addActionListener(e -> {
			
			this.dispose();
			new Connexion();
		});
		
		borrowing.addActionListener(e -> {
			if (tab.getSelectedRow() == -1)
				JOptionPane.showMessageDialog(this, "Select an item");
			else {
				int id=(int) tab.getValueAt(tab.getSelectedRow(), 0);
				String Title = (String) tab.getValueAt(tab.getSelectedRow(), 1);
				String Author = (String) tab.getValueAt(tab.getSelectedRow(), 2);
				String Url = (String) tab.getValueAt(tab.getSelectedRow(), 3);
				Connection cx = SingletonConnection.getInstance();
				try {
					PreparedStatement st = cx.prepareStatement("insert into emprunte(id,id_b,title, author, url) values(null,?, ?, ?,?)");
					st.setInt(1,id);
					st.setString(2,Title);
					st.setString(3,Author);
					st.setString(4,Url);
					st.executeUpdate();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}}
			
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
		
		
		
		home.addActionListener(e -> {
			allVisibleFalse();
			centerPanel.setVisible(true);
			this.add(centerPanel, BorderLayout.CENTER);
			this.setTitle("Home");
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
	            if (me.getClickCount() == 2) {
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
		this.setTitle("Home");	
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
		new interfaceProjet_etudiant();
	}



}
