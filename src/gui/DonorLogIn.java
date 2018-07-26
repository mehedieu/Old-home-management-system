
package gui;

import backend.LoginbackgroundPanel;
import backend.Member;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

public class DonorLogIn {
	private JPanel contentPane;
	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JLabel lblPassword;
	private JButton btnNewButton;
        ResultSet rs=null;
        PreparedStatement pst=null;
        Connection connection=null;
	static final String DB_URL = "jdbc:mysql://localhost:3306/mynewdatabase";
	
	static final String USER = "root";
	static final String PASS = "burirhat124876";
	
	
	public DonorLogIn() {
		frame = new JFrame("Donor Log In");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 350, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setForeground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		frame.setContentPane(contentPane);
		
		usernameField = new JTextField();
		usernameField.setBounds(133, 99, 142, 28);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(133, 149, 142, 28);
		contentPane.add(passwordField);
		
		lblNewLabel = new JLabel("username");
		lblNewLabel.setBounds(56, 103, 67, 21);
		contentPane.add(lblNewLabel);
		
		lblPassword = new JLabel("password");
		lblPassword.setBounds(56, 156, 67, 21);
		contentPane.add(lblPassword);
		
               
                
		btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
                          
			public void actionPerformed(ActionEvent arg0) {
                                    
                            String sql= "select * from donor where username=? and password=?";
				
                             try {
                                 connection = DriverManager.getConnection(DB_URL, USER, PASS);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
                                    }
					System.out.println("Connected database successfully...");
					  
                           
                            
                            
                            
                            try {
                                pst=(PreparedStatement) connection.prepareStatement(sql);
                                pst.setString(1, usernameField.getText());
                                pst.setString(2, passwordField.getText());
                                rs=pst.executeQuery();
                                
                                if(rs.next()){
                                    JOptionPane.showMessageDialog(null, "Log in as Donor Successfully :)");
                                }
                                else {
                                    JOptionPane.showMessageDialog(null,"Invalid username amd password!!!");
                                }
                            }
                        
                            catch(Exception e){
                                JOptionPane.showMessageDialog(null, e);
                            }
                            
			}
		});
		btnNewButton.setBounds(175, 204, 89, 23);
		contentPane.add(btnNewButton);
                LoginbackgroundPanel panel = new LoginbackgroundPanel();
                contentPane.add(panel);
		frame.setVisible(true);
	
		
	}

   
}
