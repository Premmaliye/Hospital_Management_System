package Hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class page7 extends JFrame {

    JLabel t1,t2,t3,t4,t5,t6,t7,l1,l2,l3,l4,l5,l6,T1;
    page7(){

        T1=new JLabel("Enter ID");
        T1.setBounds(530,50,150,25);
        T1.setFont(new Font("Thoma",Font.BOLD,20));
        add(T1);
        Choice choice=new Choice();
        choice.setBounds(500,80,150,25);
        add(choice);

        try {
            connecton c=new connecton();
            ResultSet resultSet=c.statement.executeQuery("select * from patient_info2");
            while (resultSet.next()){
                choice.add(resultSet.getString("number"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        JButton btn=new JButton("Check");
        btn.setBounds(800,80,150,24);
        btn.setFont(new Font("Thoma",Font.BOLD,15));
        btn.setBackground(new Color(0x89D73B));
        add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connecton connecton=new connecton();
                try {


                    ResultSet resultSet = connecton.statement.executeQuery("select * from Patient_info2 where number='" + choice.getSelectedItem() + "'");
                    while (resultSet.next()){
                        l1.setText(resultSet.getString("name"));
                        l2.setText(resultSet.getString("gender"));
                        l3.setText(resultSet.getString("disease"));
                        l4.setText(resultSet.getString("Time"));
                        l5.setText(resultSet.getString("Deposit"));
                        l6.setText(resultSet.getString("roomno"));

                    }
                }catch (Exception f){
                    f.printStackTrace();
                }
            }
        });

        t1=new JLabel("Name:");
        t1.setBounds(400,180,150,25);
        t1.setFont(new Font("Thoma",Font.BOLD,20));
        add(t1);
        t2=new JLabel("Gender:");
        t2.setBounds(400,230,150,25);
        t2.setFont(new Font("Thoma",Font.BOLD,20));
        add(t2);
        t3=new JLabel("Diseas:");
        t3.setBounds(400,280,150,25);
        t3.setFont(new Font("Thoma",Font.BOLD,20));
        add(t3);
        t4=new JLabel("Date:");
        t4.setBounds(400,330,150,25);
        t4.setFont(new Font("Thoma",Font.BOLD,20));
        add(t4);
        t5=new JLabel("Deposit:");
        t5.setBounds(400,380,150,25);
        t5.setFont(new Font("Thoma",Font.BOLD,20));
        add(t5);
        t6=new JLabel("Room:");
        t6.setBounds(400,430,150,25);
        t6.setFont(new Font("Thoma",Font.BOLD,20));
        add(t6);

        l1=new JLabel("xxxxxxxxxxx");
        l1.setBounds(600,180,150,25);
        l1.setFont(new Font("Thoma",Font.BOLD,20));
        add(l1);
        l2=new JLabel("xxxxxxxxxxx");
        l2.setBounds(600,230,150,25);
        l2.setFont(new Font("Thoma",Font.BOLD,20));
        add(l2);
        l3=new JLabel("xxxxxxxxxxx");
        l3.setBounds(600,280,150,25);
        l3.setFont(new Font("Thoma",Font.BOLD,20));
        add(l3);
        l4=new JLabel("xxxxxxxxxxx");
        l4.setBounds(600,330,350,25);
        l4.setFont(new Font("Thoma",Font.BOLD,20));
        add(l4);
        l5=new JLabel("xxxxxxxxxxx");
        l5.setBounds(600,380,150,25);
        l5.setFont(new Font("Thoma",Font.BOLD,20));
        add(l5);
        l6=new JLabel("xxxxxxxxxxx");
        l6.setBounds(600,430,150,25);
        l6.setFont(new Font("Thoma",Font.BOLD,20));
        add(l6);

        JButton btn1=new JButton("Back");
        btn1.setBounds(500,600,150,24);
        btn1.setFont(new Font("Thoma",Font.BOLD,15));
        btn1.setBackground(new Color(0x89D73B));
        add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });








        setSize(1540,820);
        setLocation(0,0);

        setUndecorated(true);

        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    public static void main(String[] args) {
        page7 p=new page7();
    }
}
