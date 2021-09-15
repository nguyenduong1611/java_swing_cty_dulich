/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_cuoi_mon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Project_CuoiMon_java;user=sa;password=Nguyenthaiduong1";
        Connection conn = DriverManager.getConnection(dbURL);
        if (conn != null)
        System.out.println("Kết nối được rồi nhé");
    }
    
}
