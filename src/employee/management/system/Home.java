/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author sasac
 */
public class Home extends JFrame implements ActionListener{

    JButton add,remove,update,view;
    public Home() {
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("img/Home.jpg"));
        Image i2=i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,1120,630);
        add(img);
       
        JLabel heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(300,20,500,40);
        heading.setFont(new Font("serif", Font.BOLD,25));
        img.add(heading);
        
        add=new JButton("Add Employee");
        add.setBounds(350,100,150,40);
        img.add(add);
        add.addActionListener(this);
        
        view=new JButton("View Employees");
        view.setBounds(550,100,150,40);
        img.add(view);
        view.addActionListener(this);
        
        update=new JButton("Update Employee");
        update.setBounds(350,220,150,40);
        img.add(update);
        update.addActionListener(this);
        
        remove=new JButton("Remove Employee");
        remove.setBounds(550,220,150,40);
        img.add(remove);
        remove.addActionListener(this);
        
        setSize(1120, 630);
        setLocation(500,150);
        setVisible(true);
        
        
        
    }
    public static void main(String[] args) {
        new Home();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        if(e.getSource()==add){
            setVisible(false);
            new AddEmployee();
        }else if(e.getSource()==view){
            setVisible(false);
            new ViewEmployees();
        }else if(e.getSource()==update){
            setVisible(false);
            new ViewEmployees();
        }else if(e.getSource()==remove){
            setVisible(false);
            new RemoveEmployee();
        }
        
    
    }
    
}
