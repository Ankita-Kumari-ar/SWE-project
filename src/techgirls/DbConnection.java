/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techgirls;

/**
 *
 * @author ankit
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {
    public static Connection connect(String s)
    {
        Connection con= null;
        try {
            Class.forName("org.sqlite.JDBC");
            con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\ankit\\Desktop\\TechGirls\\Entities\\"+s);
            System.out.println("Connected");
        } catch (ClassNotFoundException | SQLException e) {
            //Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(e+"");
        
        }
        return con;
    }
}
