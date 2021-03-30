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
public class TableStatus {
    static String addTable(String[] data){
        Connection con= DbConnection.connect("TableDatabase.db");
        PreparedStatement ps=null;
        String mess=null;
        try {
            String sql="INSERT INTO Tables(tableno, status) VALUES(?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.execute();
            mess="Table Data  Added Successfully!";
            System.out.println("Data inserted!");
            
        } catch (SQLException e) {
            //Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(e+"");
        
        }
        return mess;
    }
    static String updateTable(int id, String tno, String sts)
    {
        Connection con= DbConnection.connect("TableDataBase.db");
        PreparedStatement ps=null;
        String mess=null;
        try {
            //System.out.println("hi43");
            String sql="UPDATE Tables set tableno=?, status=? WHERE tableId=?";
            //System.out.println("hi45");
            ps=con.prepareStatement(sql);
            //System.out.println("hi47");
            ps.setString(1, tno);
            //System.out.println("hi49");
            ps.setString(2, sts);
            //System.out.println("hi50");
            ps.setInt(3, id);
            //System.out.println("hi51");
            ps.execute();
            //System.out.println("hi52");
            mess="Updated Successfully!";
            //return mess;
           // System.out.println("Data inserted!");
            
        } catch (SQLException e) {
            //Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(e+"");
        
        }
        return mess;
        
        
    }
    
}
