package Hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Addnewpa extends JFrame implements ActionListener {

    JLabel t2,t1,t3,t4,t5,t6,t7;
    JTextField number,name,dis,despo;
    JComboBox com;
    JLabel date;
    Choice c1;
    JRadioButton rbtn1,rbtn2;
    JButton btn1,btn2;

    Addnewpa(){

        t2=new JLabel("NEW PATIENT FORM");
        t2.setFont(new Font("Tahoma",Font.BOLD,30));
        t2.setBounds(550,30,500,50);
        add(t2);

        t1=new JLabel("ID:");
        t1.setFont(new Font("Tahoma",Font.BOLD,15));
        t1.setBounds(550,130,100,20);
        add(t1);

        com=new JComboBox(new String[]{"Adhar Card","Voter Id","PAN Card"});
        com.setBounds(750,130,200,20);
        add(com);

        t3=new JLabel("Number:");
        t3.setFont(new Font("Tahoma",Font.BOLD,15));
        t3.setBounds(550,180,100,20);
        add(t3);

        number=new JTextField();
        number.setBounds(750,180,200,20);
        add(number);

        t4=new JLabel("Name:");
        t4.setFont(new Font("Tahoma",Font.BOLD,15));
        t4.setBounds(550,230,100,20);
        add(t4);

        name=new JTextField();
        name.setBounds(750,230,200,20);
        add(name);

        t5=new JLabel("Gender:");
        t5.setFont(new Font("Tahoma",Font.BOLD,15));
        t5.setBounds(550,280,100,20);
        add(t5);

        rbtn1=new JRadioButton("Male");
        rbtn1.setBounds(750,280,100,30);
        rbtn1.setFont(new Font("Tahoma",Font.BOLD,15));
        rbtn1.setBackground(new Color(0x56947B));
        add(rbtn1);

        rbtn2=new JRadioButton("Female");
        rbtn2.setBounds(850,280,200,30);
        rbtn2.setFont(new Font("Tahoma",Font.BOLD,15));
        rbtn2.setBackground(new Color(0x56947B));
        add(rbtn2);

        t4=new JLabel("Desieas:");
        t4.setFont(new Font("Tahoma",Font.BOLD,15));
        t4.setBounds(550,330,100,20);
        add(t4);

        dis=new JTextField();
        dis.setBounds(750,330,200,20);
        add(dis);
        t5=new JLabel("Date:");
        t5.setFont(new Font("Tahoma",Font.BOLD,15));
        t5.setBounds(550,380,100,20);
        add(t5);

        Date d1=new Date();

        date=new JLabel(""+d1);
        date.setFont(new Font("Tahoma",Font.BOLD,15));
        date.setBounds(750,380,300,20);
        add(date);

        t6=new JLabel("Deposit:");
        t6.setFont(new Font("Tahoma",Font.BOLD,15));
        t6.setBounds(550,430,100,20);
        add(t6);
        despo=new JTextField();
        despo.setBounds(750,430,200,20);
        add(despo);

        t7=new JLabel("Room:");
        t7.setFont(new Font("Tahoma",Font.BOLD,15));
        t7.setBounds(550,480,100,20);
        add(t7);

        c1=new Choice();
        try {
            connecton c=new connecton();
            ResultSet resultSet=c.statement.executeQuery("select * from Room2");
            while (resultSet.next()){
                c1.add(resultSet.getString("room_no"));
            }
        }catch (Exception e){
            e.printStackTrace();;
        }
        c1.setBounds(750,480,100,20);
        c1.setFont(new Font("Tahoma",Font.BOLD,15));
        add(c1);

        btn1=new JButton("ADD");
        btn1.setFont(new Font("Tahoma",Font.BOLD,15));
        btn1.setBounds(580,550,100,20);
        btn1.addActionListener(this);
        add(btn1);

        btn2=new JButton("Cancel");
        btn2.setFont(new Font("Tahoma",Font.BOLD,15));
        btn2.setBounds(790,550,100,20);
        add(btn2);

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Page2 p=new Page2();
                setVisible(false);
            }
        });
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("Icon/img3.png"));
        Image i1 = icon1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(1000, 100, 450, 400);
        add(label);








        setSize(1540,820);
        setLayout(null);
        setBackground(new Color(0x634795));
        setVisible(true);
       setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       getContentPane().setBackground(new Color(0x56947B));
    }


    public static void main(String[] args) {
        Addnewpa add=new Addnewpa();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn1){
            connecton d=new connecton();
            String radio=null;
            if (rbtn1.isSelected()){
                radio="Male";
            }else if (rbtn2.isSelected()){
                    radio="Female";
            }
            String s1=(String)com.getSelectedItem();
            String s2=number.getText();
            String s3=name.getText();
            String s4=radio;
            String s5=dis.getText();
            String s6=date.getText();
            String s7=despo.getText();
            String s8=c1.getSelectedItem();

            try {
                String q= "insert into patient_info2 values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                String q1= "update room set Avali ='Occupied' where room_no ="+s8;
                d.statement.executeUpdate(q);
                d.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Add");
                setVisible(true);
            }catch (Exception f){
                f.printStackTrace();
            }
        }else {
            setVisible(false);
        }


    }
}
