/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author sasac
 */
public class ViewEmployees extends JFrame implements ActionListener {

    JButton search,viewAll,print,update,back;
    JTable table;
    Choice cemployeeid;

    public ViewEmployees() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel searchbyid = new JLabel("Search By Employee Id ");
        searchbyid.setBounds(20, 20, 200, 30);
        searchbyid.setFont(new Font("serif", Font.PLAIN, 20));
        add(searchbyid);

        cemployeeid = new Choice();
        cemployeeid.setBounds(250, 25, 150, 30);
        add(cemployeeid);

        search = new JButton("search");
        search.setBounds(450, 20, 150, 30);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        add(search);

        viewAll = new JButton("View All");
        viewAll.setBounds(630, 20, 150, 30);
        viewAll.setBackground(Color.BLACK);
        viewAll.setForeground(Color.WHITE);
        viewAll.addActionListener(this);
        add(viewAll);
        
        print = new JButton("print");
        print.setBounds(20, 80, 150, 30);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        add(print);

        update = new JButton("update");
        update.setBounds(220, 80, 150, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("back");
        back.setBounds(420, 80, 150, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        

        try {
            Connect con = new Connect();
            String query = "select *from employee";

            ResultSet rs = con.s.executeQuery(query);

            while (rs.next()) {

                cemployeeid.add(rs.getString("empId"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try {
            Connect con = new Connect();
            ResultSet rs = con.s.executeQuery("select *from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 125, 900, 600);
        add(jsp);
        setSize(900, 700);
        setLocation(500,150);
        setVisible(true);

    }

    public static void main(String[] args) {
        new ViewEmployees();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == search) {

            String query = "select *from employee where empId='" + cemployeeid.getSelectedItem() + "'";

            try {
                Connect con = new Connect();
                ResultSet rs = con.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }

        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
            }
        } else if (ae.getSource() == update) {
            
            setVisible(false);
            new UpdateEmployee(cemployeeid.getSelectedItem());
            

            
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Home();
        }else if (ae.getSource() == viewAll) {
            setVisible(false);
            new ViewEmployees();
        }

    }

}
