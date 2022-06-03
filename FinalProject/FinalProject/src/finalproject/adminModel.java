/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author achmadmutawazin
 */
public class adminModel {
    connector c;

    public adminModel() {
        c = new connector();}
        
        public String [][] read(){
        try{
            int mdata=0;
            String data[][] = new String [getData()][4];

        String query = "SELECT * FROM employee";
        ResultSet resultSet = c.st.executeQuery(query);
            while (resultSet.next()){
                data[mdata][0] = resultSet.getString("Username"); //harus sesuai nama kolom di mysql
                data[mdata][1] = String.valueOf(resultSet.getString("real name"));                
                data[mdata][2] = String.valueOf(resultSet.getString("password"));
                data[mdata][3] = String.valueOf(resultSet.getString("status"));
                mdata++;
            }return data;
        }catch(Exception e){
        System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;}}
        
        public void input(String username, String realname, String password){
            int mdata=0;
        try {
           String query = "SELECT * FROM employee WHERE Username='" + username+"'"; 
           System.out.println(username + " " + realname + " " + password);
           ResultSet resultSet = c.st.executeQuery(query);
           
           while (resultSet.next()){ 
                mdata++;
            }
            
            if (mdata==0) {
                query = "INSERT INTO `employee`(`Username`,`real name`,`password`,`status`) VALUES('"+username+"','"+realname+"','"+password+"','valid')";
                c.st = (Statement) c.conn.createStatement();
                c.st.executeUpdate(query); //execute querynya
                JOptionPane.showMessageDialog(null, "Succesfully Added");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data Already Exist");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, "Insert Cancelled");}}
    
        
        public void update(String username, String realname, String password){
    int mdata=0;     try {
           String query = "SELECT * FROM employee WHERE Username = '" + username+"'"; 
           ResultSet resultSet = c.st.executeQuery(query);
           
           while (resultSet.next()){ 
                mdata++;
            }
           
             if (mdata==1) {
                query = "UPDATE employee SET `real name`='" + realname + "',`password`='" + password +"' WHERE `Username`= '" + username + "'" ;
                c.st = (Statement) c.conn.createStatement();
                c.st.executeUpdate(query); //execute querynya
                JOptionPane.showMessageDialog(null, "Succesfully Updated");
             }
             else {
                 JOptionPane.showMessageDialog(null, "Data Invalid");
             }
           
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, "Update Invalid");
        }
    }
        
        public int getData(){
    int mdata=0;try{
            c.st = c.conn.createStatement();
            String query = "SELECT * FROM employee";
            ResultSet resultSet = c.st.executeQuery(query);
            while (resultSet.next()){ 
                mdata++;
            }
            return mdata;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
        public void delete(String username){
    try{
            String query = "DELETE FROM employee WHERE Username = '"+username+"'";
            c.st = c.conn.createStatement();
            c.st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Succefully Deleted");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
        
        public void status(String username,String status){
        int mdata=0;
        try {
           String query = "SELECT * FROM employee WHERE Username='" + username+"'"; 
           ResultSet resultSet = c.st.executeQuery(query);
           
           while (resultSet.next()){ 
                mdata++;
            }
            
            if (mdata==1) {
                query = "UPDATE employee SET `status` = '"+status+"' WHERE `Username`= '" + username + "'";
                c.st = (Statement) c.conn.createStatement();
                c.st.executeUpdate(query); //execute querynya
                JOptionPane.showMessageDialog(null, "Succesfully Update");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data doesnt exist");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, "Update Cancelled");}
        }
        
        public void dates(String date,String time){
        int mdata =0;
            try {
           String query = "SELECT * FROM session WHERE date='" + date +"'"; 
           ResultSet resultSet = c.st.executeQuery(query);
           
           while (resultSet.next()){ 
                mdata++;
            }
            
            if (mdata==0) {
                query = "INSERT INTO `session`(`date`,`time`) VALUES('"+date+"','"+time+"')";
                c.st = (Statement) c.conn.createStatement();
                c.st.executeUpdate(query); //execute querynya
                JOptionPane.showMessageDialog(null, "Succesfully Set");
            }
            else {
                JOptionPane.showMessageDialog(null, "data already exist");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, "Set Cancelled");}
        }
    
}
