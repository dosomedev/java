package com.dosomedev;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BorderLayoutExample {
    public void run() {
        // Create the main frame.
        JFrame frame = new JFrame("Border Layout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Set the layout.
        frame.setLayout(new BorderLayout());

        // Add components.
        JLabel lblFirstName = new JLabel("First Name:");
        JTextField txtFirstName = new JTextField(15);

        JLabel lblLastName = new JLabel("Last Name:");
        JTextField txtLastName = new JTextField(15);

        JLabel lblAge = new JLabel("Age:");
        JTextField txtAge = new JTextField(15);

        JLabel lblPlaceOfBirth = new JLabel("Place of Birth:");
        JTextField txtPlaceOfBirth = new JTextField(15);

        JLabel lblOccupation = new JLabel("Occupation:");
        JTextField txtOccupation = new JTextField(15);

        JLabel lblMail = new JLabel("Mail:");
        JTextField txtMail = new JTextField(15);

        // Group components.
        JPanel pnlNorth = new JPanel();
        pnlNorth.setBorder(BorderFactory.createTitledBorder("North"));
        pnlNorth.add(lblFirstName);
        pnlNorth.add(txtFirstName);

        JPanel pnlSouth = new JPanel();
        pnlSouth.setBorder(BorderFactory.createTitledBorder("South"));
        pnlSouth.add(lblLastName);
        pnlSouth.add(txtLastName);

        JPanel pnlWest = new JPanel();
        pnlWest.setBorder(BorderFactory.createTitledBorder("West"));
        pnlWest.add(lblAge);
        pnlWest.add(txtAge);

        JPanel pnlEast = new JPanel();
        pnlEast.setBorder(BorderFactory.createTitledBorder("East"));
        pnlEast.add(lblPlaceOfBirth);
        pnlEast.add(txtPlaceOfBirth);

        JPanel pnlCenter = new JPanel();
        pnlCenter.setBorder(BorderFactory.createTitledBorder("Center"));
        pnlCenter.add(lblOccupation);
        pnlCenter.add(txtOccupation);
        pnlCenter.add(lblMail);
        pnlCenter.add(txtMail);

        frame.add(pnlNorth, BorderLayout.NORTH);
        frame.add(pnlSouth, BorderLayout.SOUTH);
        frame.add(pnlWest, BorderLayout.WEST);
        frame.add(pnlEast, BorderLayout.EAST);
        frame.add(pnlCenter, BorderLayout.CENTER);

        // Set it visible.
        frame.setVisible(true);
    }
}
