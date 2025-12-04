package Hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;


public class page6 extends JFrame {
    Choice choice;
    JLabel t1,t2,t3,t4,t5,t6;
    Date d1;
    JButton btn1,btn2,btn3;
    page6(){

        t1=new JLabel("ID");
        t1.setBounds(350,20,50,20);
        t1.setFont(new Font("Thoma",Font.BOLD,15));
        add(t1);







        choice =new Choice();
        choice.setBounds(500,20,200,20);
        add(choice);
        try {
            connecton con=new connecton();

            ResultSet resultSet=con.statement.executeQuery("select * from patient_info2");
            if (resultSet.next()){
                choice.add(resultSet.getString("number"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        t2=new JLabel("Room No:");
        t2.setBounds(350,70,150,20);
        t2.setFont(new Font("Thoma",Font.BOLD,15));
        add(t2);
        t3=new JLabel("In Time:");
        t3.setBounds(350,120,150,20);
        t3.setFont(new Font("Thoma",Font.BOLD,15));
        add(t3);

        t4=new JLabel("Out Time:");
        t4.setBounds(350,170,150,20);
        t4.setFont(new Font("Thoma",Font.BOLD,15));
        add(t4);

        Date d1=new Date();

        JLabel dat=new JLabel(""+d1);
        dat.setBounds(500,170,250,20);
        dat.setFont(new Font("Thoma",Font.BOLD,15));
        add(dat);
        btn1=new JButton("Discharge");
        btn1.setBounds(360,250,100,25);
        btn1.setBackground(new Color(0x89D73B));
        add(btn1);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connecton connecton=new connecton();
                try {
                    connecton.statement.executeUpdate("delete from patient_info2 where number='"+choice.getSelectedItem()+"'");
                    connecton.statement.executeUpdate("Update Room set Avali ='Available' where room_no='"+choice.getSelectedItem()+"'");
                    JOptionPane.showMessageDialog(null,"Update");

                }catch (Exception c){
                    c.printStackTrace();
                }
            }
        });

        t5=new JLabel("xxxxxxxxxx");
        t5.setBounds(500,70,150,20);
        t5.setFont(new Font("Thoma",Font.BOLD,15));
        add(t5);
        t6=new JLabel("xxxxxxxxxx");
        t6.setBounds(500,120,250,20);
        t6.setFont(new Font("Thoma",Font.BOLD,15));
        add(t6);

        btn2=new JButton("Check");
        btn2.setBounds(550,250,100,25);
        btn2.setBackground(new Color(0x89D73B));
        add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connecton con=new connecton();
                try {

                    ResultSet resultSet = con.statement.executeQuery("select * from Patient_info2 where number='" + choice.getSelectedItem() + "'");
                    while (resultSet.next()) {
                        t5.setText(resultSet.getString("roomno"));
                        t6.setText(resultSet.getString("Time"));


                    }
                }catch (Exception f){
                    f.printStackTrace();
                }

            }
        });
        btn3=new JButton("Back");
        btn3.setBounds(750,250,100,25);
        btn3.setBackground(new Color(0x89D73B));
        add(btn3);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });







        setSize(1200,600);
        setLocation(200,200);
        setBackground(new Color(0x634795));
        setUndecorated(true);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        page6 p=new page6();

    }
}
