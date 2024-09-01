package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class Feef extends JFrame implements ActionListener{
    Choice box,ccourse,bbranch;
    JComboBox ssem;
    JButton update,pay,cancel;
    JLabel labeltotal;
    Feef(){
        setSize(700,500);
        setLocation(300,150);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        JLabel sroll = new JLabel("Search by regno");
        sroll.setBounds(5,10,200,30);
        add(sroll);
        box = new Choice();
        box.setBounds(205,15,100,20);
        add(box);
        try{
           Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("select * from student");
           while(rs.next()){
               box.add(rs.getString("reg"));
           }
        }catch(Exception e){
            e.printStackTrace();
        }
        JLabel name = new JLabel("Name");
        name.setBounds(5,50,100,30);
        add(name);
        JLabel nname = new JLabel();
        nname.setBounds(110,50,150,30);
        add(nname);
        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(5,90,100,30);
        add(fname);
        JLabel nfname = new JLabel();
        nfname.setBounds(110,90,150,30);
        add(nfname);
        JLabel course = new JLabel("Course");
        course.setBounds(5,130,100,30);
        add(course);
         ccourse = new Choice();
        ccourse.setBounds(110,130,150,30);
        ccourse.add("Btech");
        ccourse.add("BBA");
        ccourse.add("MBA");
        ccourse.add("Msc");
        ccourse.add("Bsc");
        ccourse.add("Mcom");
        add(ccourse);
        JLabel branch = new JLabel("Branch");
        branch.setBounds(5,170,100,30);
        add(branch);
         bbranch = new Choice();
        bbranch.setBounds(110,170,150,30);
        bbranch.add("CSE");
         bbranch.add("MEC");
          bbranch.add("EEE");
           bbranch.add("CIVIL");
            bbranch.add("ECE");
             bbranch.add("None");
        add(bbranch);
        JLabel sem = new JLabel("Semester");
        sem.setBounds(5,210,100,30);
        add(sem);
        String semester[]={"semester1","semester2","semester3","semester4","semester5","semester6","semester7","semester8"};
         ssem = new JComboBox(semester);
        ssem.setBounds(110,210,150,30);
        
        add(ssem);
        
        JLabel total = new JLabel("Total Payable");
        total.setBounds(5,250,150,30);
        add(total);
        labeltotal  = new JLabel();
        labeltotal.setBounds(165,250,100,30);
        add(labeltotal);
        try{
            Conn c = new Conn();
            String query ="select * from student where reg='"+box.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                nname.setText(rs.getString("name"));
                nfname.setText(rs.getString("fname"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        box.addItemListener(new ItemListener(){
           public void itemStateChanged(ItemEvent ie){
                                    try{
                        Conn c = new Conn();
                        String query ="select * from student where reg='"+box.getSelectedItem()+"'";
                        ResultSet rs = c.s.executeQuery(query);
                        while(rs.next()){
                            nname.setText(rs.getString("name"));
                            nfname.setText(rs.getString("fname"));
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }
           } 
        });
        
        
        
        update = new JButton("Update");
        update.setBounds(5,300,75,30);
        update.addActionListener(this);
        add(update);
        pay = new JButton("Pay");
        pay.setBounds(100,300,75,30);
        pay.addActionListener(this);
        add(pay);
        cancel = new JButton("Cancel");
        cancel.setBounds(200,300,75,30);
        cancel.addActionListener(this);
        add(cancel);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(250,0,500,500);
        add(image);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==update){
            try{
                Conn c = new Conn();
                String course = (String)ccourse.getSelectedItem();
                String semester =   (String)ssem.getSelectedItem();
                ResultSet rs = c.s.executeQuery("select * from fee where course='"+course+"'");
                while(rs.next()){
                    
                    labeltotal.setText(rs.getString(semester));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == pay){
            String rollno = box.getSelectedItem();
            String course = (String) ccourse.getSelectedItem();
            String semester = (String) ssem.getSelectedItem();
            String branch = (String)bbranch.getSelectedItem();
            String total = labeltotal.getText();
                        try{
                                Conn c = new Conn();
                              
                                String query= "insert into collegefee values('"+rollno+"','"+course+"','"+semester+"','"+branch+"','"+total+"')";
                                c.s.executeUpdate(query);
                                JOptionPane.showMessageDialog(null, "Payment Successful");
                                setVisible(false);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
            
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new Feef();
    }
}