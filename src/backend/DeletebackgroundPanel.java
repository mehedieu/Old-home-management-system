/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backend;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class DeletebackgroundPanel extends JPanel {

    Image image;

    public DeletebackgroundPanel() {
        try {
            image = ImageIO.read(getClass().getResource("/resources/images/image4.jpg"));
            java.awt.Dimension size = new Dimension(image.getWidth(null), image.getHeight(null));
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(size);
            setLayout(null);
        } catch (Exception e) { 
            System.out.println(e);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image,0,0,this.getWidth(),this.getHeight(),this);
        }
    }
}
