package gui;

import backend.HomebackgroundPanel;
import backend.DeleteDonor;
import backend.DeleteMember;
import backend.Donor;
import backend.EditDonor;
import backend.EditMember;
import backend.Feature;
import backend.Member;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				HomePage frame= new HomePage();
                                         frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
   
  
    

	public HomePage() {
              
                setTitle("Welcome to Old Home :)Connecting.....to  the Heaven!!!");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,550,530);
                
                HomebackgroundPanel panel = new HomebackgroundPanel();
            
                contentPane = new JPanel();
                contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
         	contentPane.setLayout(null);
		setContentPane(contentPane);
                
                
                
                JButton featurebutton = new JButton("Features At A Glance");
                featurebutton.setBackground(Color.CYAN);
                featurebutton.setBounds(140,30,180,23);
		contentPane.add(featurebutton);
		featurebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                          new Feature();  
                          setVisible(false);
			
			}
		});
                
                
                
                
             
                JButton registerbuttonMember = new JButton("Register as a Member ?");
                registerbuttonMember.setBackground(Color.CYAN);
		registerbuttonMember.setBounds(140,70,180,23);
		contentPane.add(registerbuttonMember);
		registerbuttonMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 new Member();
                          setVisible(false);
			
			}
		});
		
		JButton registerbuttonDonor = new JButton("Register as a Donor ?");
                registerbuttonDonor.setBackground(Color.CYAN);
		registerbuttonDonor.setBounds(140,110,180,23);
		contentPane.add(registerbuttonDonor);
		registerbuttonDonor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  new Donor();
                          setVisible(false);
			
			}
		});
		
                JButton cancelbuttonMember = new JButton("Cancel Membership ?");
                cancelbuttonMember.setBackground(Color.CYAN);
	        cancelbuttonMember.setBounds(140,150,180,23);
		contentPane.add(cancelbuttonMember);
		cancelbuttonMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  new DeleteMember();
                          setVisible(false);
			
			}
		});
		
                JButton cancelbuttonDonor = new JButton("Cancel Donorship ?");
                cancelbuttonDonor.setBackground(Color.CYAN);
		cancelbuttonDonor.setBounds(140,190,180,23);
		contentPane.add(cancelbuttonDonor);
		cancelbuttonDonor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  new DeleteDonor();
                          setVisible(false);
			
			}
		});
		
                 JButton editbuttonMember = new JButton("Update Memebership ?");
                editbuttonMember.setBackground(Color.CYAN);
		editbuttonMember.setBounds(140,230,180,23);
		contentPane.add(editbuttonMember);
		editbuttonMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  new EditMember();
                          setVisible(false);
			
			}
		});
		
                 JButton editbuttonDonor = new JButton("Update Donorship ?");
                editbuttonDonor.setBackground(Color.CYAN);
		editbuttonDonor.setBounds(140,270,180,23);
		contentPane.add(editbuttonDonor);
		editbuttonDonor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  new EditDonor();
                          setVisible(false);
			
			}
		});
		
                
                
                
                 
		JButton loginbuttonMember = new JButton("Member Login");
		loginbuttonMember.setBackground(Color.CYAN);
		loginbuttonMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			new MemberLogIn();
			setVisible(false);
			}
		});
		loginbuttonMember.setBounds(95, 310, 120, 23);
		contentPane.add(loginbuttonMember);
                
                JButton loginbuttonDonor = new JButton("Donor Login");
		loginbuttonDonor.setBackground(Color.CYAN);
		loginbuttonDonor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			new DonorLogIn();
			setVisible(false);
			}
		});
		loginbuttonDonor.setBounds(280, 310, 120, 23);
		contentPane.add(loginbuttonDonor);
                contentPane.add(panel);
                
		
	}

    
   
}
