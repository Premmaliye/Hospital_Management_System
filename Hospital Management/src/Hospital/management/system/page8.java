package Hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import static javax.swing.JOptionPane.*;

public class page8 extends JFrame {
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2,b3;
    page8(){

        l1=new JLabel("Update Patient Detail");
        l1.setBounds(100,30,400,40);
        l1.setFont(new Font("Thomas",Font.BOLD,30));
        add(l1);


        l2=new JLabel("Name:");
        l2.setBounds(100,120,100,25);
        l2.setFont(new Font("Thomas",Font.BOLD,18));
        add(l2);
        Choice c1=new Choice();
        c1.setBounds(400,120,200,25);
        c1.setFont(new Font("Thomas",Font.BOLD,18));
        add(c1);

        try {
            connecton c2=new connecton();
            ResultSet resultSet=c2.statement.executeQuery("select * from patient_info2");
            while (resultSet.next()){
                c1.add(resultSet.getString("name"));
            }

        }catch (Exception E){
            E.printStackTrace();
        }
        l3=new JLabel("Room No:");
        l3.setBounds(100,170,100,25);
        l3.setFont(new Font("Thomas",Font.BOLD,18));
        add(l3);
        t2=new JTextField("");
        t2.setBounds(400,170,200,25);
        t2.setFont(new Font("Thomas",Font.BOLD,18));
        add(t2);
        l4=new JLabel("In Time:");
        l4.setBounds(100,220,100,25);
        l4.setFont(new Font("Thomas",Font.BOLD,18));
        add(l4);
        t3=new JTextField("");
        t3.setBounds(400,220,200,25);
        t3.setFont(new Font("Thomas",Font.BOLD,18));
        add(t3);


        l5=new JLabel("Amount Paid:");
        l5.setBounds(100,270,300,25);
        l5.setFont(new Font("Thomas",Font.BOLD,18));
        add(l5);
        t4=new JTextField("");
        t4.setBounds(400,270,200,25);
        t4.setFont(new Font("Thomas",Font.BOLD,18));
        add(t4);

        l6=new JLabel("Pending Amount:");
        l6.setBounds(100,330,300,25);
        l6.setFont(new Font("Thomas",Font.BOLD,18));
        add(l6);
        t5=new JTextField("");
        t5.setBounds(400,330,200,25);
        t5.setFont(new Font("Thomas",Font.BOLD,18));
        add(t5);

        b1=new JButton("Check");
        b1.setBounds(100,420,150,25);
        b1.setBackground(new Color(0x89D73B));
        b1.setFont(new Font("Thomas",Font.BOLD,18));
        add(b1);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connecton c = new connecton();
                try {


                    ResultSet resultSet = c.statement.executeQuery("select * from patient_info2 where name='"+c1.getSelectedItem()+"'");
                    while (resultSet.next()){
                        t2.setText(resultSet.getString("roomno"));
                        t3.setText(resultSet.getString("Time"));
                        t4.setText(resultSet.getString("deposit"));

                    }
                    ResultSet resultSet2=c.statement.executeQuery("select * from Room where room_no='"+t2.getText()+"'");
                    while (resultSet2.next()){
                        String price=resultSet2.getString("price");
                        int paid= Integer.parseInt(price)- Integer.parseInt(t4.getText());
                        t5.setText(""+paid);
                    }
                }catch (Exception s){
                    s.printStackTrace();
                }


            }
        });
        b2=new JButton("Update");
        b2.setBounds(300,420,150,25);
        b2.setBackground(new Color(0x89D73B));
        b2.setFont(new Font("Thomas",Font.BOLD,18));
        add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connecton c3=new connecton();
                try {
                    String q=c1.getSelectedItem();
                    String v=t2.getText();
                    String v1=t3.getText();
                    String v2=t4.getText();
                    String v3=t5.getText();


                    c3.statement.executeUpdate("update patient_info2 set roomno='"+v+"',Time='"+v2+"',Deposit='"+v3+"' where name='"+q+"' ");

                    showMessageDialog(null,"Update");
                    setVisible(true);
                }catch (Exception z){
                    z.printStackTrace();
                }
            }
        });
        b3=new JButton("Cancel");
        b3.setBounds(500,420,150,25);
        b3.setBackground(new Color(0x89D73B));
        b3.setFont(new Font("Thomas",Font.BOLD,18));
        add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Page2 p=new Page2();
                setVisible(false);
            }
        });









        setSize(1200,600);
        setLocation(150,200);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        page8 p=new page8();

    }
}
