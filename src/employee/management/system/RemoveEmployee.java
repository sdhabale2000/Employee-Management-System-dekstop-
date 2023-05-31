/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

import com.mysql.cj.xdevapi.Result;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author sasac
 */
public class RemoveEmployee extends JFrame implements ActionListener {

    Choice cempid;
    JButton delete,back;
    

    public RemoveEmployee() {

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel lremove = new JLabel("REMOVE EMPLOYEE");
        lremove.setFont(new Font("serif", Font.PLAIN, 25));
        lremove.setBounds(150, 0, 350, 30);
        add(lremove);

        JLabel lemployee = new JLabel("Employee Id");
        lemployee.setFont(new Font("serif", Font.PLAIN, 20));
        lemployee.setBounds(50, 50, 150, 30);
        add(lemployee);

        cempid = new Choice();
        cempid.setBounds(200, 50, 150, 30);
        add(cempid);
        try {
            Connect con = new Connect();
            String query = "select *from employee;";
            ResultSet rs = con.s.executeQuery(query);
            while (rs.next()) {

                cempid.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lname = new JLabel("Name");
        lname.setBounds(50, 100, 100, 30);
        add(lname);

        JLabel lblname = new JLabel();
        lblname.setBounds(200, 100, 100, 30);
        add(lblname);

        JLabel lphone = new JLabel("Phone");
        lphone.setBounds(50, 150, 100, 30);
        add(lphone);
        JLabel lblphone = new JLabel();
        lblphone.setBounds(200, 150, 100, 30);
        add(lblphone);

        JLabel lemail = new JLabel("Email");
        lemail.setBounds(50, 200, 100, 30);
        add(lemail);

        JLabel lblemail = new JLabel();
        lblemail.setBounds(200, 200, 200, 30);
        add(lblemail);

        setSize(1000, 400);
        setLocation(300, 150);
        setVisible(true);
        try {

            Connect con = new Connect();
            String id = cempid.getSelectedItem();
            ResultSet rs = con.s.executeQuery("select * from employee where empId = '" + id + "';");
            while (rs.next()) {

                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));

            }
        } catch (Exception e) {

            e.printStackTrace();
        }

        cempid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {

                try {

                    Connect con = new Connect();
                    String id = cempid.getSelectedItem();
                    ResultSet rs = con.s.executeQuery("select * from employee where empId = '" + id + "';");
                    while (rs.next()) {

                        lblname.setText(rs.getString("name"));
                        lblphone.setText(rs.getString("phone"));
                        lblemail.setText(rs.getString("email"));

                    }
                } catch (Exception e) {

                    e.printStackTrace();
                }

            }
        });

        delete=new JButton("Delete");
        delete.setBounds(50,260,150,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        
        
        back=new JButton("Back");
        back.setBounds(250,260,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("img/delete.png"));
         Image i2=i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
         ImageIcon i3 =new ImageIcon(i2);
         JLabel img=new JLabel(i3);
         img.setBounds(350,0,600,400);
         add(img);
        
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()==delete){
            
            try {
                Connect con=new Connect();
                String s="delete from employee where empId ='"+cempid.getSelectedItem()+"'";
                con.s.executeUpdate(s);
                JOptionPane.showMessageDialog(null, "Employee Information Deleted");
                setVisible(false);
                new RemoveEmployee();
            } catch (Exception e) {
            }
            
        }else if(ae.getSource()==back){
            setVisible(false);
            new Home();
    }
    }
}
