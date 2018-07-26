
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
 
public class DeleteDonor 
{
	private JPanel contentPane; 
        private JFrame frame;
	private JTextField txtUser;
	private JButton btnSignup;
	private JPasswordField Password;
	protected java.lang.String Spassword;
	Connection connection=null;
        PreparedStatement pst = null;
	
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/mynewdatabase";
	

	static final String USER = "root";
	static final String PASS = "burirhat124876";
	protected static final String String = null;
	
	
	public DeleteDonor()
        {
		frame = new JFrame("Cancel Donor Account");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
                contentPane.setBackground(Color.CYAN);
                contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(null);
                frame.setContentPane(contentPane);
		
		txtUser = new JTextField();
		txtUser.setBounds(188, 51, 99, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
	
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(70, 54, 86, 14);
		contentPane.add(lblUserName);
                
                
		Password = new JPasswordField();
		Password.setBounds(188, 106, 99, 20);
		contentPane.add(Password);
		Password.setColumns(10);
                
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(70, 109, 86, 14);
		contentPane.add(lblPassword);

		btnSignup = new JButton("Cancel Donorship");
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
					  
		        	
                                 String sql = "DELETE from  donor WHERE username  = ? AND password = ?";
                            
                      
                            try {
                                   
                                pst=(PreparedStatement) connection.prepareStatement(sql);
                              
                               pst.setString(1, txtUser.getText());
                               pst.setString(2, Password.getText());
                               pst.execute();
                                   
                                   JOptionPane.showMessageDialog(null, "Delete Donorship Successfully :)");
                                   
                               }
                                          
                            catch (SQLException ex) {
                                        JOptionPane.showMessageDialog(null," "+ex.getMessage(),"Delete Donorship Unsuccessful",JOptionPane.ERROR_MESSAGE);
                                   
                            }
								
                                }
		});
		
		btnSignup.setBounds(131, 165, 150, 23);
		contentPane.add(btnSignup);
                DeletebackgroundPanel panel = new DeletebackgroundPanel();
                contentPane.add(panel);
		frame.setVisible(true);
		
                
		}

                  
}






