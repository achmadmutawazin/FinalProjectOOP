/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author achmadmutawazin
 */
public class admincon {
    admin a;
    adminModel am;
    public String data;

    public admincon(admin a, adminModel am) {
        this.a = a;
        this.am = am;
        
        if (am.getData()!=0){
            String mdata[][] = am.read();
            a.temp.setModel((new JTable(mdata, a.columnName)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Data is Empty");
        }
        
        a.badd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String username = a.getTempl();
                String realname = a.getTreal();
                String password = a.getTpass();
                am.input(username, realname, password);
                String mdata[][] = am.read();
                a.temp.setModel((new JTable(mdata, a.columnName)).getModel());
            }
        });
        
        a.bup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String username = a.getTempl();
                String realname = a.getTreal();
                String password = a.getTpass();
                am.update(username, realname, password);
                String mdata[][] = am.read();
                a.temp.setModel((new JTable(mdata, a.columnName)).getModel());
            }
        });
        
        a.temp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                
                int row = a.temp.getSelectedRow();
                data = a.temp.getValueAt(row, 0).toString();
                String dataU[] = new String[4];
                dataU[0] = a.temp.getValueAt(row, 0).toString();
                dataU[1] = a.temp.getValueAt(row, 1).toString();
                System.out.println(data);  
            }
           });
        
        a.bdel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               int input = JOptionPane.showConfirmDialog(null,
                "Do you want to delete data :  " + data + "?", "Choose Option", JOptionPane.YES_NO_OPTION);

            if (input == 0) {
                am.delete(data);
                String mdata[][] = am.read();
                a.temp.setModel((new JTable(mdata, a.columnName)).getModel());
            } else {
                JOptionPane.showMessageDialog(null, "Delete Failed");
            }
                }
        });
        
        a.bstat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
            String status = a.getCstat();
            int input = JOptionPane.showConfirmDialog(null,
                "Do you want to set data :  " + data + "?", "Choose Option", JOptionPane.YES_NO_OPTION);
            if (input == 0) {
                am.status(data,status);
                String mdata[][] = am.read();
                a.temp.setModel((new JTable(mdata, a.columnName)).getModel());
            } else {
                JOptionPane.showMessageDialog(null, "set Failed");
            }
            }
        });
        
        a.btime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                session sesi = new session();
            }
        });
    }

}
    
    
    
    

