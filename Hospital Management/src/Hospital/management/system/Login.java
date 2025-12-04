package Hospital.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.sql.ResultSet;
import javax.swing.SwingUtilities;


 public class Login extends JFrame implements ActionListener {

    JButton btn1,btn2;
    JTextField edit1,pass;
    JPasswordField passww;
    Login() {
        setSize(800, 400);
        setLocation(400, 210);

        JLabel txt1 = new JLabel("Username:");
        txt1.setBounds(150, 110, 200, 20);
        txt1.setFont(new Font("Thoma", Font.BOLD, 15));
        add(txt1);

        JLabel txt2 = new JLabel("Password:");
        txt2.setBounds(150, 160, 200, 20);
        txt2.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(txt2);

        edit1 = new JTextField();
        edit1.setBounds(250, 110, 150, 25);
        edit1.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(edit1);

        passww = new JPasswordField();
        passww.setBounds(250, 160, 150, 25);
        passww.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(passww);

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("Icon/doctoricon.png"));
        Image i1 = icon1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(500, 60, 250, 200);
        add(label);

//        JButton btn1 = new JButton("Login");
//        btn1.setBounds(150, 240, 100, 30);
//        btn1.addActionListener(this);
//        add(btn1);
        btn1 =new JButton("Login");
        btn1.setBounds(150, 240, 100, 30);
        btn1.addActionListener(this);
        add(btn1);

         btn2 = new JButton("Cancel");
        btn2.setBounds(350, 240, 100, 30);
        btn2.addActionListener(this);
        add(btn2);


//        JLabel background=new JLabel(new ImageIcon("Icon/img1.jpg"));
//        add(background);
        getContentPane().setBackground(new Color(149, 150, 147));
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1 ){
            try{
                    connecton conn=new connecton();
                    String user= edit1.getText();
                    String passw= passww.getText();

                    String q="select * from login where ID='"+user+"' and PW='"+passw+"' ";
                    ResultSet resultSet= conn.statement.executeQuery(q);

                if (resultSet.next()){
                    new Page2();
                    setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid");
                }

            }catch (Exception E){
                 E.printStackTrace();
            }
        }else {
            System.exit(10);
        }

    }


    public static void main(String[] args) {
        Login log=new Login();
    }


}