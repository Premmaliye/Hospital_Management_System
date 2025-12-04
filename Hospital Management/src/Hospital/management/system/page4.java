package Hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class page4 extends JFrame {
    JTable table;
    JLabel l1,l2;
    JButton btn;
    page4(){


        table=new JTable();
        table.setBounds(50,50,400,200);
        table.setFont(new Font("Thoma",Font.BOLD,15));
        add(table);
        try {
            connecton connecton=new connecton();
            String q="select * from department";
            ResultSet resultSet =connecton.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }
        l1=new JLabel("Department");
        l1.setBounds(65,20,200,30);
        l1.setFont(new Font("Thoma",Font.BOLD,22));
        add(l1);

        l2=new JLabel("Number");
        l2.setBounds(320,20,100,30);
        l2.setFont(new Font("Thoma",Font.BOLD,22));
        add(l2);

        btn=new JButton("Back");
        btn.setBounds(180,320,100,30);
        btn.setFont(new Font("Thoma",Font.BOLD,22));
        add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Page2 page2=new Page2();
                setVisible(false);
            }
        });

        setSize(800,500);
        setLocation(300,200);
        setBackground(new Color(0x634795));
        setUndecorated(true);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public static void main(String[] args) {

       page4 p=new  page4();
    }
}
