/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
    
JTextField tfusername=new JTextField();
JTextField tfpassword=new JTextField();
    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        setSize(600, 300);
        setLocation(500,150);
        setVisible(true);
        
        
        JLabel lblUserName=new JLabel("Username");
        lblUserName.setBounds(40, 20, 100, 30);
        add(lblUserName);
        
        
        tfusername.setBounds(150, 20, 150, 30);
        add(tfusername);
        
        JLabel lblPassword=new JLabel("Password");
        lblPassword.setBounds(40, 70, 100, 30);
        add(lblPassword);
        
        
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);
        
        JButton login=new JButton("Login");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);
        
        login.addActionListener(this);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("img/second.jpg"));
        Image i2=img.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
       
        add(image);
        
        
    }

    
    public static void main(String[] args) {
      new Login();  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     
        try {
            String username=tfusername.getText();
            String password=tfpassword.getText();
            Connect c=new Connect();
            String query="select *from login where username= '"+username+"' and password= '"+password+"'";
            ResultSet rs = c.s.executeQuery(query);
            
            if(rs.next()){
                setVisible(false);
                new Home();
            }else
            {
                JOptionPane.showMessageDialog(null, "Invalid UserName or Password !");
             
                setVisible(false);}
            
        } catch (Exception ae) {
            ae.printStackTrace();
        }
        
    
    }


    
}
