package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
public class Results extends JFrame{
    String rollno;
    JLabel seem;
    Results(String rollno){
        setSize(700,600);
        setLocation(300,150);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        JLabel heading = new JLabel("University");
        heading.setBounds(300,10,200,40);
        heading.setFont(new Font("arial",Font.ITALIC,20));
        add(heading);
        JLabel regno = new JLabel("Registration Number"+rollno);
        regno.setBounds(40,100,200,30);
        add(regno);
        seem = new JLabel();
        seem.setBounds(40,140,200,30);
        add(seem);
        JLabel sub1 = new JLabel();
        sub1.setBounds(100,1700,200,30);
        add(sub1);
        JLabel sub2 = new JLabel();
        sub2.setBounds(100,200,200,30);
        add(sub2);
        JLabel sub3 = new JLabel();
        sub3.setBounds(100,230,200,30);
        add(sub3);
        JLabel sub4 = new JLabel();
        sub4.setBounds(100,260,200,30);
        add(sub4);
        JLabel sub5 = new JLabel();
        sub5.setBounds(100,290,200,30);
        add(sub5);
        try{
            Conn c = new Conn();
            ResultSet rs1=c.s.executeQuery("select * from subject where regno='"+rollno+"'");
            while(rs1.next()){
                sub1.setText(rs1.getString("subject1"));
                 sub2.setText(rs1.getString("subject2"));
                  sub3.setText(rs1.getString("subject3"));
                   sub4.setText(rs1.getString("subject4"));
                    sub5.setText(rs1.getString("subject5"));
                
            }
            ResultSet rs2 =c.s.executeQuery("select * from marks where regno= '"+rollno+"'");
            while(rs2.next()){
                sub1.setText(sub1.getText() + "-----------"+ rs2.getString("marks1"));
                sub2.setText(sub2.getText() + "-----------"+ rs2.getString("marks2"));
                sub3.setText(sub3.getText() + "-----------"+ rs2.getString("marks3"));
                sub4.setText(sub4.getText() + "-----------"+ rs2.getString("marks4"));
                sub5.setText(sub5.getText() + "-----------"+ rs2.getString("marks5"));
                seem.setText("Semester " + rs2.getString("semester"));
                 
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    public static void main(String[] args){
        new Results("");
    }
}