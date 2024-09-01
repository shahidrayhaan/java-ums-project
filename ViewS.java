
package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;



public class ViewS extends JFrame implements ActionListener{
    Choice croll;
    JTable table;
    JButton ssearch,print,update,add,cancel;
    
    ViewS(){
        setSize(900,700);
        setLayout(null);
        setLocation(350,100);
    
        JLabel search = new JLabel("Search by Reg");
        search.setBounds(20,20,150,20);
        add(search);
        croll = new Choice();
        croll.setBounds(170,20,150,20);
        add(croll);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()){
                croll.add(rs.getString("reg"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        table = new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        ssearch = new JButton("Search");
        ssearch.setBounds(20,70,80,20);
        ssearch.addActionListener(this);
        add(ssearch);
        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        add = new JButton("Add");
        add.setBounds(220,70,80,20);
        add.addActionListener(this);
        add(add);
        update = new JButton("Update");
        update.setBounds(320,70,80,20);
        update.addActionListener(this);
        add(update);
        cancel = new JButton("Cancel");
        cancel.setBounds(420,70,80,20);
        cancel.addActionListener(this);
        add(cancel);
        
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == ssearch){
            String query = "select * from student where reg='"+croll.getSelectedItem()+"'";
            try{
                Conn c = new Conn();
                ResultSet rs =c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == print){
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() ==add){
            setVisible(false);
            new Add();
        }else if(ae.getSource() == update){
            setVisible(false);
            //new UpdateStudent();
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new ViewS();
        
    }

    
    
}
