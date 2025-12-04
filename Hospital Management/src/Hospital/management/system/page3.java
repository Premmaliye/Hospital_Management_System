package Hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class page3 extends JFrame {
    JPanel panel;
    JTable table;
    page3(){

        table=new JTable();
        table.setBounds(100,60,700,300);
        table.setBackground(new Color(0x634795));
        table.setFont(new Font("Thoma",Font.BOLD,15));
        add(table);
        try {
            connecton c=new connecton();
            String q="select * from Room2";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }
        JLabel t1=new JLabel("Room no..");
        t1.setBounds(110,30,100,30);
        t1.setBackground(new Color(0xF1F6F6));
        t1.setFont(new Font("Thoma",Font.BOLD,18));
        add(t1);

        JLabel t2=new JLabel("Availability");
        t2.setBounds(300,30,100,30);
        t2.setBackground(new Color(0x9696B6));
        t2.setFont(new Font("Thoma",Font.BOLD,18));
        add(t2);
        JLabel t3=new JLabel("Price");
        t3.setBounds(490,30,100,30);
        t3.setBackground(new Color(0x9696B6));
        t3.setFont(new Font("Thoma",Font.BOLD,18));
        add(t3);
        JLabel t4=new JLabel("Room type");
        t4.setBounds(680,30,100,30);
        t4.setBackground(new Color(0x9696B6));
        t4.setFont(new Font("Thoma",Font.BOLD,18));
        add(t4);

        JButton btn=new JButton("Cancel");
        btn.setBounds(350,400,100,30);
        btn.setBackground(new Color(0x89D73B));
        btn.setFont(new Font("Thoma",Font.BOLD,18));
        add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                setVisible(false);
            }
        });



        setSize(900,600);
        setLayout(null);
        setLocation(300,200);
        getContentPane().setForeground(new Color(0xF6F6FC));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0x634795));
    }

    public static void main(String[] args) {
        page3 p=new page3();
    }
}
