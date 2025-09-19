package airlinemanagementsystem;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BoardingPass extends JFrame implements ActionListener {

    JTextField tfpnr;
    JLabel tfname, tfnation, lblsrc,lbldest, labelfname, labelfcode, labeldate;
    JButton fetchbutton;

    public BoardingPass() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("AIR INDIA");
        heading.setBounds(380, 10, 450, 35);
        heading.setFont(new Font("Tohama", Font.BOLD, 32));
        heading.setForeground(Color.darkGray);
        add(heading);
        
        JLabel subheading = new JLabel("Boarding Pass");
        subheading.setBounds(370, 50, 300, 30);
        subheading.setFont(new Font("Tohama", Font.BOLD, 24));
        subheading.setForeground(new Color(171, 0, 22));

        add(subheading);

        JLabel lblpnrdetails = new JLabel("PNR DETAILS");
        lblpnrdetails.setBounds(60, 100, 150, 25);
        lblpnrdetails.setFont(new Font("Tohama", Font.PLAIN, 16));
        lblpnrdetails.setForeground(Color.darkGray);
        add(lblpnrdetails);

        tfpnr = new JTextField();
        tfpnr.setBounds(220, 100, 150, 25);
        add(tfpnr);

        fetchbutton = new JButton("Enter");
        fetchbutton.setBackground(Color.BLACK);
        fetchbutton.setForeground(Color.WHITE);
        fetchbutton.setBounds(380, 100, 125, 25);
        fetchbutton.addActionListener(this);
        fetchbutton.setFocusPainted(false);
        add(fetchbutton);

        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 140, 150, 25);
        lblname.setFont(new Font("Tohama", Font.PLAIN, 16));
        lblname.setForeground(Color.darkGray);
        add(lblname);

        tfname = new JLabel();
        tfname.setBounds(220, 140, 150, 25);
        add(tfname);

        JLabel lblnation = new JLabel("NATIONALITY");
        lblnation.setBounds(60, 180, 150, 25);
        lblnation.setFont(new Font("Tohama", Font.PLAIN, 16));
        lblnation.setForeground(Color.darkGray);
        add(lblnation);

        tfnation = new JLabel();
        tfnation.setBounds(220, 180, 150, 25);
        add(tfnation);

        JLabel lblsource = new JLabel("SOURCE");
        lblsource.setBounds(60, 220, 150, 25);
        lblsource.setFont(new Font("Tohama", Font.PLAIN, 16));
        lblsource.setForeground(Color.darkGray);
        add(lblsource);

        lblsrc = new JLabel();
        lblsrc.setBounds(220, 220, 150, 25);
        add(lblsrc);

        JLabel lbldestination = new JLabel("DESTINATION");
        lbldestination.setBounds(380, 220, 150, 25);
        lbldestination.setFont(new Font("Tohama", Font.PLAIN, 16));
        lbldestination.setForeground(Color.darkGray);
        add(lbldestination);

        lbldest = new JLabel();
        lbldest.setBounds(540, 220, 150, 25);
        add(lbldest);

        JLabel lblfname = new JLabel("FLIGHT NAME");
        lblfname.setBounds(60, 260, 150, 25);
        lblfname.setFont(new Font("Tohama", Font.PLAIN, 16));
        lblfname.setForeground(Color.darkGray);
        add(lblfname);

        labelfname = new JLabel();
        labelfname.setBounds(220, 260, 150, 25);
        add(labelfname);

        JLabel lblfcode = new JLabel("FLIGHT CODE");
        lblfcode.setBounds(380, 260, 150, 25);
        lblfcode.setFont(new Font("Tohama", Font.PLAIN, 16));
        lblfcode.setForeground(Color.darkGray);
        add(lblfcode);

        labelfcode = new JLabel();
        labelfcode.setBounds(540, 260, 150, 25);
        add(labelfcode);

        JLabel lbldate = new JLabel("DATE");
        lbldate.setBounds(60, 300, 150, 25);
        lbldate.setFont(new Font("Tohama", Font.PLAIN, 16));
        lbldate.setForeground(Color.darkGray);
        add(lbldate);

        labeldate = new JLabel();
        labeldate.setBounds(220, 300, 150, 25);
        add(labeldate);

        ImageIcon i1 = new ImageIcon(getClass().getResource("/Images/airindia.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(600, 0, 300, 300);
        add(lblimage);

        setSize(1000, 450);
        setLocation(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String pnr = tfpnr.getText();
        
        try {
            Conn conn = new Conn();

            String query = "select * from reservation where PNR = '" + pnr + "'";

            ResultSet rs = conn.s.executeQuery(query);

            if (rs.next()) {
                    tfname.setText(rs.getString("name"));
                    tfnation.setText(rs.getString("nationality"));
                    lblsrc.setText(rs.getString("src"));
                    lbldest.setText(rs.getString("des"));
                    labelfname.setText(rs.getString("flightname"));
                    labelfcode.setText(rs.getString("flightcode"));
                    labeldate.setText(rs.getString("ddate"));
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter correct PNR");
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new BoardingPass();
    }
}
