package Hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page2 extends JFrame {

    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;

    Page2(){
        JPanel pan=new JPanel();
        pan.setBounds(2,185,1540,720);
        pan.setBackground(new Color(0x634795));
        pan.setLayout(null);
        add(pan);


        JPanel pan2=new JPanel();
        pan2.setBounds(5,0,1540,180);
        pan2.setBackground(new Color(0x634795));
        pan2.setLayout(null);
        add(pan2);


        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("Icon/img2.png"));
        Image i1 = icon1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(1200, 10, 250, 200);
        pan2.add(label);

        b1=new JButton("Add new Paitent");
        b1.setBounds(80,40,150,25);
        b1.setBackground(new Color(0x89D73B));
        pan2.add(b1);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Addnewpa a=new Addnewpa();
                setVisible(false);
            }
        });

        b2=new JButton("Room");
        b2.setBounds(80,90,150,25);
        b2.setBackground(new Color(0x89D73B));
        pan2.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                page3 p3=new page3();

            }
        });

        b3=new JButton("Deparment");
        b3.setBounds(80,140,150,25);
        b3.setBackground(new Color(0x89D73B));
        pan2.add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                page4 p=new page4();
            }
        });

        b4=new JButton("All Empolye Info");
        b4.setBounds(290,40,150,25);
        b4.setBackground(new Color(0x89D73B));
        pan2.add(b4);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                page5 p5=new page5();
            }
        });

        b5=new JButton("Paicent Info");
        b5.setBounds(290,90,150,25);
        b5.setBackground(new Color(0x89D73B));
        pan2.add(b5);
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                page7 p7=new page7();
            }
        });

        b6=new JButton("paicent Discarge");
        b6.setBounds(290,140,150,25);
        b6.setBackground(new Color(0x89D73B));
        pan2.add(b6);
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                page6 p=new page6();
            }
        });

        b7=new JButton("Update Paicent Detail");
        b7.setBounds(500,40,150,25);
        b7.setBackground(new Color(0x89D73B));
        pan2.add(b7);

        b8=new JButton("Hospiatal Ambulance");
        b8.setBounds(500,90,150,25);
        b8.setBackground(new Color(0x89D73B));
        pan2.add(b8);

        b9=new JButton("search Room");
        b9.setBounds(500,140,150,25);
        b9.setBackground(new Color(0x89D73B));
        pan2.add(b9);

        b10=new JButton("Log Out");
        b10.setBounds(710,40,150,25);
        b10.setBackground(new Color(0x89D73B));
        pan2.add(b10);
        b10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login l=new Login();
            }
        });

        setSize(1540,820);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }
    public static void main(String[] args) {
        new Page2();
    }
}
