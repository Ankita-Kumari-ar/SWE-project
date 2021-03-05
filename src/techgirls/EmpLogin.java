/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techgirls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ankit
 */
public class EmpLogin {
    static String loginverify(String empid, String passw,String emprole)
    {
        Connection con= DbConnection.connect("EmployeeDataBase.db");
        PreparedStatement ps=null;
        ResultSet rs=null;
        String m="Invalid Login";
        try
        {
            //String sql="SELECT * FROM EmployeeDetails WHERE empID=? AND password=? AND empRole=?";
            String sql="SELECT * FROM EmployeeDetails WHERE empID=? ";
            ps=con.prepareStatement(sql);
            ps.setString(1,empid);
            //ps.setString(2, passw);
            //ps.setString(3, emprole);
            rs=ps.executeQuery();
            //System.out.println("FirstName "+rs.getString("firstName"));
            while(rs.next()){
                
                System.out.println("FirstName "+rs.getString("firstName"));
                System.out.println("LastName "+rs.getString("lastName"));
                //System.out.println("Roll "+rs.getInt("roll"));
                System.out.println("password "+rs.getString("password"));
                System.out.println("pass "+ passw);
                System.out.println("Role "+rs.getString("empRole"));
                System.out.println("Role "+emprole);
                System.out.println(passw.getClass().getName()+" "+emprole.getClass().getName());
                System.out.println(rs.getString("password").getClass().getName()+" "+ rs.getString("empRole").getClass().getName()); 
                if(rs.getString("password") == null ? passw == null : rs.getString("password").equals(passw))
                {   if(rs.getString("empRole") == null ? emprole == null : rs.getString("empRole").equals(emprole))
                    {
                        m="Login verified";
                    System.out.println("M "+m);
                    }
                }
                    
                else m="Invalid Login";
                
            }
            System.out.println("Data inserted!");
            
        } 
        catch (SQLException e)
        {
        
            System.out.println(e.toString());
            return e.toString();
        
        }finally{
            try{
                rs.close();
                ps.close();
                con.close();
                
            }catch(SQLException e){
                System.out.println(e.toString());
                return e.toString();
            }
        }
     return m;   
    }


}
