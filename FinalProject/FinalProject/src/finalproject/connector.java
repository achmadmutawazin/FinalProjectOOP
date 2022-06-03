/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;
import java.sql.*;
/**
 *
 * @author achmadmutawazin
 */
public class connector {
    Connection conn;
    Statement st;

    public connector() {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/company", "root", "");
        st = conn.createStatement();
            System.out.println("connection success");
        }catch(Exception ex){
            System.out.println("connection failed " + ex.toString());
        }
    }   
}
