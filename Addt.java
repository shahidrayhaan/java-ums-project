package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;




public class Addt extends JFrame implements ActionListener{
    JTextField sname1,fname1,address1,phone1,email1,x1,xii1,adhar1;
    JDateChooser dcdobl;
    JLabel labelempid;
    JLabel ccourse, bbranch;
    JComboBox lcourse ,lbranch;
    JButton submit,cancel;
   
    Random ran = new Random();
    long nums = Math.abs((ran.nextLong() % 9000L)+1000L);
    Addt(){
        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        JLabel heading = new JLabel("FACULTY DETAILS");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("arial",Font.BOLD,30));
        add(heading);
        JLabel sname = new JLabel("Name");
        sname.setBounds(50,150,100,30);
        sname.setFont(new Font("arial",Font.BOLD,15));
        add(sname);
        sname1 = new JTextField();
        sname1.setBounds(200,150,150,30);
        add(sname1);
        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("arial",Font.BOLD,15));
        add(fname);
        fname1 = new JTextField();
        fname1.setBounds(600,150,150,30);
        add(fname1);
        JLabel roll = new JLabel("EmpId Number");
        roll.setBounds(50,200,200,30);
        roll.setFont(new Font("arial",Font.BOLD,15));
        add(roll);
        labelempid = new JLabel("123"+nums);
        labelempid.setBounds(200,200,200,30);
        add(labelempid);
        JLabel dob = new JLabel("Date of birth");
        dob.setBounds(400,200,200,30);
        add(dob);
        dcdobl = new JDateChooser();
        dcdobl.setBounds(600,200,150,30);
        add(dcdobl);
        JLabel address = new JLabel("Address");
        address.setBounds(50,250,100,30);
        address.setFont(new Font("arial",Font.BOLD,15));
        add(address);
        address1 = new JTextField();
        address1.setBounds(200,250,150,30);
        add(address1);
        JLabel phone = new JLabel("Phone");
        phone.setBounds(400,250,200,30);
        phone.setFont(new Font("arial",Font.BOLD,15));
        add(phone);
        phone1 = new JTextField();
        phone1.setBounds(600,250,150,30);
        add(phone1);
        JLabel email = new JLabel("Email-id");
        email.setBounds(50,300,200,30);
        email.setFont(new Font("arial",Font.BOLD,15));
        add(email);
        email1 = new JTextField();
        email1.setBounds(200,300,150,30);
        add(email1);
        JLabel x = new JLabel("10th percentage");
        x.setBounds(400,300,200,30);
        x.setFont(new Font("arail",Font.BOLD,15));
        add(x);
        x1 = new JTextField();
        x1.setBounds(600,300,150,30);
        add(x1);
        JLabel xii = new JLabel("12th percentage");
        xii.setBounds(50,350,200,30);
        xii.setFont(new Font("arial",Font.BOLD,15));
        add(xii);
        xii1 = new JTextField();
        xii1.setBounds(200,350,150,30);
        add(xii1);
        JLabel adhar = new JLabel("Adhaar");
        adhar.setBounds(400,350,200,30);
        adhar.setFont(new Font("arial",Font.BOLD,15));
        add(adhar);
        adhar1 = new JTextField();
        adhar1.setBounds(600,350,150,30);
        add(adhar1);
        ccourse = new JLabel("Qualification");
        ccourse.setBounds(50,400,150,30);
        ccourse.setFont(new Font("arial",Font.BOLD,15));
        add(ccourse);
        String course[] = {"B.Tech","BBA","MBA","Msc","Bsc","Mcom"};
        lcourse = new JComboBox(course);
        lcourse.setBackground(Color.white);
        lcourse.setBounds(200,400,150,30);
        add(lcourse);
        bbranch = new JLabel("Department");
        bbranch.setBounds(400,400,150,30);
        bbranch.setFont(new Font("arial",Font.BOLD,15));
        add(bbranch);
        String branch[] = {"CSE","MEC","EEE","CIVIL","ECE","None"};
        lbranch = new JComboBox(branch);
        lbranch.setBounds(600,400,150,30);
        lbranch.setBackground(Color.white);
        add(lbranch);
        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setFont(new Font("arial",Font.BOLD,15));
        submit.setBounds(250,500,100,30);
        submit.addActionListener(this);
        submit.setForeground(Color.white);
        add(submit);
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(400,500,100,30);
        cancel.setFont(new Font("arial",Font.BOLD,15));
        cancel.addActionListener(this);
        add(cancel);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String name = sname1.getText();
            String fname =fname1.getText();
            String reg = labelempid.getText();
            String dob =  ((JTextField)dcdobl.getDateEditor().getUiComponent()).getText();
            String address = address1.getText();
            String phone = phone1.getText();
            String email = email1.getText();
            String x = x1.getText();
            String xii = xii1.getText();
            String adhaar = adhar1.getText();
            String course =(String)lcourse.getSelectedItem();
            String branch = (String)lbranch.getSelectedItem();
            
            try{
                String query = "insert into faculty values('"+name+"','"+fname+"','"+reg+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+adhaar+"','"+course+"','"+branch+"')";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Faculty details inserted successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new Addt();
    }

   
    
}