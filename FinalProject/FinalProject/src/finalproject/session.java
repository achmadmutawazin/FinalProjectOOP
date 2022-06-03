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
import java.util.Date;
/**
 *
 * @author achmadmutawazin
 */
public class session extends JFrame{
    connector c;
    JPanel pane = new JPanel();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Format shortTime = DateFormat.getTimeInstance(DateFormat.SHORT);
    JFormattedTextField input = new JFormattedTextField(shortTime);
    com.toedter.calendar.JDateChooser calendar = new com.toedter.calendar.JDateChooser();
    JLabel date = new JLabel("time : ");
    JLabel time = new JLabel("date : ");
    JButton sub = new JButton("submit");
    public session() {
        c = new connector();
        getContentPane().setLayout(null);
        setTitle("Session");
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
        pane.add(input); 
        input.setValue(new Date());
        input.setBounds(60,20,100,20);
        pane.add(date);
        date.setBounds(20,20,100,20);
        pane.add(calendar);
        calendar.setBounds(60, 60, 150, 20);
        pane.add(time);
        time.setBounds(20,60,100,20);
        pane.add(sub);
        sub.setBounds(70,100,100,30);
        
        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
            String dates = getDate();
            String times = Time();
                System.out.println(dates);
                System.out.println(times);
            int mdata=0;
            try {
           String query = "SELECT * FROM session WHERE id='1'"; 
           ResultSet resultSet = c.st.executeQuery(query);
           
           while (resultSet.next()){ 
                mdata++;
            }
            
            if (mdata==1) {
                query = "UPDATE session SET `date` = '"+dates+"',`time`= '"+ times +"'WHERE id= '1'";
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
        });
    }
    
    
    
    public String getDate(){
    return sdf.format(calendar.getDate());}
    
    public String Time(){
    return input.getText();}
    
    
}
