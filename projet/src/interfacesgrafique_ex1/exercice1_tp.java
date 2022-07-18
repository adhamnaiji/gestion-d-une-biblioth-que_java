package interfacesgrafique_ex1;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*; 
import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class exercice1_tp extends JFrame   {
	JLabel l1, l2, l3, l4, l5, l6, l7, l8;  
	 JTextField tfnom, tfprenom, tfmail, tfadresse, tftel;  
	 JButton btn1, btn2,btn3;  
	 JPasswordField p1, p2;   
	 JLabel lblOr = new JLabel(" Or ");
	 
	 
	 
	 
	 
	public exercice1_tp() {
		   
		 
			JLabel lblImg = new JLabel(new ImageIcon("C:\\Users\\GuezGuez\\eclipse-workspace2\\bookLibrary\\src\\src\\img\\login.png"));

	  
	        setTitle("Registration Admin");  
	        l1 = new JLabel("Registration");  
	        l1.setForeground(new Color(94, 114, 228));
	        l1.setFont(l1.getFont().deriveFont(64.0f));
	        l1.setBounds(200, 50, 450, 80);
	        
	        l2 = new JLabel("Nom : "); 
	        l2.setBounds(130, 170, 200, 30);
	        l2.setForeground(new Color(94, 114, 228));
	        
	        l3 = new JLabel("Prenom :");  
	        l3.setBounds(130, 210, 200, 30);
	        l3.setForeground(new Color(94, 114, 228));
	        
	        l4 = new JLabel("Mot de passe :");
	        l4.setBounds(130, 250, 200, 30);
	        l4.setForeground(new Color(94, 114, 228));
	        
	        l5 = new JLabel("Confirmer Mot de passe :");  
	        l5.setBounds(130, 290, 200, 30);
	        l5.setForeground(new Color(94, 114, 228));
	        
	        l6 = new JLabel("Mail :");  
	        l6.setBounds(130, 330, 200, 30);
	        l6.setForeground(new Color(94, 114, 228));
	        
	        l7 = new JLabel("Adresse :"); 
	        l7.setBounds(130, 370, 200, 30); 
	        l7.setForeground(new Color(94, 114, 228));
	        
	        l8 = new JLabel("Phone :"); 
	        l8.setBounds(130, 410, 200, 30);
	        l8.setForeground(new Color(94, 114, 228));
	        
	        tfnom = new JTextField();
	        tfnom.setBounds(350, 170, 300, 30);
	        
	        
	        tfprenom = new JTextField();  
	        tfprenom.setBounds(350, 210, 300, 30); 
	        
	        p1 = new JPasswordField();  
	        p1.setBounds(350, 250, 300, 30);
	        
	        p2 = new JPasswordField(); 
	        p2.setBounds(350, 290, 300, 30);
	        
	        tfmail = new JTextField();  
	        tfmail.setBounds(350, 330, 300, 30); 
	        
	        tfadresse = new JTextField(); 
	        tfadresse.setBounds(350, 370, 300, 30); 
	        
	        tftel = new JTextField();
	        tftel.setBounds(350, 410, 300, 30); 
	        
	        btn1 = new JButton("Envoyer"); 
	        btn1.setBounds(255, 470, 100, 30); 
	        btn1.setBackground(new Color(94, 114, 228));
	        btn1.setForeground(new Color(244, 245, 247));
	        
	        btn2 = new JButton("Annuler"); 
	        btn2.setBounds(165, 350, 100, 30);
	        
	        lblOr.setForeground(new Color(255, 255, 255));
	        lblOr.setBounds(370, 470, 50, 30); 
	        
	        btn3=new JButton("Login");
	        btn3.setBounds(405, 470, 100, 30);  
	        

	        
	        
	        
	        
	        
	        
	        add(l1);  
	        add(l2);  
	        add(tfnom);  
	        add(l3);  
	        add(tfprenom);  
	        add(l4);  
	        add(p1);  
	        add(l5);  
	        add(p2);  
	        add(l6);  
	        add(tfmail);  
	        add(l7);  
	        add(tfadresse);  
	        add(l8);  
	        add(tftel);  
	        add(btn1);  
	        add(lblOr);
	        add(btn3);
	        
	        add(btn2);
	        
	         this.setLocationRelativeTo(null);
		
        btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
             registeradherent();				
			}
        });
        
        btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			dispose();
				
			}
        });
        btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Connexion();
				dispose();
			}
        	
        });;
        
        setVisible(true);
        this.setSize(800,600);  
        setLayout(null);  
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(23, 43, 77));	}


protected void registeradherent() {
      String nom = tfnom.getText();
      String prenom = tfprenom.getText();
      String mot_de_passe = p1.getText();
      String confirm_mot_de_passe = p2.getText();
      String mail = tfmail.getText();
      String adresse = tfadresse.getText();
      String phone = tftel.getText();
      if (nom.isEmpty() || prenom.isEmpty() || mail.isEmpty()
    		  || mot_de_passe.isEmpty() || confirm_mot_de_passe.isEmpty()
    		  || adresse.isEmpty() || phone.isEmpty())
         {
    	  JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs",
    			  "Essai encore", JOptionPane.ERROR_MESSAGE); 
    	  return;
         }
      
      if(!mot_de_passe.equals(confirm_mot_de_passe)) 
         {
    	  JOptionPane.showMessageDialog(this, "Confirmer mot de passe",
    			  "Essai encore",JOptionPane.ERROR_MESSAGE);
    	  return;
         }
      adherent = addAdherent(nom,prenom,mot_de_passe,confirm_mot_de_passe,mail,adresse,phone);
      if(adherent != null)
      {
    	  dispose();
      }
      else 
      {
    	JOptionPane.showMessageDialog(this, "Erreur d'inscription",
    			"Essai encore", JOptionPane.ERROR_MESSAGE);  
      }
}

public Adherent adherent;
private Adherent addAdherent( String nom,String prenom, String mot_de_passe,String confirm_mot_de_passe,String mail, String adresse, String phone) 
       {
	    Adherent adherent = null;
	    final String DB_url ="jdbc:mysql://localhost/booklibrary";
	    final String username = "root";
	    final String password = "";
	    
	    try {
	    	Connection conn = DriverManager.getConnection(DB_url,username,password); 
	    	Statement st = conn.createStatement();
	    	String req1 = "insert into adherent (id,nom,prenom,mot_de_passe,confirm_mot_de_passe,mail,adresse,phone)"+
	    	               "values (NULL,?,?,?,?,?,?,?)";
	    	PreparedStatement preparedStatement = conn.prepareStatement(req1);
	    	preparedStatement.setString(1, nom);
	    	preparedStatement.setString(2, prenom);
	    	preparedStatement.setString(3, mot_de_passe);
	    	preparedStatement.setString(4, confirm_mot_de_passe);
	    	preparedStatement.setString(5, mail);
	    	preparedStatement.setString(6, adresse);
	    	preparedStatement.setString(7, phone);
	    	
	    	int addadh = preparedStatement.executeUpdate();
	    	if(addadh >0) 
	    	 {
	    	  adherent = new Adherent();
	    	  adherent.nom = nom;
	    	  adherent.prenom = prenom;
	    	  adherent.mot_de_passe = mot_de_passe;
	    	  adherent.confirm_mot_de_passe = confirm_mot_de_passe;
	    	  adherent.mail = mail;
	    	  adherent.adresse = adresse;
	    	  adherent.phone = phone;
	    	 }
	    	
	    	st.close();
	    	conn.close();
	    	new Connexion();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    return adherent;
       }


public static void main(String[] args) {
	
	exercice1_tp form= new exercice1_tp();
	Adherent adherent = form.adherent;
	if (adherent != null)
	{ 
		System.out.println("Bienvenue   "+adherent.nom);
		
	}
	else {
		System.out.println("Inscription Annuler");
	}
}
}
