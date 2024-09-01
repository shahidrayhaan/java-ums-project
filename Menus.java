package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Menus extends JFrame implements ActionListener{
    Menus(){
        setSize(1540,850);
        //menubar
        JMenuBar menu = new JMenuBar();
        //menu 
        JMenu information = new JMenu("Information");
        information.setForeground(Color.red);
        menu.add(information);
        //menu list
        //student info
        JMenuItem student = new JMenuItem("Student Information");
        student.addActionListener(this);
        information.add(student);
        //faculty info
        JMenuItem faculty = new JMenuItem("Faculty Information");
        faculty.addActionListener(this);
        information.add(faculty);
        //menu Details
        JMenu details = new JMenu("Details");
        details.setForeground(Color.blue);
        menu.add(details);
        //sTudent details
        JMenuItem sdetails = new JMenuItem("Student Details");
        sdetails.addActionListener(this);
        details.add(sdetails);
        //faculty details
        JMenuItem fdetails = new JMenuItem("Faculty Details");
        fdetails.addActionListener(this);
        details.add(fdetails);
        menu.add(details);
        //menu leave
        JMenu leave = new JMenu("Leave");
        leave.setForeground(Color.red);
        //itemlist
        JMenuItem sleave = new JMenuItem("Student Leave");
        sleave.addActionListener(this);
        leave.add(sleave);
        JMenuItem fleave = new JMenuItem("Faculty Leave");
        fleave.addActionListener(this);
        leave.add(fleave);
        menu.add(leave);
        //Menu leave details
        JMenu ldetails = new JMenu("Leave Details");
        ldetails.setForeground(Color.blue);
        //itemlist
        JMenuItem sldetails = new JMenuItem("Student Leave Details");
        ldetails.add(sldetails);
        sldetails.addActionListener(this);
        JMenuItem fldetails = new JMenuItem("Faculty Leave Details");
        ldetails.add(fldetails);
        fldetails.addActionListener(this);
        menu.add(ldetails);
        //menu
        JMenu exams= new JMenu("Examination");
        exams.setForeground(Color.red);
        //items
        JMenuItem results = new JMenuItem("Exam Results");
        JMenuItem marks = new JMenuItem("Enter Marks");
        exams.add(results);
        exams.add(marks);
        marks.addActionListener(this);
        results.addActionListener(this);
        menu.add(exams);
        //update details
        JMenu update = new JMenu("Update Details");
        update.setForeground(Color.blue);
        //items
        JMenuItem ustudent= new JMenuItem("Update Student Details");
        JMenuItem ufaculty=new JMenuItem("Update Faculty Details");
        update.add(ustudent);
        ustudent.addActionListener(this);
        update.add(ufaculty);
        ufaculty.addActionListener(this);
        menu.add(update);
        //feee
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.red);
        //items
        JMenuItem fs = new JMenuItem("Fee Structure");
        JMenuItem ff = new JMenuItem("Fee Form");
        fee.add(fs);
        fee.add(ff);
        fs.addActionListener(this);
        ff.addActionListener(this);
        menu.add(fee);
        // utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.blue);
       //items
        JMenuItem Notepad = new JMenuItem("Notepad");
        Notepad.addActionListener(this);
        JMenuItem Calculator = new JMenuItem("Calculator");
        Calculator.addActionListener(this);
        utility.add(Notepad);
        utility.add(Calculator);
        menu.add(utility);
        //exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.red);
        JMenuItem exits = new JMenuItem("Exit");
        exits.addActionListener(this);
        exit.add(exits);
        menu.add(exit);
        setJMenuBar(menu);
        
        
        //images
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        add(i4);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
            String s1 = ae.getActionCommand();
            if(s1.equals("Exit")){
                setVisible(false);
            }else if(s1.equals("Notepad")){
                try{
                    Runtime.getRuntime().exec("notepad.exe");
                }catch (Exception e){
                    
                }
            }else if(s1.equals("Calculator")){
                try{
                     Runtime.getRuntime().exec("calc.exe");
                }catch(Exception e){
                    
                }
            }else if(s1.equals("Student Information")){
                new Add();
            }else if(s1.equals("Faculty Information")){
                new Addt();
            }else if(s1.equals("Student Details")){
                new ViewS();
            }else if(s1.equals("Faculty Details")){
                new Teacherdetails();
            }else if(s1.equals("Student Leave")){
                new Studentleave();
                
            }else if(s1.equals("Faculty Leave")){
                new Facultyleave();
            }else if(s1.equals("Student Leave Details")){
                new StudentleaveD();
                
            }else if(s1.equals("Faculty Leave Details")){
                new FacultyleaveD();
            }else if(s1.equals("Update Student Details")){
                new UpdateS();
            }else if(s1.equals("Update Faculty Details")){
                new UpdatefacultyD();
            }else if(s1.equals("Exam Results")){
                new Examr();
            }else if(s1.equals("Enter Marks")){
                new Exams();
            }else if(s1.equals("Fee Structure")){
                new Fees();
            }else{
                new Feef();
            }
        
    }
    public static void main(String[] args){
        new Menus();
        
    }

    

}