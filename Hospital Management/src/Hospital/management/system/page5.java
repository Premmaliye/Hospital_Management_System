package Hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class page5 extends JFrame {
    JTable table;
    JLabel t1,t2,t3,t4,t5,t6;
    JButton btn;
    page5(){

        table=new JTable();
        table.setBounds(40,70,1400,200);
        table.setFont(new Font("Thoma",Font.BOLD,15));
        table.setBackground(new Color(0x634795));
        add(table);

        try {
            connecton con=new connecton();
            String q="select * from emp";
            ResultSet resultSet=con.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }
        t1=new JLabel("Name");
        t1.setBounds(100,35,100,30);
        t1.setFont(new Font("Thoma",Font.BOLD,22));
        add(t1);
        t2=new JLabel("Age");
        t2.setBounds(340,35,100,30);
        t2.setFont(new Font("Thoma",Font.BOLD,22));
        add(t2);
        t3=new JLabel("Phone no.");
        t3.setBounds(540,35,180,30);
        t3.setFont(new Font("Thoma",Font.BOLD,22));
        add(t3);
        t4=new JLabel("Salary");
        t4.setBounds(800,35,100,30);
        t4.setFont(new Font("Thoma",Font.BOLD,22));
        add(t4);
        t5=new JLabel("Gmail");
        t5.setBounds(1050,35,100,30);
        t5.setFont(new Font("Thoma",Font.BOLD,22));
        add(t5);
        t6=new JLabel("Adhar No.");
        t6.setBounds(1250,35,150,30);
        t6.setFont(new Font("Thoma",Font.BOLD,22));
        add(t6);

        btn=new JButton("Cancel");
        btn.setBounds(650,450,150,30);
        btn.setBackground(new Color(0x89D73B));
        add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });





        setUndecorated(true);
        setSize(1540,700);
        setLocation(0,210);
        getContentPane().setBackground(new Color(0x634795));
        setLayout(null);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        page5 p=new page5();
    }
}
