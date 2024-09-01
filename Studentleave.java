package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class Studentleave extends JFrame implements ActionListener{
    Choice crollno, day;
    JDateChooser dcdate;
    JButton submit,cancel;
    Studentleave(){
        setSize(400,400);
        setLocation(500,200);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel heading = new JLabel("Apply Leave(Student)");
        heading.setBounds(50,30,250,30);
        heading.setFont(new Font("arial",Font.BOLD,20));
        add(heading);
        JLabel lblroll = new JLabel("Search by Regno");
        lblroll.setBounds(50,80,250,30);
        lblroll.setFont(new Font("arial",Font.PLAIN,15));
        add(lblroll);
        crollno = new Choice();
        crollno.setBounds(50,110,200,30);
        add(crollno);
        JLabel date = new JLabel("Date");
        date.setBounds(50,130,200,30);
        date.setFont(new Font("arial",Font.PLAIN,15));
        add(date);
        dcdate = new JDateChooser();
        dcdate.setBounds(50,160,200,20);
        add(dcdate);
        JLabel time = new JLabel("Duration");
        time.setBounds(50,190,200,20);
        time.setFont(new Font("arial",Font.PLAIN,15));
        add(time);
        day = new Choice();
        day.setBounds(50,210,200,20);
        day.add("Full day");
        day.add("Half day");
        add(day);
        submit = new JButton("Submit");
        submit.setBounds(45,300,80,30);
        submit.setFont(new Font("arial",Font.BOLD,12));
        submit.setBackground(Color.black);
        submit.addActionListener(this);
        submit.setForeground(Color.white);
        add(submit);
        cancel = new JButton("Cancel");
        cancel.setBounds(150,300,80,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("arial",Font.BOLD,12));
        cancel.addActionListener(this);
        add(cancel);
        setVisible(true);
        try{
            Conn c = new Conn();
            ResultSet rs =c.s.executeQuery("select * from student");
            while(rs.next()){
                crollno.add(rs.getString("reg"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
           String regno = crollno.getSelectedItem();
           String date = ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
           String duration = day.getSelectedItem();
           
           String query = "insert into studentleave values('"+regno+"','"+date+"','"+duration+"')";
           try{
               Conn c = new Conn();
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Leave Confirmed");
           }catch(Exception e){
               e.printStackTrace();
           }
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new Studentleave();
    }
}