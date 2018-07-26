/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author User
 */
public class Feature {
    
        private JPanel contentPane;
	private JFrame frame;
    
    public Feature(){
                frame = new JFrame("Featurre Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100,800,450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setForeground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		frame.setContentPane(contentPane);
                FeaturebackgroundPanel panel = new FeaturebackgroundPanel();
                contentPane.add(panel);
		frame.setVisible(true);
	
    }
    
    
}
