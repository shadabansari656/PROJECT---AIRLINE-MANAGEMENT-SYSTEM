package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Cancel extends JFrame implements ActionListener {

    JTextField tfpnr;
    JLabel tfname, tfcancellationno, tfflightcode, lbldateoftravel, tfsrc, tfdes;
    JButton fetchbutton, cancel;

    public Cancel() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        Random random = new Random();
        
        JLabel heading = new JLabel("CANCELLATION");
        heading.setBounds(250, 20, 250, 35);
        heading.setFont(new Font("Tohama", Font.BOLD, 32));
        heading.setForeground(Color.darkGray);
        add(heading);
        
        ImageIcon i1 = new ImageIcon(getClass().getResource("/Images/cancel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lblimage = new JLabel(i3);
        lblimage.setBounds(470, 130, 250, 250);
        add(lblimage);

        JLabel lblaadhar = new JLabel("PNR");
        lblaadhar.setBounds(60, 80, 150, 25);
        lblaadhar.setFont(new Font("Tohama", Font.PLAIN, 16));
        lblaadhar.setForeground(Color.darkGray);
        add(lblaadhar);
        

        tfpnr = new JTextField();
        tfpnr.setBounds(220, 80, 150, 25);
        add(tfpnr);

        fetchbutton = new JButton("Show Details");
        fetchbutton.setBackground(Color.BLACK);
        fetchbutton.setForeground(Color.WHITE);
        fetchbutton.setBounds(380, 80, 125, 25);
        fetchbutton.addActionListener(this);
        fetchbutton.setFocusPainted(false);
        add(fetchbutton);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 150, 25);
        lblname.setFont(new Font("Tohama", Font.PLAIN, 16));
        lblname.setForeground(Color.darkGray);
        add(lblname);

        tfname = new JLabel();
        tfname.setBounds(220, 130, 150, 25);
        add(tfname);

        JLabel lblcancellationno = new JLabel("Cancellation No");
        lblcancellationno.setBounds(60, 180, 150, 25);
        lblcancellationno.setFont(new Font("Tohama", Font.PLAIN, 16));
        lblcancellationno.setForeground(Color.darkGray);
        add(lblcancellationno);

        tfcancellationno = new JLabel(""+random.nextInt(1000000));
        tfcancellationno.setBounds(220, 180, 150, 25);
        add(tfcancellationno);

        JLabel lblflightcode = new JLabel("Flight Code");
        lblflightcode.setBounds(60, 230, 150, 25);
        lblflightcode.setFont(new Font("Tohama", Font.PLAIN, 16));
        lblflightcode.setForeground(Color.darkGray);
        add(lblflightcode);

        tfflightcode = new JLabel();
        tfflightcode.setBounds(220, 230, 150, 25);
        add(tfflightcode);
        
        JLabel lblsrc = new JLabel("Source");
        lblsrc.setBounds(60, 280, 150, 25);
        lblsrc.setFont(new Font("Tohama", Font.PLAIN, 16));
        lblsrc.setForeground(Color.darkGray);
        add(lblsrc);
        
        tfsrc = new JLabel();
        tfsrc.setBounds(220, 280, 150, 25);
        add(tfsrc);
        
        JLabel lbldest = new JLabel("Destination");
        lbldest.setBounds(60, 330, 150, 25);
        lbldest.setFont(new Font("Tohama", Font.PLAIN, 16));
        lbldest.setForeground(Color.darkGray);
        add(lbldest);
        
        tfdes = new JLabel();
        tfdes.setBounds(220, 330, 150, 25);
        add(tfdes);

        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 380, 150, 25);
        lbldate.setFont(new Font("Tohama", Font.PLAIN, 16));
        lbldate.setForeground(Color.darkGray);
        add(lbldate);

        lbldateoftravel = new JLabel();
        lbldateoftravel.setBounds(220, 380, 150, 25);
        add(lbldateoftravel);

        cancel = new JButton("Cancel");
        cancel.setBounds(220, 430, 120, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFocusPainted(false);
        add(cancel);

        setSize(800, 550);
        setLocation(350, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetchbutton) {
            String pnr = tfpnr.getText();

            try {
                Conn conn = new Conn();

                String query = "select * from reservation where PNR = '"+pnr+"'";

                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {
                    tfname.setText(rs.getString("name")); 
                    tfflightcode.setText(rs.getString("flightcode"));
                    lbldateoftravel.setText(rs.getString("ddate"));
                    tfsrc.setText(rs.getString("src"));
                    tfdes.setText(rs.getString("des"));
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter correct PNR");                
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            String name = tfname.getText();
            String pnr = tfpnr.getText();
            String cancelno = tfcancellationno.getText();
            String fcode = tfflightcode.getText();
            String src = tfsrc.getText();
            String des = tfdes.getText();
            String date = lbldateoftravel.getText();

            try {
                Conn conn = new Conn();

                String query = "insert into cancel values('"+pnr+"', '"+name+"', '"+cancelno+"', '"+fcode+"', '"+date+"')";

                conn.s.executeUpdate(query);
                conn.s.executeUpdate("delete from reservation where PNR = '"+pnr+"'");

                JOptionPane.showMessageDialog(null, "Ticket Cancelled");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
    }


    public static void main(String args[]) {
        new Cancel();
    }
}
