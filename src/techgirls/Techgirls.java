/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techgirls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ankit
 */
public class Techgirls {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        insert("Roma", "S","2021F001","Cashier","Roma@123");
        insert("Rey", "S","2021F002","Cook","Rey@123");
        insert("Tom", "M","2021F003","Waiter","Tom@123");
    }
   
    private static void insert(String firstName, String lastName, String empID, String empRole, String password)
    {
        Connection con= DbConnection.connect("EmployeeDataBase.db");
        PreparedStatement ps=null;

        try {
            String sql="INSERT INTO EmployeeDetails(firstName, lastName,empId, empRole, password) VALUES(?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, empID);
            ps.setString(4, empRole);
            ps.setString(5, password);
            ps.execute();
            System.out.println("Data inserted!");
            
        } catch (SQLException e) {
            //Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(e+"");
        
        }
    }
    
}

    