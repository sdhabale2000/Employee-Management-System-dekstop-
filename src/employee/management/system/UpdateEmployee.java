/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author sasac
 */
public class UpdateEmployee extends JFrame implements ActionListener{
    JButton update,back;
   public JTextField tfeducation,tfaddress,tfsalary,tfphone,tfemail,tfdesignation,tfaadhar;
    JLabel lblempid,lblaadhar;
    String empId;
    public UpdateEmployee(String empId) {

        this.empId=empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("UPDATE EMPLOYEE DETAILS");
        heading.setBounds(100, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel lname = new JLabel("Name");
        lname.setBounds(50, 150, 150, 30);
        lname.setFont(new Font("serif", Font.PLAIN, 20));
        add(lname);

        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        add(lblname);

        JLabel laddress = new JLabel("Address");
        laddress.setBounds(400, 150, 150, 30);
        laddress.setFont(new Font("serif", Font.PLAIN, 20));
        add(laddress);

        tfaddress = new JTextField();
        tfaddress.setBounds(550, 150, 150, 30);
        add(tfaddress);

        JLabel ldate = new JLabel("Date of Birth");
        ldate.setBounds(50, 200, 150, 30);
        ldate.setFont(new Font("serif", Font.PLAIN, 20));
        add(ldate);
        
        JLabel lbldob= new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        add(lbldob);

        JLabel lsalary = new JLabel("Salary");
        lsalary.setBounds(400, 200, 150, 30);
        lsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(lsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(550, 200, 150, 30);
        add(tfsalary);

        JLabel lphone = new JLabel("Phone");
        lphone.setBounds(50, 250, 150, 30);
        lphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(lphone);

        tfphone = new JTextField();
        tfphone.setBounds(200, 250, 150, 30);
        add(tfphone);

        JLabel lemail = new JLabel("Email");
        lemail.setBounds(400, 250, 150, 30);
        lemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(lemail);

        tfemail = new JTextField();
        tfemail.setBounds(550, 250, 150, 30);
        add(tfemail);

        JLabel leducation = new JLabel("Higest Education");
        leducation.setBounds(50, 300, 150, 30);
        leducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(leducation);

        tfeducation = new JTextField();
        tfeducation.setBounds(200, 300, 150, 30);
        add(tfeducation);
        
        JLabel ldesignation = new JLabel("Designation");
        ldesignation.setBounds(400, 300, 150, 30);
        ldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(ldesignation);

        tfdesignation = new JTextField();
        tfdesignation.setBounds(550, 300, 150, 30);
        add(tfdesignation);

        JLabel laadhar = new JLabel("Aadhar Number");
        laadhar.setBounds(50, 350, 150, 30);
        laadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(laadhar);

        lblaadhar = new JLabel();
        lblaadhar.setBounds(200, 350, 150, 30);
        add(lblaadhar);
        
        
        JLabel lempid=new JLabel("Employee Id");
        lempid.setBounds(400,350,150,30);
        lempid.setFont(new Font("serif",Font.PLAIN,20));
        add(lempid);
        
        lblempid=new JLabel("");
        lblempid.setBounds(550,350,150,30);
        lblempid.setFont(new Font("serif",Font.PLAIN,20));
        add(lblempid);
        
        try {
            Connect con=new Connect();
            ResultSet rs=con.s.executeQuery("select *from employee where empId='"+empId+"';");
            while(rs.next()){
            lblname.setText(rs.getString("name"));
            tfaddress.setText(rs.getString("address"));
            tfphone.setText(rs.getString("phone"));
            lbldob.setText(rs.getString("dob"));
            tfsalary.setText(rs.getString("salary"));
            tfemail.setText(rs.getString("email"));
            tfeducation.setText(rs.getString("education"));
            lblaadhar.setText(rs.getString("aadhar"));
            tfdesignation.setText(rs.getString("designation"));
            
        }
       } catch (Exception e) {
            e.printStackTrace();
        }
        
        update=new JButton("UPDATE DETAILS");
        update.setBounds(200,450,150,40);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        add(update);
        
        update.addActionListener(this);
        
        back=new JButton("Go Back");
        back.setBounds(400,450,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);

        add(back);
        back.addActionListener(this);
        
        setSize(800, 700);
        setLocation(500,150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==update){
            String address=tfaddress.getText();
            String salary=tfsalary.getText();
            String email=tfemail.getText();
            String phone=tfphone.getText();
            String aadhar=lblaadhar.getText();
            String education=tfeducation.getText();
            String designation=tfdesignation.getText();
            
            
            try {
                Connect con=new Connect();
                String query="update employee set address= '"+address+"',phone='"+phone+"',salary ='"+salary+"', email ='"+email+"',education ='"+education+"',designation='"+designation+"' where empId='"+empId+"'";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Successfuly");
                setVisible(false);
                new Home();
                
            } catch (Exception e) {
            e.printStackTrace();
            }
            
        }else{
            setVisible(false);
            new Home();
        }
        

    }

}
