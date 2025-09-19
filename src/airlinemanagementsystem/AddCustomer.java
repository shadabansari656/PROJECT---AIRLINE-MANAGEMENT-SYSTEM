package airlinemanagementsystem;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{

    JTextField tfname,tfphno,tfaadhar,tfnation,tfaddress,tfemail;
    JRadioButton rbmale,rbfemale;
    
    public AddCustomer() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(240,20,500,35);
        heading.setFont(new Font("Tohama", Font.BOLD, 32));
        heading.setForeground(Color.darkGray);
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,80,150,25);
        lblname.setFont(new Font("Tohama", Font.PLAIN, 16));
        lblname.setForeground(Color.darkGray);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(220, 80, 150, 25);
        add(tfname);
        
        JLabel lblnation = new JLabel("Nationality");
        lblnation.setBounds(60,130,150,25);
        lblnation.setFont(new Font("Tohama", Font.PLAIN, 16));
        lblnation.setForeground(Color.darkGray);
        add(lblnation);
        
        tfnation = new JTextField();
        tfnation.setBounds(220, 130, 150, 25);
        add(tfnation);
        
        JLabel lblaadhar = new JLabel("Aadhar");
        lblaadhar.setBounds(60,180,150,25);
        lblaadhar.setFont(new Font("Tohama", Font.PLAIN, 16));
        lblaadhar.setForeground(Color.darkGray);
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 180, 150, 25);
        add(tfaadhar);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60,230,150,25);
        lbladdress.setFont(new Font("Tohama", Font.PLAIN, 16));
        lbladdress.setForeground(Color.darkGray);
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220, 230, 150, 25);
        add(tfaddress);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,280,150,25);
        lblgender.setFont(new Font("Tohama", Font.PLAIN, 16));
        lblgender.setForeground(Color.darkGray);
        add(lblgender);
        
        ButtonGroup btngroup = new ButtonGroup();
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(220, 280,70, 25);
        rbmale.setBackground(Color.WHITE);
        rbmale.setFocusPainted(false);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300, 280,70, 25);
        rbfemale.setBackground(Color.WHITE);
        rbfemale.setFocusPainted(false);
        add(rbfemale);
        
        btngroup.add(rbmale);
        btngroup.add(rbfemale);
        
        JLabel lblphno = new JLabel("Phone");
        lblphno.setBounds(60,330,150,25);
        lblphno.setFont(new Font("Tohama", Font.PLAIN, 16));
        lblphno.setForeground(Color.darkGray);
        add(lblphno);
        
        tfphno = new JTextField();
        tfphno.setBounds(220, 330, 150, 25);
        add(tfphno);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(60,380,150,25);
        lblemail.setFont(new Font("Tohama", Font.PLAIN, 16));
        lblemail.setForeground(Color.darkGray);
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(220, 380, 150, 25);
        add(tfemail);
        
        JButton save = new JButton("SAVE");
        save.setBounds(220,430,150,30);
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.addActionListener(this);
        save.setFocusPainted(false);
        add(save);
        
        ImageIcon image = new ImageIcon(getClass().getResource("/Images/emp.png"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(450,80,280,400);
        add(lblimage);
        
        setSize(900,600);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String nation = tfnation.getText();
        String phone = tfphno.getText();
        String address = tfaddress.getText();
        String aadhar = tfaadhar.getText();
        String email = tfemail.getText();
        String gender = null;
        if(rbmale.isSelected()) {
            gender = "Male";
        } else {
            gender = "Female";
        }
        
        if(name.equals("")||nation.equals("")||phone.equals("")||address.equals("")||aadhar.equals("")||gender.equals("")||email.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all fields before saving!");
        } else {
        try {
            Conn conn = new Conn();
            
            String query = "insert into passenger values('"+name+"','"+nation+"','"+phone+"','"+address+"','"+aadhar+"','"+gender+"','"+email+"')";
            
            int rows = conn.s.executeUpdate(query); 
            if(rows > 0) {
                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
            } else {
            JOptionPane.showMessageDialog(null, "Customer Details Not Added!");
            } 
            setVisible(false);
           
    } catch (Exception e) {
            e.printStackTrace();
        }
      }  
    }
    public static void main(String args[]) {
        new AddCustomer();
    }
}
