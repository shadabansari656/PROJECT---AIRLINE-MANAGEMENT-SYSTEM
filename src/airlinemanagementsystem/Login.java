package airlinemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JButton reset,submit,close; 
    JTextField tfusername; 
    JPasswordField tfpassword; 
    
    public Login() { 
        getContentPane().setBackground(Color.WHITE); 
        setLayout(null); 
        
        JLabel lblusername = new JLabel("Username"); 
        lblusername.setBounds(20, 20, 100, 20);
        add(lblusername); 
        
        tfusername = new JTextField(); 
        tfusername.setBounds(130, 20, 200, 20); 
        add(tfusername); 
        
        JLabel lblpassword = new JLabel("Password"); 
        lblpassword.setBounds(20, 60, 100, 20); 
        add(lblpassword); 
        
        tfpassword = new JPasswordField(); 
        tfpassword.setBounds(130, 60,200,20); 
        add(tfpassword); 
        
        reset = new JButton("Reset"); 
        reset.setBounds(60,120,120,25); 
        reset.addActionListener(this); 
        reset.setBackground(Color.DARK_GRAY);
        reset.setForeground(Color.WHITE);
        reset.setFocusPainted(false);
        add(reset); 
        
        submit = new JButton("Submit"); 
        submit.setBounds(200,120,120,25); 
        submit.addActionListener(this);
        submit.setBackground(Color.DARK_GRAY);
        submit.setForeground(Color.WHITE);
        submit.setFocusPainted(false);
        add(submit); 
        getRootPane().setDefaultButton(submit);
        
        close = new JButton("close"); 
        close.setBounds(120,160,120,25); 
        close.addActionListener(this); 
        close.setBackground(Color.DARK_GRAY);
        close.setForeground(Color.WHITE);
        close.setFocusPainted(false);
        add(close); 
        
        setSize(400, 250); 
        setLocation(600, 250); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setVisible(true); 
    } 
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            try {
                Conn c = new Conn();
                
                String query = "Select * from login where username = '"+username+"' and password = '"+password+"'";
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()) {
                    new Home();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
//                    setVisible(false);
                }
                    
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else if (ae.getSource() == close) {
            setVisible(false);
        } else if (ae.getSource() == reset) {
            tfusername.setText("");
            tfpassword.setText("");
        }
    }

    public static void main(String[] args) { 
        new Login(); 
    } 
}

//package airlinemanagementsystem;
//
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.sql.*;
//
//public class Login extends JFrame implements ActionListener {
//
//    JButton reset, submit, close;
//    JTextField tfusername;
//    JPasswordField tfpassword;
//
//    public Login() {
//        setTitle("Airline Management System - Login");
//        setLayout(null);
//        setSize(500, 385);
//        setLocation(520, 220);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // ===== Background Image =====
//        ImageIcon bgIcon = new ImageIcon(getClass().getResource("/Images/bg.jpg"));
//        Image bgImg = bgIcon.getImage().getScaledInstance(500, 350, Image.SCALE_SMOOTH);
//        JLabel background = new JLabel(new ImageIcon(bgImg));
//        background.setBounds(0, 0, 500, 350);
//        setContentPane(background);
//        background.setLayout(null);
//
//        // ===== Logo =====
//        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/Images/logo.png"));
//        Image logoImg = logoIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
//        JLabel logo = new JLabel(new ImageIcon(logoImg));
//        logo.setBounds(210, 20, 60, 60);
//        background.add(logo);
//
//        // ===== Heading =====
//        JLabel heading = new JLabel("Airline Login");
//        heading.setFont(new Font("Arial", Font.BOLD, 26));
//        heading.setForeground(Color.WHITE);
//        heading.setBounds(160, 90, 200, 30);
//        background.add(heading);
//
//        // ===== Username Label =====
//        JLabel lblusername = new JLabel("Username");
//        lblusername.setFont(new Font("Arial", Font.BOLD, 16));
//        lblusername.setForeground(Color.WHITE);
//        lblusername.setBounds(100, 130, 100, 20);
//        background.add(lblusername);
//
//        tfusername = new JTextField();
//        tfusername.setBounds(200, 130, 200, 25);
//        background.add(tfusername);
//
//        // ===== Password Label =====
//        JLabel lblpassword = new JLabel("Password");
//        lblpassword.setFont(new Font("Arial", Font.BOLD, 16));
//        lblpassword.setForeground(Color.WHITE);
//        lblpassword.setBounds(100, 170, 100, 20);
//        background.add(lblpassword);
//
//        tfpassword = new JPasswordField();
//        tfpassword.setBounds(200, 170, 200, 25);
//        background.add(tfpassword);
//
//        // ===== Buttons =====
//        reset = new JButton("Reset");
//        styleButton(reset);
//        reset.setBounds(100, 220, 120, 30);
//        reset.addActionListener(this);
//        background.add(reset);
//
//        submit = new JButton("Submit");
//        styleButton(submit);
//        submit.setBounds(250, 220, 120, 30);
//        submit.addActionListener(this);
//        background.add(submit);
//
//        close = new JButton("Close");
//        styleButton(close);
//        close.setBounds(175, 270, 120, 30);
//        close.addActionListener(this);
//        background.add(close);
//
//        setVisible(true);
//    }
//
//    // ===== Button Styling =====
//    private void styleButton(JButton btn) {
//        btn.setBackground(new Color(0, 102, 204));
//        btn.setForeground(Color.WHITE);
//        btn.setFont(new Font("Arial", Font.BOLD, 14));
//        btn.setFocusPainted(false);
//    }
//
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == submit) {
//            String username = tfusername.getText();
//            String password = tfpassword.getText();
//            
//            try {
//                Conn c = new Conn();
//                
//                String query = "Select * from login where username = '"+username+"' and password = '"+password+"'";
//                ResultSet rs = c.s.executeQuery(query);
//                
//                if(rs.next()) {
//                    System.out.println("Valid");
//                    setVisible(false);
//                } else {
//                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
//                    setVisible(false);
//                }
//                    
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            
//        } else if (ae.getSource() == close) {
//            setVisible(false);
//        } else if (ae.getSource() == reset) {
//            tfusername.setText("");
//            tfpassword.setText("");
//        }
//    }
//
//    public static void main(String[] args) {
//        new Login();
//    }
//}
