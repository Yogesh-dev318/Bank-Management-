import connection.conn;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class Login extends JFrame implements ActionListener {
    JLabel l2, l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1, b2, b3;
    Login() {
        setTitle("Smart Bank");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("project photo/smartbanklogo.png"));
        Image i2 = i1.getImage().getScaledInstance(125, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(50, 10, 125, 100);
        add(l11);

        JLabel l1 = new JLabel("Welcome to SmartBank");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(200, 40, 500, 40);
        add(l1);

        l2 = new JLabel("Account No:");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(125, 150, 375, 30);
        add(l2);

        l3 = new JLabel("PIN:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(125, 220, 375, 30);
        add(l3);

        tf1 = new JTextField();
        tf1.setBounds(300, 150, 230, 30);
        tf1.setFont(new Font("Arial", Font.BOLD, 20));
        add(tf1);

        pf2 = new JPasswordField();
        pf2.setFont(new Font("Arial", Font.BOLD, 20));
        pf2.setBounds(300, 220, 230, 30);
        add(pf2);

        b1 = new JButton("SIGN IN");
        b1.setForeground(Color.BLACK);

        b2 = new JButton("CLEAR");
        b2.setForeground(Color.BLACK);

        b3 = new JButton("SIGN UP");
        b3.setForeground(Color.BLACK);

        setLayout(null);

        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(300, 300, 100, 30);
        add(b1);

        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(430, 300, 100, 30);
        add(b2);

        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(300, 350, 230, 30);
        add(b3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        getContentPane().setBackground(Color.GRAY);

        setSize(800, 480);
        setLocation(550, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try{
            if(ae.getSource()==b1){
                conn c1 = new conn();
                String cardno  = tf1.getText();
                String pin  = pf2.getText();
                String q  = "select * from login where cardno = '"+cardno+"' and pin = '"+pin+"'";

                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pin ).setVisible(true);
                } else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }else if(ae.getSource()==b2){
                tf1.setText("");
                pf2.setText("");
            }else if(ae.getSource()==b3){
                setVisible(false);
                new Signup().setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Login().setVisible(true);
    }
}