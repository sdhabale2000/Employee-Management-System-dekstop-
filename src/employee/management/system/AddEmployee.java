/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author sasac
 */
public class AddEmployee extends JFrame implements ActionListener {

    Random ran = new Random();
    int number = ran.nextInt(999999);
    JButton add, back;
    JTextField tfname, tfaddress, tfsalary, tfphone, tfemail, tfdesignation, tfaadhar;
    JComboBox cbeducation;
    JDateChooser dcdob;
    JLabel l2empid;

    public AddEmployee() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("ADD EMPLOYEE");
        heading.setBounds(250, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel lname = new JLabel("Name");
        lname.setBounds(50, 150, 150, 30);
        lname.setFont(new Font("serif", Font.PLAIN, 20));
        add(lname);

        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);

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
        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);

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

        String courses[] = {"B.Sc", "BCA", "B.com", "BTech", "MSC", "MCA", "MTech", "MBA"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBounds(200, 300, 150, 30);
        cbeducation.setBackground(Color.WHITE);

        add(cbeducation);

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

        tfaadhar = new JTextField();
        tfaadhar.setBounds(200, 350, 150, 30);
        add(tfaadhar);

        JLabel lempid = new JLabel("Employee Id");
        lempid.setBounds(400, 350, 150, 30);
        lempid.setFont(new Font("serif", Font.PLAIN, 20));
        add(lempid);

        l2empid = new JLabel("" + number);
        l2empid.setBounds(550, 350, 150, 30);
        l2empid.setFont(new Font("serif", Font.PLAIN, 20));
        add(l2empid);

        add = new JButton("Add Details");
        add.setBounds(200, 450, 150, 40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);

        add.addActionListener(this);

        back = new JButton("Go Back");
        back.setBounds(400, 450, 150, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);

        add(back);
        back.addActionListener(this);

        setSize(800, 700);
        setLocation(500, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = tfname.getText();
            String address = tfaddress.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();
            String aadhar = tfaadhar.getText();
            String education = (String) cbeducation.getSelectedItem();
            String designation = tfdesignation.getText();
            String empId = l2empid.getText();

            try {
                Connect con = new Connect();

                boolean valid = true;
                if (!Character.isAlphabetic(tfname.getText().charAt(0))) {
                    JOptionPane.showMessageDialog(null, "Input Details is wrong !");
                    setVisible(false);
                    new AddEmployee();
                }

           
            if (!Character.isAlphabetic(tfaddress.getText().charAt(0))) {

                JOptionPane.showMessageDialog(null, "Input Details is wrong !");
                setVisible(false);
                new AddEmployee();
            }

        
        if (!Character.isDigit(tfsalary.getText().charAt(0))) {

            JOptionPane.showMessageDialog(null, "Input Details is wrong !");
            setVisible(false);
            new AddEmployee();
        }

        if (!Character.isAlphabetic(tfemail.getText().charAt(0))) {

            JOptionPane.showMessageDialog(null, "Input Details is wrong !");
            setVisible(false);
            new AddEmployee();

        }
        if (!Character.isAlphabetic(tfdesignation.getText().charAt(0))) {
            JOptionPane.showMessageDialog(null, "Input Details is wrong !");
            setVisible(false);
            new AddEmployee();
        }

        if (!Character.isDigit(tfaadhar.getText().charAt(0))) {
            JOptionPane.showMessageDialog(null, "Input Details is wrong !");
            setVisible(false);
            new AddEmployee();
        }

    

    String query = "insert into employee values ('" + name + "','" + address + "','" + phone + "','" + dob + "','" + salary + "','" + email + "','" + education + "','" + aadhar + "','" + designation + "','" + empId + "')";

    con.s.executeUpdate (query);

    JOptionPane.showMessageDialog (null, "Details Addeed Successfuly");
    setVisible(false);
      new Home();

        }
catch (Exception e) {
                e.printStackTrace();
                
                if(e!=null){
                     JOptionPane.showMessageDialog (null, "Details not added Successfuly");
               
                
                
                }
            }

        } else {
            setVisible(false);
            new Home();
        }

    }

}
