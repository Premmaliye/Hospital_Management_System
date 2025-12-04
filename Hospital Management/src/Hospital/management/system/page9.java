package Hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class page9 extends JFrame {
    page9(){



        JLabel l1=new JLabel("Room");
        l1.setBounds(100,30,400,40);
        l1.setFont(new Font("Thomas",Font.BOLD,30));
        add(l1);

        JLabel l2=new JLabel("Name:");
        l2.setBounds(100,90,100,20);
        l2.setFont(new Font("Thomas",Font.BOLD,15));
        add(l2);
        Choice c1=new Choice();
        c1.setBounds(400,90,200,20);
        c1.add("Available");
        c1.add("Unavailable");
        c1.add("");
        c1.setFont(new Font("Thomas",Font.BOLD,15));
        add(c1);

        JTable t1=new JTable();
        t1.setBounds(100,170,800,270);
        t1.setBackground(null);
        t1.setForeground(null);
        t1.setFont(new Font("Thomas",Font.BOLD,16));
        add(t1);
        try {
            connecton c=new connecton();
            ResultSet resultSet=c.statement.executeQuery("select * from Room2");
            t1.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JButton btn=new JButton("Search");
        btn.setBounds(100,450,150,24);
        btn.setFont(new Font("Thoma",Font.BOLD,15));
        btn.setBackground(new Color(0x89D73B));
        add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connecton c=new connecton();
                try {


                    ResultSet resultSet =c.statement.executeQuery("select * from Room2 where Avali ="+c1.getSelectedItem()+"'");
                    t1.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        JButton btn1=new JButton("Cancel");
        btn1.setBounds(300,450,150,24);
        btn1.setFont(new Font("Thoma",Font.BOLD,15));
        btn1.setBackground(new Color(0x89D73B));
        add(btn1);





        setSize(1200,600);
        setLocation(150,200);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        page9 p=new page9();
    }
}
