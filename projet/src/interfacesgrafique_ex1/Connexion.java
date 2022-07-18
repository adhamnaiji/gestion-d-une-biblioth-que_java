package interfacesgrafique_ex1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*; 
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import presentation.InterfaceProject;
import presentation.interfaceProjet_etudiant;
public class Connexion extends JFrame  {
	JLabel l1, l2, l3;  
	 JTextField tfmail;  
	 JButton btn1, btn2;  
	 JPasswordField p1, p2;
	 
	 
	 
	 
	 JPanel leftPanel = new JPanel(new GridLayout(1, 1));
		JPanel rightPanel = new JPanel(new GridLayout(3, 1));
		JPanel loginFrm = new JPanel(new GridLayout(4, 1, 10, 10));
		JPanel btnPanel = new JPanel();

		// Label
		JLabel lblImg = new JLabel(new ImageIcon("C:\\\\Users\\\\adham\\\\Desktop\\\\Projet_java\\\\projet\\\\src\\\\imgs\\login.png"));
		JLabel lblSignin = new JLabel("Sign in", SwingConstants.CENTER);
		JLabel lblUsername = new JLabel("Username : ");
		JLabel lblPassword = new JLabel("Password : ");
		JLabel lblOr = new JLabel(" Or ");
		JLabel lblOrr = new JLabel(" Or ");

		// TextField & PasswordField
		JTextField txtUsername = new JTextField(10);
		JPasswordField txtPassword = new JPasswordField(10);
		
		
		JButton btnLogin = new JButton("Login");
		JButton btnRegister = new JButton("Register");
		JButton btnRegisteret = new JButton("Register user");
	 
	 public Connexion () {
		// Left Panel
			leftPanel.add(lblImg);
			leftPanel.setBackground(new Color(23, 43, 77));
			
			// right Panel
			lblSignin.setForeground(new Color(94, 114, 228));
			lblSignin.setFont(lblSignin.getFont().deriveFont(64.0f));
			rightPanel.add(lblSignin);
			
			// login form
			lblUsername.setForeground(new Color(94, 114, 228));
			loginFrm.add(lblUsername);
			txtUsername.setHorizontalAlignment(JTextField.CENTER);
			txtUsername.setBorder(BorderFactory.createLineBorder(new Color(94, 114, 228), 1));
			loginFrm.add(txtUsername);
			lblPassword.setForeground(new Color(94, 114, 228));
			loginFrm.add(lblPassword);
			txtPassword.setHorizontalAlignment(JTextField.CENTER);
			txtPassword.setBorder(BorderFactory.createLineBorder(new Color(94, 114, 228), 1));
			loginFrm.add(txtPassword);
			loginFrm.setBackground(new Color(23, 43, 77));
			loginFrm.setBorder(new EmptyBorder(15, 15, 15,15));
			rightPanel.add(loginFrm);
			rightPanel.setBackground(new Color(23, 43, 77));
			
			// login button
			btnLogin.setFocusPainted(false);
			btnLogin.setBackground(new Color(94, 114, 228));
			btnLogin.setForeground(new Color(244, 245, 247));
			btnPanel.add(btnLogin);
			lblOr.setForeground(new Color(255, 255, 255));
			btnPanel.add(lblOr);
			btnRegister.setFocusPainted(false);
			btnRegister.setBackground(new Color(23, 43, 77));
			btnRegister.setForeground(new Color(244, 245, 247));
			
			
			
			btnRegisteret.setFocusPainted(false);
			btnRegisteret.setBackground(new Color(23, 43, 77));
			btnRegisteret.setForeground(new Color(244, 245, 247));
			
			btnPanel.add(btnRegister);
			lblOrr.setForeground(new Color(255, 255, 255));
			btnPanel.add(lblOrr);
			btnPanel.add(btnRegisteret);
			btnPanel.setBackground(new Color(23, 43, 77));
			btnPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
			rightPanel.add(btnPanel);
			
			// add panels to form
			this.add(leftPanel, BorderLayout.WEST);
			this.add(rightPanel, BorderLayout.CENTER);
			this.setLocationRelativeTo(null);
			this.pack();
			
	        
	        
	        
	        btnLogin.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
                String mail = txtUsername.getText();
                String mot_de_passe = txtPassword.getText();
                
                adherent=getAuthenticatedAdherent(mail,mot_de_passe);
                etudiant=getAuthenticatedetudiant(mail,mot_de_passe);
                
                if (adherent != null)
                {
                	
                	new InterfaceProject();
                	 setVisible(false);
                
                	
                }
                else if(etudiant!=null) {
                	new interfaceProjet_etudiant();
                	setVisible(false);
                }
                else {
                	JOptionPane.showMessageDialog(Connexion.this, "Mail or mot de passe incorrect",
                			"Essaie",JOptionPane.ERROR_MESSAGE);
                }
				}

	        });
	        
	        btnRegister.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new exercice1_tp();
					setVisible(false);
				}
	        	
	        });
	        
	        btnRegisteret.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new exercice1_tp_etudiant();
					setVisible(false);
				}
	        	
	        });
	        setVisible(true);
	     }
	 
    public Adherent adherent;
    public Adherent etudiant;
	 
	private Adherent getAuthenticatedAdherent(String mail, String mot_de_passe) {
        Adherent adherent = null;
        
        final String DB_url ="jdbc:mysql://localhost/booklibrary";
	    final String username = "root";
	    final String password = "";
	    try {
	    	Connection conn = DriverManager.getConnection(DB_url,username,password); 
	    	Statement st = conn.createStatement();
	    	String req2 = "select * from adherent where mail=? and mot_de_passe=?";
	    	PreparedStatement preparedStatement = conn.prepareStatement(req2);
	    	preparedStatement.setString(1, mail);
	    	preparedStatement.setString(2, mot_de_passe);
	    	
	    	ResultSet resultSet = preparedStatement.executeQuery();
	    	if(resultSet.next()) {
	    		adherent = new Adherent();
	    		adherent.nom = resultSet.getString("nom");
	    		adherent.mail = resultSet.getString("mail");
	    		adherent.mot_de_passe = resultSet.getString("mot_de_passe");

	    	}
	    	st.close();
	    	conn.close();
	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
		return adherent;
		
	}
	
	
	
	private Adherent getAuthenticatedetudiant(String mail, String mot_de_passe) {
        Adherent etudiant = null;
        
        final String DB_url ="jdbc:mysql://localhost/booklibrary";
	    final String username = "root";
	    final String password = "";
	    try {
	    	Connection conn = DriverManager.getConnection(DB_url,username,password); 
	    	Statement st = conn.createStatement();
	    	String req2 = "select * from etudiant where mail=? and mot_de_passe=?";
	    	PreparedStatement preparedStatement = conn.prepareStatement(req2);
	    	preparedStatement.setString(1, mail);
	    	preparedStatement.setString(2, mot_de_passe);
	    	
	    	ResultSet resultSet = preparedStatement.executeQuery();
	    	if(resultSet.next()) {
	    		etudiant = new Adherent();
	    		etudiant .nom = resultSet.getString("nom");
	    		etudiant .mail = resultSet.getString("mail");
	    		etudiant .mot_de_passe = resultSet.getString("mot_de_passe");

	    	}
	    	st.close();
	    	conn.close();
	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
		return etudiant ;
		
	}


	public static void main(String[] args) 
	{
		Connexion connexion=new Connexion();
		Adherent adherent = connexion.adherent;
		
	}

}
