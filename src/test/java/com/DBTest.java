package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBTest {
	
public static int sum = 0;
	
	
	public static final String url = "jdbc:mysql://127.0.0.1/angelchildrens?characterEncoding=utf8&useSSL=false";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String username = "root";  
    public static final String password = "gofucking";
  
    
    public static Connection conn = null;  
    public static PreparedStatement pst = null;  
  
    
    public static void main(String[] args) {
    	
    	try {
    		
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            
            
            if(conn != null){
            	System.out.println("Test:Connection successful!"+sum++);
            	pst = conn.prepareStatement("select * from user");
            }
            
        } catch (Exception e) {  
            e.printStackTrace();  
        }
    }
    
    
    
    public void close() {
        try {  
            DBTest.conn.close();
            DBTest.pst.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }
}
