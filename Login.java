package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login,cancel;
    JTextField write,input;
    Login(){
        getContentPane().setBackground(Color.red);
        setLayout(null);
        JLabel username = new JLabel("Username:");
        username.setForeground(Color.white);
        username.setFont(new Font("arial",Font.ITALIC,15));
        username.setBounds(40,20,100,30);
        add(username);
        write = new JTextField();
        write.setBounds(150,20,100,30);
        add(write);
        JLabel password = new JLabel("Password:");
        password.setForeground(Color.white);
        password.setFont(new Font("arial",Font.ITALIC,15));
        password.setBounds(40,70,100,30);
        add(password);
        input = new JPasswordField();
        input.setBounds(150,70,100,30);
        add(input);
        login = new JButton("Login");
        login.addActionListener(this);
        login.setBackground(Color.GREEN);
        login.setForeground(Color.white);
        login.setBounds(40,140,120,30);
        add(login);
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        cancel.setBackground(Color.green);
        cancel.setForeground(Color.white);
        cancel.setBounds(180,140,120,30);
        add(cancel);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);
        setLocation(500,250);
        setSize(600,300);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            String username = write.getText();
            String password = input.getText();
            
            String query = "select * from login where username='"+username+"'and password='"+password+"'";
            try{
                Conn c = new Conn();
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Menus();
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                    setVisible(false);
                 }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==cancel){
            setVisible(false);
            
        }
        
    }
    public static void main(String[] args){
        new Login();
    }

    
    
}