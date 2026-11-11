package com.edu.co.sena.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conexion {
    public static final String username= "root";
    public static final String password= "";
    public static final String database= "dbsenaestudiantes";
    public static final String url = "jdbc:mysql://localhost:3306/" + database;
    
    public static Connection getConnection(){
        Connection cn= null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection(url, username, password);
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return cn;
    }
 
}
