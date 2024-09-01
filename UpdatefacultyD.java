package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdatefacultyD extends JFrame implements ActionListener{
    
    Choice sempid;
    JButton submit,cancel;
    JLabel labelroll;
    JTextField address,emails,ccourse,pphone,bbranch;
    UpdatefacultyD(){
        setSize(650,550);
        setLocation(350,150);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        JLabel heading = new JLabel("Update Faculty Details:");
        heading.setBounds(5,10,350,50);
        heading.setFont(new Font("arial",Font.ITALIC,30));
        add(heading);
        JLabel roll = new JLabel("Select Employee ID");
        roll.setBounds(5,70,200,30);
        add(roll);
        sempid = new Choice();
        sempid.setBounds(215,70,150,30);
        add(sempid);
        try{
            Conn c = new Conn();
            ResultSet rs=c.s.executeQuery("select * from faculty");
            while(rs.next()){
                sempid.add(rs.getString("empid"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        JLabel name = new JLabel("Name");
        name.setBounds(5,110,100,30);
        add(name);
        JLabel labelname  = new JLabel();
        labelname.setBounds(120,110,100,30);
        add(labelname);
        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(270,110,100,30);
        add(fname);
        JLabel ffname = new JLabel();
        ffname.setBounds(380,110,100,30);
        add(ffname);
        JLabel rollno = new JLabel("Emp ID");
        rollno.setBounds(5,150,100,30);
        add(rollno);
         labelroll = new JLabel();
        labelroll.setBounds(110,150,100,30);
        add(labelroll);
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(270,150,100,30);
        add(dob);
        JLabel ddob = new JLabel();
        ddob.setBounds(380,150,100,30);
        add(ddob);
        JLabel adress = new JLabel("Address");
        adress.setBounds(5,190,100,20);
        add(adress);
        address = new JTextField();
        address.setBounds(115,190,100,25);
        add(address);
        JLabel phone = new JLabel("Phone");
        phone.setBounds(270,190,100,30);
        add(phone);
        pphone = new JTextField();
        pphone.setBounds(380,190,100,25);
        add(pphone);
        JLabel email = new JLabel("Email-Id");
        email.setBounds(5,230,100,30);
        add(email);
        emails = new JTextField();
        emails.setBounds(115,230,100,25);
        add(emails);
        JLabel x = new JLabel("ClassX");
        x.setBounds(270,230,100,30);
        add(x);
        JLabel xx = new JLabel();
        xx.setBounds(380,230,100,30);
        add(xx);
        JLabel xii = new JLabel("ClassXii");
        xii.setBounds(5,270,100,30);
        add(xii);
        JLabel xiii  = new JLabel();
        xiii.setBounds(115,270,100,30);
        add(xiii);
        JLabel adhaar = new JLabel("Adhaar");
        adhaar.setBounds(270,270,100,30);
        add(adhaar);
        JLabel aadhaar = new JLabel();
        aadhaar.setBounds(380,270,100,30);
        add(aadhaar);
        JLabel course = new JLabel("Education");
        course.setBounds(5,310,100,30);
        add(course);
        ccourse = new JTextField();
        ccourse.setBounds(115,310,100,25);
        add(ccourse);
        JLabel branch = new JLabel("Department");
        branch.setBounds(270,315,100,30);
        add(branch);
        bbranch = new JTextField();
        bbranch.setBounds(380,315,100,25);
        add(bbranch);
        
        try{
            Conn c = new Conn();
            String query = "select * from faculty where empid='"+sempid.getSelectedItem()+"'";
            ResultSet rs =c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                ffname.setText(rs.getString("fname"));
                labelroll.setText(rs.getString("empid"));
                ddob.setText(rs.getString("dob"));
                xx.setText(rs.getString("class_x"));
                xiii.setText(rs.getString("class_xii"));
                aadhaar.setText(rs.getString("adhaar"));
                ccourse.setText(rs.getString("Education"));
                bbranch.setText(rs.getString("Department"));
                emails.setText(rs.getString("email"));
                pphone.setText(rs.getString("phone"));
                address.setText(rs.getString("address"));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        submit = new JButton("Submit");
        submit.setBounds(115,365,100,30);
        submit.addActionListener(this);
        add(submit);
        cancel = new JButton("Cancel");
        cancel.setBounds(380,365,100,30);
        cancel.addActionListener(this);
        add(cancel);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==submit){
              String aaddress =  address.getText();
                         String phone = pphone.getText();
                         String emailid = emails.getText();
                        String course = ccourse.getText();
                        String branch = bbranch.getText();
                         String roll = labelroll.getText();
               try{
                        
                         String query= "update  faculty set address='"+aaddress+"',phone='"+phone+"',email='"+emailid+"',Education='"+course+"',Department='"+branch+"' where empid='"+roll+"'";
                          Conn c = new Conn();
                          c.s.executeUpdate(query);
                          JOptionPane.showMessageDialog(null,"Update Successful");
                          setVisible(false);
                       
               }catch(Exception e){
                   e.printStackTrace();
               }
            }else{
                setVisible(false);
            }
    }
    public static void main(String[] args){
        new UpdatefacultyD();
    }
}