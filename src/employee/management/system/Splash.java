/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Splash extends JFrame implements ActionListener{
    
     Splash(){
     
         //Setting-layout
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         
        //heading
         JLabel head=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
         head.setBounds(80, 30, 1200, 60);
         head.setFont(new Font("serif",Font.PLAIN,60));
         add(head);
         head.setForeground(Color.ORANGE);
         
         //adding image
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("img/SplashFront.jpg"));
         Image i2=i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
         ImageIcon i3 =new ImageIcon(i2);
         JLabel img=new JLabel(i3);
         img.setBounds(50,100,1050,500);
         add(img);
         //welcome - msg
         JLabel w=new JLabel("WELCOME");
         w.setBounds(400, 280, 1200, 60);
         w.setFont(new Font("serif",Font.PLAIN,60));
         img.add(w); 
         w.setForeground(Color.GRAY);
        
         // button -to next page
         
         JButton cont=new JButton("CLICK HEAR TO CONTINUE ");
         cont.setBounds(400, 400, 300, 70);
         cont.setForeground(Color.BLACK);
         cont.setBackground(Color.WHITE);
         img.add(cont);
         cont.addActionListener(this);
         
         
         setSize(1170,650);
         setLocation(500,150);
         setVisible(true);
         
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        setVisible(false);
        new Login();

    }
    
    public static void main(String[] args) {
    
         new Splash();
    
    
        }

}
