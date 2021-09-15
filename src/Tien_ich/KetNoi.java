/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tien_ich;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author ASUS
 */
public class KetNoi {
      public static Connection ketnoi(String database){
        try {
            String user = "sa";
            String pass = "Nguyenthaiduong1";
            Class.forName ("com.microsoft.sqlserver.jdbc.SQLServerDriver") ;
            String url = "jdbc:sqlserver://localhost:1433;databaseName="+database;
            Connection cn = DriverManager.getConnection(url,user,pass);
            return cn;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
