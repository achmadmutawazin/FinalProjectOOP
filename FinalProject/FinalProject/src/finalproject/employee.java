/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;
import java.text.*;
import java.time.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/**
 *
 * @author achmadmutawazin
 */
public class employee extends JFrame{
    String status;
    connector c;
    String user;
    JPanel pane = new JPanel();
    JButton present = new JButton("present attendance");
    JLabel emps = new JLabel("username : ");
    JLabel emp = new JLabel();
    JButton back = new JButton ("back");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    com.toedter.calendar.JDateChooser calendar = new com.toedter.calendar.JDateChooser();
    LocalTime localTime = LocalTime.now();
    LocalDate localdate = LocalDate.now();
    public employee(String username) {
        this.user = username;
        c = new connector();
        getContentPane().setLayout(null);
        setTitle("attendance");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setLocation(530,180);
        setSize(250,250);
        
        add(pane);
        pane.setBounds(0, 0, 250, 250);
        pane.setVisible(true);
        pane.setLayout(null);
       
        pane.add(emps);
        emps.setBounds(50, 20, 100, 30);
        pane.add(emp);
        emp.setText(username);
        emp.setBounds(120, 20, 100, 30);
        pane.add(present);
        present.setBounds(40, 100, 150, 30);
        pane.add(back);
        back.setBounds(40,160,100,30);
        
        present.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
            int mdata=0;
        try {
           String query = "SELECT * FROM attendance"; 
           ResultSet resultSet = c.st.executeQuery(query);
           while (resultSet.next()){ 
                mdata++;
            }
            
            if (mdata!=0) {
                query = "INSERT INTO `attendance`(`employee`,`status`,`time`,`date`) VALUES('"+username+"','absent','"+localTime+"','"+localdate+"')";
                c.st = (Statement) c.conn.createStatement();
                c.st.executeUpdate(query); //execute querynya
                JOptionPane.showMessageDialog(null, "Present Successful");
            }
            else {
                JOptionPane.showMessageDialog(null, "Present Failed");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, "Present Cancelled");}
            }
        });
        
    }
    
    
}
