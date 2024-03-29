/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement;

public class JdbcHelper {
    public static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String dburl = "jdbc:sqlserver://localhost:1433;databaseName=DUAN1;";   
    public static String username="sa";  
    public static String password="123";   
     public static Connection conn;

    static{ 
        try {            
            Class.forName(driver);  
        }          
        catch (ClassNotFoundException ex) {  
            throw new RuntimeException(ex);  
        }    
    }    
   
    public static PreparedStatement prepareStatement(String sql, Object...args) throws SQLException{
         conn = DriverManager.getConnection(dburl, username, password); 
        PreparedStatement pstmt = null;  
        if(sql.trim().startsWith("{")){ 
            pstmt = conn.prepareCall(sql);   
            }   
        else{            
            pstmt = conn.prepareStatement(sql);    
        }       
        for(int i=0;i<args.length;i++){ 
            pstmt.setObject(i + 1, args[i]);  
        }     
        return pstmt;     }   
   
    public static void executeUpdate(String sql, Object...args) {   
        try { 
             PreparedStatement stmt = prepareStatement(sql, args);         
             try {              
                 stmt.executeUpdate();        
             }             
             finally{                
                 stmt.getConnection().close();    
             }        
        }          
        catch (SQLException e) {            
//            throw new RuntimeException(e); 
            e.printStackTrace();
        }     
    }    
    public static ResultSet executeQuery(String sql, Object...args) {      
        try {          
            PreparedStatement stmt = prepareStatement(sql, args);     
            return stmt.executeQuery();        
        }          
        catch (SQLException e) {       
            throw new RuntimeException(e);    
        }    
    }
    public static int ExecuteTruyVan(String sql){
        try {
            Statement stm = conn.createStatement();
            int kq = stm.executeUpdate(sql);
            return kq;
        } catch (SQLException ex) {
            System.out.println("Lỗi thực thi lệnh SQL");
            return -1;
        }        
    }
} 
        
