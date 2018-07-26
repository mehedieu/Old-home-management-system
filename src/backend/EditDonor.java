
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
 
public class EditDonor 
{
	private JPanel contentPane; 
        private JFrame frame;
	private JTextField txtUser;
        private JTextField txtfirstname;
        private JTextField txtlastname;
        private JTextField intphone;
        private JTextField txtemail;
        private JTextField txtamount;
	private JButton btnSignup;
	private JPasswordField Password;
	protected java.lang.String Spassword;
	PreparedStatement pst=null;
        Connection connection=null;
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/mynewdatabase";
	
	static final String USER = "root";
	static final String PASS = "burirhat124876";
	protected static final String String = null;
	
	
	public EditDonor()
        {
		frame = new JFrame("New Donor Account");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100,100,500,370);
		contentPane = new JPanel();
                contentPane.setBackground(Color.CYAN);
                contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(null);
                frame.setContentPane(contentPane);
		
                txtfirstname = new JTextField();
		txtfirstname.setBounds(188, 40, 99, 20);
		contentPane.add(txtfirstname);
		txtfirstname.setColumns(10);
		
	
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setBounds(70, 40, 86, 14);
		contentPane.add(lblFirstName);
                
                txtlastname = new JTextField();
		txtlastname.setBounds(188, 75, 99, 20);
		contentPane.add(txtlastname);
		txtlastname.setColumns(10);
		
	
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setBounds(70,75, 86, 14);
		contentPane.add(lblLastName);
                
                intphone = new JTextField();
		intphone.setBounds(188, 105, 99, 20);
		contentPane.add(intphone);
		intphone.setColumns(10);
		
	
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(70, 105, 86, 14);
		contentPane.add(lblPhone);
                
                txtemail = new JTextField();
		txtemail.setBounds(188, 140, 99, 20);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
	
		JLabel lblEmail = new JLabel("Email Id");
		lblEmail.setBounds(70, 140, 86, 14);
		contentPane.add(lblEmail);
                
                txtamount = new JTextField();
		txtamount.setBounds(188, 175, 99, 20);
		contentPane.add(txtamount);
		txtamount.setColumns(10);
		
	
		JLabel lblAmount = new JLabel("Donate amount");
		lblAmount.setBounds(70, 175, 86, 14);
		contentPane.add(lblAmount);
            
                
		txtUser = new JTextField();
		txtUser.setBounds(188, 205, 99, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
	
		JLabel lblUserName = new JLabel("User name");
		lblUserName.setBounds(70, 205, 86, 14);
		contentPane.add(lblUserName);
                
                
		Password = new JPasswordField();
		Password.setBounds(188, 240, 99, 20);
		contentPane.add(Password);
		Password.setColumns(10);
                
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(70, 240, 86, 14);
		contentPane.add(lblPassword);

		btnSignup = new JButton("Update");
		btnSignup.addActionListener(new ActionListener() 
                {
                    
                        public void actionPerformed(ActionEvent e) 
                                {				
			 try {
                                       
                                        connection = DriverManager.getConnection(DB_URL, USER, PASS);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
                                    }
					System.out.println("Connected database successfully...");
					  
                          String sql = "UPDATE donor set first_name = ?,last_name = ?,phone_no =?,email = ?,donate_amount = ?,password = ? WHERE username  = ? ";
                            
                            
                            
                            try {
                                pst=(PreparedStatement) connection.prepareStatement(sql);
                              
                                pst.setString(1,txtfirstname.getText());
                                pst.setString(2,txtlastname.getText());
                                pst.setString(3,intphone.getText());
                                pst.setString(4,txtemail.getText());
                                pst.setString(5,txtamount.getText());
                                pst.setString(6,Password.getText());
                                pst.setString(7, txtUser.getText());
                               
                               
                                int rs=pst.executeUpdate();
                                
                                if(rs>0){
                                  
                                   JOptionPane.showMessageDialog(null, "Update as a Donor Successfully :)");
                                 
                                }
                                else {
                                    JOptionPane.showMessageDialog(null,"Update info Unsuccessful");
                                }
                            }
                        
                            catch(Exception ex){
                                JOptionPane.showMessageDialog(null, ex);
                            }
                            
			}
		    
		});
		
		btnSignup.setBounds(131,280, 89, 23);
		contentPane.add(btnSignup);
                MemberbackgroundPanel panel = new MemberbackgroundPanel();
                contentPane.add(panel);
		frame.setVisible(true);
		
                
		}

          
}






