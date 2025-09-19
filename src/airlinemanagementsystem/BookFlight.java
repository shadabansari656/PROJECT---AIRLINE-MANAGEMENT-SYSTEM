package airlinemanagementsystem;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener {

    JTextField tfaadhar;
    JLabel tfname, tfnation, tfaddress, labelgender, labelfname, labelfcode;
    JButton fetchbutton, bookflight, flight;
    Choice source, destination;
    JDateChooser dcdate;

    public BookFlight() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        JLabel heading = new JLabel("BOOK FLIGHT");
        heading.setBounds(420, 20, 500, 35);
        heading.setFont(new Font("Tohama", Font.BOLD, 32));
        heading.setForeground(Color.darkGray);
        add(heading);

        JLabel lblaadhar = new JLabel("Aadhar");
        lblaadhar.setBounds(60, 80, 150, 25);
        lblaadhar.setFont(new Font("Tohama", Font.PLAIN, 16));
        lblaadhar.setForeground(Color.darkGray);
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 80, 150, 25);
        add(tfaadhar);

        fetchbutton = new JButton("Fetch User");
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

        JLabel lblnation = new JLabel("Nationality");
        lblnation.setBounds(60, 180, 150, 25);
        lblnation.setFont(new Font("Tohama", Font.PLAIN, 16));
        lblnation.setForeground(Color.darkGray);
        add(lblnation);

        tfnation = new JLabel();
        tfnation.setBounds(220, 180, 150, 25);
        add(tfnation);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Tohama", Font.PLAIN, 16));
        lbladdress.setForeground(Color.darkGray);
        add(lbladdress);

        tfaddress = new JLabel();
        tfaddress.setBounds(220, 230, 150, 25);
        add(tfaddress);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Tohama", Font.PLAIN, 16));
        lblgender.setForeground(Color.darkGray);
        add(lblgender);

        labelgender = new JLabel("Gender");
        labelgender.setBounds(220, 280, 150, 25);
        add(labelgender);

        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60, 330, 150, 25);
        lblsource.setFont(new Font("Tohama", Font.PLAIN, 16));
        lblsource.setForeground(Color.darkGray);
        add(lblsource);

        source = new Choice();
        source.setBounds(220, 330, 150, 25);
        add(source);

        JLabel lbldest = new JLabel("Destination");
        lbldest.setBounds(60, 380, 150, 25);
        lbldest.setFont(new Font("Tohama", Font.PLAIN, 16));
        lbldest.setForeground(Color.darkGray);
        add(lbldest);

        destination = new Choice();
        destination.setBounds(220, 380, 150, 25);
        add(destination);

        try {
            Conn c = new Conn();
            String query = "Select * from flight";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        flight = new JButton("Fetch Flight");
        flight.setBounds(380, 380, 120, 25);
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.addActionListener(this);
        flight.setFocusPainted(false);
        flight.setFocusPainted(false);
        add(flight);

        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 430, 150, 25);
        lblfname.setFont(new Font("Tohama", Font.PLAIN, 16));
        lblfname.setForeground(Color.darkGray);
        add(lblfname);

        labelfname = new JLabel();
        labelfname.setBounds(220, 430, 150, 25);
        add(labelfname);

        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60, 480, 150, 25);
        lblfcode.setFont(new Font("Tohama", Font.PLAIN, 16));
        lblfcode.setForeground(Color.darkGray);
        add(lblfcode);

        labelfcode = new JLabel();
        labelfcode.setBounds(220, 480, 150, 25);
        add(labelfcode);

        JLabel lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(60, 530, 150, 25);
        lbldate.setFont(new Font("Tohama", Font.PLAIN, 16));
        lbldate.setForeground(Color.darkGray);
        add(lbldate);

        dcdate = new JDateChooser();
        dcdate.setBounds(220, 530, 150, 25);
        add(dcdate);

        ImageIcon i1 = new ImageIcon(getClass().getResource("/Images/details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(550, 80, 500, 410);
        add(lblimage);

        bookflight = new JButton("Book Flight");
        bookflight.setBounds(220, 580, 150, 30);
        bookflight.setBackground(Color.BLACK);
        bookflight.setForeground(Color.WHITE);
        bookflight.addActionListener(this);
        bookflight.setFocusPainted(false);
        add(bookflight);

        setSize(1100, 700);
        setLocation(200, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetchbutton) {
            String aadhar = tfaadhar.getText();
            try {
                Conn conn = new Conn();

                String query = "select * from passenger where aadhar = '" + aadhar + "'";

                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {
                    tfname.setText(rs.getString("name"));
                    tfnation.setText(rs.getString("nationality"));
                    tfaddress.setText(rs.getString("address"));
                    labelgender.setText(rs.getString("gender"));
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter correct aadhar");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == flight) {
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();
            try {
                Conn conn = new Conn();

                String query = "select * from flight where source = '" + src + "' and destination = '" + dest + "'";

                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {
                    labelfname.setText(rs.getString("flight_name"));
                    labelfcode.setText(rs.getString("flight_code"));
                } else {
                    JOptionPane.showMessageDialog(null, "No Flights Found!");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Random random = new Random();
            String aadhar = tfaadhar.getText();
            String name = tfname.getText();
            String nationality = tfnation.getText();
            String address = tfaddress.getText();
            String flightname = labelfname.getText();
            String flightcode = labelfcode.getText();
            String src = source.getSelectedItem();
            String des = destination.getSelectedItem();
            String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();

            if (aadhar.isEmpty() || name.isEmpty() || nationality.isEmpty() || flightname.isEmpty() || flightcode.isEmpty() || src.isEmpty() || des.isEmpty() || ddate.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all flight details before booking!");
                return;
            }

            try {
                Conn conn = new Conn();

                String query = "insert into reservation values('PNR-" + random.nextInt(1000000) + "', 'TIC-" + random.nextInt(10000) + "','" + aadhar + "','" + name + "','" + nationality + "','" + flightname + "','" + flightcode + "','" + src + "','" + des + "','" + ddate + "')";

                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Ticked Booked Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        new BookFlight();
    }
}
