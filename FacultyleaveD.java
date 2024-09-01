package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class FacultyleaveD extends JFrame implements ActionListener{
    
    Choice ssearch;
    JButton searchs,print,cancel;
    JTable table;
    FacultyleaveD(){
        setSize(650,550);
        setLocation(350,150);
        getContentPane().setBackground(Color.white);
        JLabel search = new JLabel("Search by EmpID");
        search.setBounds(30,30,100,20);
        add(search);
        ssearch = new Choice();
        ssearch.setBounds(150,30,150,20);
        add(ssearch);
        try{
            Conn c = new Conn();
            ResultSet rs=c.s.executeQuery("select * from faculty");
            while(rs.next()){
                ssearch.add(rs.getString("empid"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        setLayout(null);
        searchs = new JButton("Search");
        searchs.setBounds(20,60,75,20);
        add(searchs);
        print = new JButton("Print");
        print.addActionListener(this);
        print.setBounds(105,60,70,20);
        add(print);
        cancel = new JButton("Cancel");
        cancel.setBounds(185,60,75,20);
        cancel.addActionListener(this);
        add(cancel);
        table = new JTable();
        try{
            Conn c = new Conn();
            ResultSet rs=c.s.executeQuery("select * from facultyleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,1500,600);
        add(jsp);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==print){
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()== searchs){
           try{
                Conn c = new Conn();
                ResultSet rs=c.s.executeQuery("select * from facultyleave where empid='"+ssearch+"'");
                table.setModel(DbUtils.resultSetToTableModel(rs));
            
           }catch(Exception e){
               e.printStackTrace();
           }
            
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new FacultyleaveD();
    }
}