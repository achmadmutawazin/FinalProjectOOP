/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author achmadmutawazin
 */
public class admin extends JFrame {
    connector c;
        JLabel luser = new JLabel("Username");
        JLabel lreal = new JLabel("Realname");
        JLabel lpass = new JLabel("Password");
        JLabel lstat = new JLabel("Status");
        JLabel lemp = new JLabel ("Employee Database");
        JLabel latd = new JLabel ("Attendance Record");
        JTable temp ;
        JTable tatd;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.now();
        LocalDate localdate = LocalDate.now();
        JTextField tuser = new JTextField();
        JTextField treal = new JTextField();
        JTextField tpass = new JTextField();
        JButton badd = new JButton("add");
        JButton bdel = new JButton("delete");
        JButton bup = new JButton("update");
        JButton bstat = new JButton("set status");
        JButton btime = new JButton ("set session");
        String[]stat={"valid","invalid"};
        JButton back = new JButton ("back");
        JComboBox cstat = new JComboBox(stat);
        JScrollPane satd;
        JScrollPane scrollpane;
        Object[] columnName = {"Username","Realname","Password","Status"};
        Object[] atdcol = {"Employee","Status","Time"};
        DefaultTableModel dtm;
        DefaultTableModel dtm2;
        
    public admin() {
        c = new connector();
        dtm = new DefaultTableModel(columnName,0);
        dtm2 = new DefaultTableModel(atdcol,0);
        temp = new JTable(dtm);
        tatd = new JTable(dtm2);
        scrollpane = new JScrollPane(temp);
        satd = new JScrollPane(tatd);
        
        setTitle("Administration Page");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(700,300);
        
        add(scrollpane);
        scrollpane.setBounds(260, 40, 400, 200);
        add(badd);
        badd.setBounds(20, 40, 100, 30);
        add(bdel);
        bdel.setBounds(20, 80, 100, 30);
        add(bup);
        bup.setBounds(20, 120, 100, 30);
        add(bstat);
        bstat.setBounds(20, 160, 100, 30);
        add(btime);
        btime.setBounds(20, 200, 100, 30);
        add(back);
        back.setBounds(20,10,100,20);
        
        
        add(luser);
        luser.setBounds(160, 40, 100, 30);
        add(tuser);
        tuser.setBounds(140,70,105,20);
        add(lpass);
        lpass.setBounds(160,140,100,30);
        add(tpass);
        tpass.setBounds(140,170,105,20);
        add(lstat);
        lstat.setBounds(170,190,100,30);
        add(cstat);
        cstat.setBounds(140,220,105,20);
        add(lemp);
        lemp.setBounds(400,20,200,20);
        add(lreal);
        lreal.setBounds(160, 90, 100, 20);
        add(treal);
        treal.setBounds(140,120,100,20);
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                loginopener log = new loginopener();
                dispose();
            }
        });
        
    }
    
    public String getTempl() {
        return tuser.getText();
    }

    public String getTreal() {
        return treal.getText();
    }

    public String getTpass() {
        return tpass.getText();
    }
    
    public String getCstat(){
        return cstat.getSelectedItem().toString();
    }
    
    public String getBtime(){
    return dtf.format(localTime);
    }
    
    public String getDate(){
    return sdf.format(localdate);}
    
    
        
        
        
        

    
    
    
    
}
