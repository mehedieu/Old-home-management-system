/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class EditMember {
	private JPanel contentPane;
	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JLabel lblPassword;
	private JButton btnNewButton;
        private JTextField txtfirstname;
        private JTextField txtlastname;
        private JTextField intphone;
        private JTextField txtemail;
        
        
        
        PreparedStatement pst=null;
        Connection connection=null;
	static final String DB_URL = "jdbc:mysql://localhost:3306/mynewdatabase";
	
	
	static final String USER = "root";
	static final String PASS = "burirhat124876";
	
	/**
	 * Create the frame.
	 */
	public EditMember() {
		frame = new JFrame("Update Membership Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 370);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setForeground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		frame.setContentPane(contentPane);
		
                 txtfirstname = new JTextField();
		txtfirstname.setBounds(188, 50, 99, 20);
		contentPane.add(txtfirstname);
		txtfirstname.setColumns(10);
		
	
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setBounds(70, 50, 86, 14);
		contentPane.add(lblFirstName);
                
                txtlastname = new JTextField();
		txtlastname.setBounds(188, 90, 99, 20);
		contentPane.add(txtlastname);
		txtlastname.setColumns(10);
		
	
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setBounds(70,90, 86, 14);
		contentPane.add(lblLastName);
                
                intphone = new JTextField();
		intphone.setBounds(188, 130, 99, 20);
		contentPane.add(intphone);
		intphone.setColumns(10);
		
	
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(70, 130, 86, 14);
		contentPane.add(lblPhone);
                
                txtemail = new JTextField();
		txtemail.setBounds(188, 170, 99, 20);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
	
		JLabel lblEmail = new JLabel("Email Id");
		lblEmail.setBounds(70, 170, 86, 14);
		contentPane.add(lblEmail);
                
                
		usernameField = new JTextField();
		usernameField.setBounds(188, 210, 99, 20);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(188, 250, 99, 20);
		contentPane.add(passwordField);
		
		lblNewLabel = new JLabel("username");
		lblNewLabel.setBounds(70, 210, 86,14);
		contentPane.add(lblNewLabel);
		
		lblPassword = new JLabel("password");
		lblPassword.setBounds(70, 250, 86, 14);
		contentPane.add(lblPassword);
		
               
                
		btnNewButton = new JButton(" Update ");
		btnNewButton.addActionListener(new ActionListener() {
                          
			public void actionPerformed(ActionEvent arg0) {
                                    
                        
                
                       try {
                                       
                                        connection = DriverManager.getConnection(DB_URL, USER, PASS);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
                                    }
					System.out.println("Connected database successfully...");
					  
                          String sql = "UPDATE member set first_name = ?,last_name = ?,phone_no =?,email = ?,password = ? WHERE username  = ? ";
                            
                            
                            
                            try {
                                pst=(PreparedStatement) connection.prepareStatement(sql);
                              
                                pst.setString(1,txtfirstname.getText());
                                pst.setString(2,txtlastname.getText());
                                pst.setString(3, intphone.getText());
                                pst.setString(4,txtemail.getText());
                                pst.setString(5, passwordField.getText());
                                pst.setString(6, usernameField.getText());
                               
                               
                                int rs=pst.executeUpdate();
                                
                                if(rs>0){
                                  
                                   JOptionPane.showMessageDialog(null, "Update as a Member Successfully :)");
                                 
                                }
                                else {
                                    JOptionPane.showMessageDialog(null,"Update info Unsuccessful");
                                }
                            }
                        
                            catch(Exception e){
                                JOptionPane.showMessageDialog(null, e);
                            }
                            
			}
		});
		btnNewButton.setBounds(131, 290, 89, 23);
		contentPane.add(btnNewButton);
                MemberbackgroundPanel panel = new MemberbackgroundPanel();
                contentPane.add(panel);
		frame.setVisible(true);
	
		
	}

    
        
        
}
