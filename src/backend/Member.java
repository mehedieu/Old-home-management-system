
package backend;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
 
public class Member  
{
	private JPanel contentPane; 
        private JFrame frame;
	private JTextField txtUser;
        private JTextField txtfirstname;
        private JTextField txtlastname;
        private JTextField intphone;
        private JTextField txtemail;
	private JButton btnSignup;
	private JPasswordField Password;
	protected java.lang.String Spassword;
	
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/mynewdatabase";
	
	static final String USER = "root";
	static final String PASS = "burirhat124876";
	protected static final String String = null;
	
	
	public Member()
        {
		frame = new JFrame("New Member Account");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100,100,500,370);
		contentPane = new JPanel();
                contentPane.setBackground(Color.CYAN);
                contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
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
                
                
                
                
		txtUser = new JTextField();
		txtUser.setBounds(188, 210, 99, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
	
		JLabel lblUserName = new JLabel("User name");
		lblUserName.setBounds(70, 210, 86, 14);
		contentPane.add(lblUserName);
                
                
		Password = new JPasswordField();
		Password.setBounds(188, 250, 99, 20);
		contentPane.add(Password);
		Password.setColumns(10);
                
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(70, 250, 86, 14);
		contentPane.add(lblPassword);

		btnSignup = new JButton("Sign Up");
		btnSignup.addActionListener(new ActionListener() 
                {
                    
                        public void actionPerformed(ActionEvent e) 
                                {				
			
		        	Connection conn = null;
                             String first_name = txtfirstname.getText();
                             String last_name = txtlastname.getText();
			     String phone = intphone.getText();
                             String email = txtemail.getText();
		             String   username = txtUser.getText();
			     String   password = Password.getText();
				
				if (username.equals("")|| password.equals(""))
				{
					JOptionPane.showMessageDialog(null," name or password or Role is wrong","Error",JOptionPane.ERROR_MESSAGE);
				}
				else  
                                {
				        String IQuery = "INSERT INTO member VALUES('"+first_name+"','"+last_name+"','"+phone+"','"+email+"','"+username+"','"+password+"');";
					System.out.println(IQuery);
					System.out.println("Connecting to a selected database...");
				
                                    try {
                                        
                                        conn = DriverManager.getConnection(DB_URL,USER,PASS);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
                                    }
					System.out.println("Connected database successfully...");
					  
                                    try {
                                        ((Connection)conn).createStatement().execute(IQuery);
                                        
                                    } catch (SQLException ex) {
                                        Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
                                    } 
				
					String SMessage = "Record added for "+username;
					
                                     
	                            JOptionPane.showMessageDialog(null,"Sign Up Successfully");
                                   try {
                                        
                                        ((java.sql.Connection)conn).close();
                                   } catch (SQLException ex) {
                                        Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
                                   }
				}				
			}
		
		    
		});
		
		btnSignup.setBounds(131, 290, 89, 23);
		contentPane.add(btnSignup);
                MemberbackgroundPanel panel = new MemberbackgroundPanel();
                contentPane.add(panel);
		frame.setVisible(true);
		
                
		}

          
}






