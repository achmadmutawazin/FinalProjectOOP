/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import javax.swing.*;
/**
 *
 * @author achmadmutawazin
 */
public class loginopener extends JFrame{
    Color Color;
    connector c;
    
    JLayeredPane lpane = new JLayeredPane();
    
    JPanel pane = new JPanel();
    JButton buser = new JButton("User");
    JButton badmin = new JButton("Admin");
    
    JPanel emp = new JPanel();
    JButton louser = new JButton("Login");
    JButton empback = new JButton("Back");
    JLabel luser = new JLabel("username");
    JLabel lpass = new JLabel("password");
    JTextField tuser = new JTextField();
    JPasswordField tpass = new JPasswordField();
    
    JPanel adm = new JPanel();
    JButton loadm = new JButton("Login");
    JButton admback = new JButton("Back");
    JLabel luadm = new JLabel("username");
    JLabel lpadm = new JLabel("password");
    JTextField tuadm = new JTextField();
    JPasswordField tpadm = new JPasswordField();
    

    
    
    
    Font fbutton = new Font("Work Sans SemiBold", 1,20);

    public loginopener() {
        c = new connector();
        
        getContentPane().setLayout(null);
        setTitle("Employee Attendance System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setLocation(530,180);
        setSize(250,250);
        add(pane);
        add(emp);
        add(adm);
        
        pane.setBounds(0, 0, 250, 250);
        pane.setVisible(true);
        pane.setLayout(null);
        pane.setBackground(new Color(41,54,63));
        
        emp.setVisible(false);
        adm.setVisible(false);
        
        
        
        buser.setForeground(Color.white);
        pane.add(buser);
        buser.setBounds(30,40,180,50);
        buser.setFont(fbutton);
        buser.setBackground(new Color(110,217,161));
        buser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
            buserPerformed(evt);
            }
        });
        
        
        badmin.setForeground(Color.white);
        pane.add(badmin);
        badmin.setFont(fbutton);
        badmin.setBounds(30, 110, 180, 50);
        badmin.setBackground(new Color(110,217,161));
        badmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
            badminPerformed(evt);
            }
        });
        
        emp.setBounds(0, 0, 250, 250);
        emp.setLayout(null);
        emp.setBackground(new Color(41,54,63));
        emp.add(luser);
        luser.setForeground(Color.white);
        luser.setFont(fbutton);
        luser.setBounds(65,10,150,20);
        emp.add(lpass);
        lpass.setForeground(Color.white);
        lpass.setFont(fbutton);
        lpass.setBounds(65,70,150,20);
        emp.add(tuser);
        tuser.setBounds(40,40,160,20);
        emp.add(tpass);
        tpass.setBounds(40,100,160,20);
        emp.add(louser);
        louser.setBackground(new Color(110,217,161));
        louser.setForeground(Color.white);
        louser.setBounds(10, 150, 100, 30);
        emp.add(empback);
        empback.setBackground(new Color(110,217,161));
        empback.setForeground(Color.white);
        empback.setBounds(130, 150, 100, 30);
        
        adm.setBounds(0, 0, 250, 250);
        adm.setLayout(null);
        adm.setBackground(new Color(41,54,63));
        adm.add(luadm);
        luadm.setForeground(Color.white);
        luadm.setFont(fbutton);
        luadm.setBounds(65,10,150,20);
        adm.add(lpadm);
        lpadm.setForeground(Color.white);
        lpadm.setFont(fbutton);
        lpadm.setBounds(65,70,150,20);
        adm.add(tuadm);
        tuadm.setBounds(40,40,160,20);
        adm.add(tpadm);
        tpadm.setBounds(40,100,160,20);
        adm.add(loadm);
        loadm.setBackground(new Color(110,217,161));
        loadm.setForeground(Color.white);
        loadm.setBounds(10, 150, 100, 30);
        adm.add(admback);
        admback.setBackground(new Color(110,217,161));
        admback.setForeground(Color.white);
        admback.setBounds(130, 150, 100, 30);
        
        tpadm.addKeyListener(new KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt){
            tpadmPressed(evt);
            }
        });
        
        admback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
            admbackPerformed(evt);
            }
        });
        
        tpass.addKeyListener(new KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt){
            tpassPressed(evt);
            }
        });
        
        empback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
            empbackPerformed(evt);
            }
        });
        
        louser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
            louserPerformed(evt);
            }
        });
        
        loadm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
            loadmPerformed(evt);
            }
        });
        }
    
        
    
    private void tpadmPressed(java.awt.event.KeyEvent evt){
    if(evt.getKeyCode() ==  KeyEvent.VK_ENTER ){
        try {

            CallableStatement elog = c.conn.prepareCall("select * from admin where Username = ? and password = ?");
            
            elog.setString(1, tuadm.getText());
            elog.setString(2, tpadm.getText());

            ResultSet rs = elog.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Welcome");
                admin adminp = new admin();
                adminModel model = new adminModel();
                admincon controller = new admincon(adminp,model);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password or User doesn't exist", "Invalid", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    }
    
    private void tpassPressed(java.awt.event.KeyEvent evt){
    if(evt.getKeyCode() ==  KeyEvent.VK_ENTER ){
        try {

            CallableStatement elog = c.conn.prepareCall("select * from employee where Username = ? and password = ? and status = 'valid'");
            elog.setString(1, tuser.getText());
            elog.setString(2, tpass.getText());

            ResultSet rs = elog.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Welcome");
                employee emps = new employee(tuser.getText());
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password or User doesn't exist", "Invalid", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    }    
    private void louserPerformed(ActionEvent evt){
        try {
                    CallableStatement elog = c.conn.prepareCall("select * from employee where Username = ? and password = ? and status = 'valid'");
                    elog.setString(1, tuser.getText());
                    elog.setString(2, tpass.getText());

                    ResultSet rs = elog.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(this, "Welcome");
                        employee emps = new employee(tuser.getText());
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid Username or Password or User doesn't exist", "Invalid", JOptionPane.WARNING_MESSAGE);
                    }

                } catch (Exception ex) {
                    System.out.println(ex.toString());
                }
            }
    
     private void loadmPerformed(ActionEvent evt){
        try {
                    CallableStatement elog = c.conn.prepareCall("select * from admin where Username = ? and password = ?");
                    elog.setString(1, tuadm.getText());
                    elog.setString(2, tpadm.getText());

                    ResultSet rs = elog.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(this, "Welcome");
                        admin adminp = new admin();
                        adminModel model = new adminModel();
                        admincon controller = new admincon(adminp,model);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid Username or Password or User doesn't exist", "Invalid", JOptionPane.WARNING_MESSAGE);
                    }

                } catch (Exception ex) {
                    System.out.println(ex.toString());
                }
            }
    
    private void buserPerformed(ActionEvent evt){
    pane.setVisible(false);
    emp.setVisible(true);
    adm.setVisible(false);
    }
    
    private void badminPerformed(ActionEvent evt){
    pane.setVisible(false);
    emp.setVisible(false);
    adm.setVisible(true);
    }
    
    private void admbackPerformed(ActionEvent evt){
        tuadm.setText("");
        tpadm.setText("");
        
    pane.setVisible(true);
    emp.setVisible(false);
    adm.setVisible(false);
    }
    
    private void empbackPerformed(ActionEvent evt){
        tuser.setText("");
        tpass.setText("");
        
    pane.setVisible(true);
    emp.setVisible(false);
    adm.setVisible(false);
    }
}
