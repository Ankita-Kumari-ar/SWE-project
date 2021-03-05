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
public class MenuControl {
    
    static String addMenu(String[] data){
        Connection con= DbConnection.connect("MenuDataBase.db");
        PreparedStatement ps=null;
        String mess=null;
        try {
            String sql="INSERT INTO Menu(Fooditem, PricePerUnit) VALUES(?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.execute();
            mess="Food Item Added Successfully!";
            System.out.println("Data inserted!");
            
        } catch (SQLException e) {
            //Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(e+"");
        
        }
        return mess;
    }
    static String updateMenu(int id, String foodname, String price)
    {
        Connection con= DbConnection.connect("MenuDataBase.db");
        PreparedStatement ps=null;
        String mess=null;
        try {
            String sql="UPDATE Menu set Fooditem=?, PricePerUnit=? WHERE Id=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, foodname);
            ps.setString(2, price);
            ps.setInt(3, id);
            ps.execute();
            mess="Updated Successfully!";
            //return mess;
           // System.out.println("Data inserted!");
            
        } catch (SQLException e) {
            //Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(e+"");
        
        }
        return mess;
        
        
    }
    static String deleteItem(int id){
        Connection con= DbConnection.connect("MenuDataBase.db");
        PreparedStatement ps=null;
        String mess=null;
        try {
            String sql="DELETE FROM Menu WHERE Id=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            mess="Deleted Successfully!";
            //return mess;
           // System.out.println("Data inserted!");
            
        } catch (SQLException e) {
            //Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(e+"");
        
        }
        return mess;
        
        
        
    }
    
}
