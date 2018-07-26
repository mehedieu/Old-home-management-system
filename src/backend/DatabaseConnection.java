/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class DatabaseConnection {

    Connection connection=null;
    public DatabaseConnection() {
        System.out.println("Connecting database....");
    }
    
    
  public void connect() {
      String url = "jdbc:mysql://localhost:3306/mynewdatabase";
      String username = "root";
      String password = "burirhat124876";

try {
    connection = DriverManager.getConnection(url, username, password);
        
    System.out.println("Database connected!");
} catch (SQLException e) {
    throw new IllegalStateException("Cannot connect the database!", e);
}
        
    /*   
        System.out.println("Loading driver...");

try {
    Class.forName("com.mysql.jdbc.Driver");
    System.out.println("Driver loaded!");
} catch (ClassNotFoundException e) {
    throw new IllegalStateException("Cannot find the driver in the classpath!", e);
}
        
        
    */    
        
        
    }
    
    
    
    
}