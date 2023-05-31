/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author sasac
 */
public class Connect {
    Connection con;
    Statement s;
    
    public Connect(){
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employemanagementsystem","root","root");
            
            s = con.createStatement();
       
            
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    
}
