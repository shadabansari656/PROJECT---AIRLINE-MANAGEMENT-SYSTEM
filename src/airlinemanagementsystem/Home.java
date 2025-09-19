package airlinemanagementsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Home extends JFrame implements ActionListener{
    
    public Home() {
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        ImageIcon i1 = new ImageIcon(getClass().getResource("/Images/front.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1600,800);
        add(image);
        
        JLabel heading = new JLabel("AIR INDIA WELCOMES YOU");
        heading.setBounds(500,40,1000,40);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 36));
        image.add(heading);
        
        JLabel quotes = new JLabel("Your journey, our pride – Air India.");
        quotes.setBounds(850,85,1000,40);
        quotes.setForeground(Color.BLACK);
        quotes.setFont(new Font("Tahoma", Font.PLAIN, 18));
        image.add(quotes);
        
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        menubar.setBackground(Color.DARK_GRAY);
        menubar.setPreferredSize(new Dimension(0,30));
        
        
        JMenu details = new JMenu("Details");
        menubar.add(details);
        
        JMenuItem flightDetails = new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);
        details.setForeground(Color.WHITE);
        details.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JMenuItem customerDetails = new JMenuItem("Add Customer Details");
        customerDetails.addActionListener(this);
        details.add(customerDetails);
        
//        JMenuItem reservationDetails = new JMenuItem("Reservation Details");
//        reservationDetails.addActionListener(this);
//        details.add(reservationDetails);
        
        JMenuItem bookFlight = new JMenuItem("Book Flight");
        bookFlight.addActionListener(this);
        details.add(bookFlight);
        
        JMenuItem journeyDetails = new JMenuItem("Journey Details");
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);
        
        JMenuItem ticketCencellation = new JMenuItem("Cancel Ticket");
        ticketCencellation.addActionListener(this);
        details.add(ticketCencellation);
        
        menubar.add(Box.createHorizontalStrut(10));
        
        JMenu ticket = new JMenu("Ticket");
        menubar.add(ticket);
        ticket.setForeground(Color.WHITE);
        ticket.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JMenuItem boardingPass = new JMenuItem("Boarding Pass");
        boardingPass.addActionListener(this);
        ticket.add(boardingPass);
        
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();
        
        if(text.equals("Add Customer Details")) {
            new AddCustomer();
        } else if (text.equals("Flight Details")) {
            new FlightInfo();
        } else if(text.equals("Book Flight")) {
            new BookFlight();
        } else if(text.equals("Journey Details")) {
            new JourneyDetails();
        } else if(text.equals("Cancel Ticket")) {
            new Cancel();
        } else if(text.equals("Boarding Pass")) {
            new BoardingPass();
        }
    }
    
    public static void main(String args[]) {
        new Home();
   }
}


