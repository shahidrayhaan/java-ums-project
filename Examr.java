package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
public class Examr extends JFrame implements ActionListener{
    JTextField rolls;
    JButton search,cancel;
    JTable table;
    Examr(){
        setSize(750,600);
        setLocation(300,150);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        JLabel heading = new JLabel("Results");
        heading.setBounds(5,10,150,40);
        heading.setFont(new Font("arial",Font.ITALIC,20));
        add(heading);
        JLabel roll = new JLabel("Search by Reg");
        roll.setBounds(5,60,200,30);
        add(roll);
        rolls = new JTextField();
        rolls.setBounds(215,60,100,20);
        add(rolls);
        search = new JButton("Search");
        search.setBounds(330,60,75,20);
        search.addActionListener(this);
        add(search);
        cancel = new JButton("Cancel");
        cancel.setBounds(415,60,75,20);
        cancel.addActionListener(this);
        add(cancel);
        table = new JTable();
        try{
            Conn c = new Conn();
            ResultSet rs=c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,1000,800);
        add(jsp);
        
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                int row = table.getSelectedRow();
                rolls.setText(table.getModel().getValueAt(row, 2).toString());
            }
        });
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
          new Results(rolls.getText());
          setVisible(false);
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new Examr();
    }
}