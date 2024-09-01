package university.management.system;
import javax.swing.*;
import java.awt.*;
public class About extends JFrame{
    About(){
        setSize(700,500);
        setLocation(400,150);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        JLabel heading = new JLabel("UniversityManagementSystem");
        heading.setBounds(70,20,350,40);
        heading.setFont(new Font("arial",Font.ITALIC,20));
        add(heading);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,300,200);
        add(image);
        JLabel Reg = new JLabel("Registration number:21BCE8004");
        Reg.setBounds(70,120,300,30);
        add(Reg);
        JLabel reg = new JLabel(" mail:msrayhaan999@gmail.com");
        reg.setBounds(70,200,550,30);
        add(reg);
       
        setVisible(true);
    }
 public static void main(String[] args){
     new About();
 }   
}