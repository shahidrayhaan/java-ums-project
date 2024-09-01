package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class Fees extends JFrame{
    Fees(){
        setSize(1000,600);
        setLocation(300,150);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        JLabel heading = new JLabel("FEE STRUCTURE");
        heading.setBounds(5,10,250,40);
        heading.setFont(new Font("arial",Font.ITALIC,25));
        add(heading);
        JTable table = new JTable();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e ){
            e.printStackTrace();
        }
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,60,1000,600);
        add(jsp);
        setVisible(true);
        
        
    }
    public static void main(String[] args){
        new Fees();
    }
}