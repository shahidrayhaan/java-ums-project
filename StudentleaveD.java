package university.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class StudentleaveD extends JFrame implements ActionListener{
    Choice creg;
    JTable table;
    JButton ssearch,print,cancel;
    StudentleaveD(){
        setSize(650,550);
        setLocation(350,150);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        JLabel search = new JLabel("Search by Reg");
        search.setBounds(30,30,100,20);
        add(search);
        creg = new Choice();
        creg.setBounds(140,30,150,20);
        add(creg);
        try{
            Conn c = new Conn();
            ResultSet rs=c.s.executeQuery("select * from student");
            while(rs.next()){
                   creg.add(rs.getString("reg"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        ssearch = new JButton("Search");
        ssearch.setBounds(20,65,75,20);
        ssearch.addActionListener(this);
        add(ssearch);
        print = new JButton("Print");
        print.setBounds(110,65,70,20);
        print.addActionListener(this);
        add(print);
        cancel = new JButton("Cancel");
        cancel.setBounds(200,65,75,20);
        cancel.addActionListener(this);
        add(cancel);
        table = new JTable();
        try{
            Conn c = new Conn();
            ResultSet rs=c.s.executeQuery("select * from studentleave");
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
        if(ae.getSource()==ssearch){
            try{
             Conn c = new Conn();
             ResultSet rs =c.s.executeQuery("select * from student where reg='"+creg+"'");
             table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==print){
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new StudentleaveD();
    }
}