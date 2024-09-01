package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class Exams extends JFrame implements ActionListener{
    Choice roll, sem;
    JButton submit,cancel;
    JTextField sub1,sub2,sub3,sub4,sub5,mar1,mar2,mar3,mar4,mar5;
    Exams(){
        setSize(1000,500);
        setLocation(300,150);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,40,400,400);
        add(image);
        JLabel heading = new JLabel("Marks");
        heading.setBounds(5,10,100,30);
        heading.setFont(new Font("arial",Font.ITALIC,20));
        add(heading);
        JLabel rollno = new JLabel("Search by Regno");
        rollno.setBounds(25,50,200,40);
        add(rollno);
        roll = new Choice();
        roll.setBounds(225,55,200,20);
        add(roll);
        try{
            Conn c = new Conn();
            ResultSet rs=c.s.executeQuery("select * from student");
            while(rs.next()){
                roll.add(rs.getString("reg"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        JLabel sems = new JLabel("Semester");
        sems.setBounds(25,90,150,40);
        add(sems);
        sem = new Choice();
        sem.setBounds(225,100,150,20);
        sem.add("Sem 1");
        sem.add("Sem 2");
        sem.add("Sem 3");
        sem.add("Sem 4");
        sem.add("Sem 5");
        sem.add("Sem 6");
        sem.add("Sem 7");
        sem.add("Sem 8");
        add(sem);
        JLabel  sub = new JLabel("Subject");
        sub.setBounds(65,150,100,40);
        add(sub);
         sub1 = new JTextField();
        sub1.setBounds(20,210,150,20);
        add(sub1);
         sub2 = new JTextField();
        sub2.setBounds(20,240,150,20);
        add(sub2);
         sub3 = new JTextField();
        sub3.setBounds(20,270,150,20);
        add(sub3);
         sub4 = new JTextField();
        sub4.setBounds(20,300,150,20);
        add(sub4);
         sub5 = new JTextField();
        sub5.setBounds(20,330,150,20);
        add(sub5);
        JLabel marks = new JLabel("Marks");
        marks.setBounds(220,150,100,40);
        add(marks);
         mar1 = new JTextField();
        mar1.setBounds(180,210,150,20);
        add(mar1);
         mar2 = new JTextField();
        mar2.setBounds(180,240,150,20);
        add(mar2);
         mar3 = new JTextField();
        mar3.setBounds(180,270,150,20);
        add(mar3);
         mar4 = new JTextField();
        mar4.setBounds(180,300,150,20);
        add(mar4);
         mar5 = new JTextField();
        mar5.setBounds(180,330,150,20);
        add(mar5);
        submit = new JButton("Submit");
        submit.setBounds(50,370,100,30);
        submit.addActionListener(this);
        add(submit);
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        cancel.setBounds(200,370,100,30);
        add(cancel);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            try{
             Conn c = new Conn();
             String query1 = "insert into subject values('"+roll.getSelectedItem()+"','"+sem.getSelectedItem()+"','"+sub1.getText()+"','"+sub2.getText()+"','"+sub3.getText()+"','"+sub4.getText()+"','"+sub5.getText()+"')";
             String query2 = "insert into marks values('"+roll.getSelectedItem()+"','"+sem.getSelectedItem()+"','"+mar1.getText()+"','"+mar2.getText()+"','"+mar3.getText()+"','"+mar4.getText()+"','"+mar5.getText()+"')";
             c.s.executeUpdate(query1);
             c.s.executeUpdate(query2);
             JOptionPane.showMessageDialog(null,"Successful");
             setVisible(false);
            
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new Exams();
    }
}   