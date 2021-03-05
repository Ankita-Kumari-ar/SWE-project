/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techgirls;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ankit
 */
public class Billhistorymanage {
    static String addOrder(String[] data){
        Connection con= DbConnection.connect("BillDatabase.db");
        PreparedStatement ps=null;
        ResultSet rs=null;
        String mess=null;
        System.out.println("Bill");
        System.out.println(data[0]+" "+data[1]+" "+data[2]+" "+data[4]+" ");
        try {
            System.out.println("TRY");
            String sql="INSERT INTO OrderDetails (Date,CustomerName, CustomerMobile, TotalAmount) VALUES(?,?,?,?)";
            System.out.println("AGAIN");
            ps=con.prepareStatement(sql);
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.setString(3, data[2]);
            ps.setString(4, data[4]);
            System.out.println(data[0]+" "+data[1]+" "+data[2]+" "+data[4]+" ");
            ps.execute();
            
            String sql2="SELECT OrderId FROM OrderDetails WHERE Date=? AND CustomerName=? AND CustomerMobile=? AND TotalAmount=?";
            ps=con.prepareStatement(sql2);
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.setString(3, data[2]);
            ps.setString(4, data[4]);
            rs=ps.executeQuery();
            //mess="Payment Done Successfully!";
            System.out.println("Data inserted!");
            while(rs.next()){
                System.out.println("orderid "+rs.getString("OrderId"));
                return rs.getString("OrderId");
            }
            
            
        } catch (SQLException e) {
            //Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(e+"");
        
        }
        return mess;
    }
    
}
