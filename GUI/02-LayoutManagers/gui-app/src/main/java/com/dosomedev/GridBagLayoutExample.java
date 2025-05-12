package com.dosomedev;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GridBagLayoutExample {
    public void run() {
        // Create the main frame.
        JFrame frame = new JFrame("Grid Bag Layout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Set layout.
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbcFirstColumn = new GridBagConstraints();
        gbcFirstColumn.insets = new Insets(5, 5, 5, 5);
        gbcFirstColumn.fill = GridBagConstraints.HORIZONTAL;
        gbcFirstColumn.weightx = 0.2;

        GridBagConstraints gbcSecondColumn = new GridBagConstraints();
        gbcSecondColumn.insets = new Insets(5, 5, 5, 5);
        gbcSecondColumn.fill = GridBagConstraints.HORIZONTAL;
        gbcSecondColumn.weightx = 0.8;

        // Add components.

        // Add first name.
        JLabel lblFirstName = new JLabel("First Name:");
        gbcFirstColumn.gridx = 0;
        gbcFirstColumn.gridy = 0;
        frame.add(lblFirstName, gbcFirstColumn);

        JTextField txtFirstName = new JTextField(15);
        gbcSecondColumn.gridx = 1;
        gbcSecondColumn.gridy = 0;
        frame.add(txtFirstName, gbcSecondColumn);

        // Add last name.
        JLabel lblLastName = new JLabel("Last Name:");
        gbcFirstColumn.gridx = 0;
        gbcFirstColumn.gridy = 1;
        frame.add(lblLastName, gbcFirstColumn);

        JTextField txtLastName = new JTextField(15);
        gbcSecondColumn.gridx = 1;
        gbcSecondColumn.gridy = 1;
        frame.add(txtLastName, gbcSecondColumn);

        // Add age.
        JLabel lblAge = new JLabel("Age:");
        gbcFirstColumn.gridx = 0;
        gbcFirstColumn.gridy = 2;
        frame.add(lblAge, gbcFirstColumn);

        JTextField txtAge = new JTextField(15);
        gbcSecondColumn.gridx = 1;
        gbcSecondColumn.gridy = 2;
        frame.add(txtAge, gbcSecondColumn);

        // Add place of birth.
        JLabel lblPlaceOfBirth = new JLabel("Place of Birth:");
        gbcFirstColumn.gridx = 0;
        gbcFirstColumn.gridy = 3;
        frame.add(lblPlaceOfBirth, gbcFirstColumn);

        JTextField txtPlaceOfBirth = new JTextField(15);
        gbcSecondColumn.gridx = 1;
        gbcSecondColumn.gridy = 3;
        frame.add(txtPlaceOfBirth, gbcSecondColumn);

        // Add occupation.
        JLabel lblOccupation = new JLabel("Occupation:");
        gbcFirstColumn.gridx = 0;
        gbcFirstColumn.gridy = 4;
        frame.add(lblOccupation, gbcFirstColumn);

        JTextField txtOccupation = new JTextField(15);
        gbcSecondColumn.gridx = 1;
        gbcSecondColumn.gridy = 4;
        frame.add(txtOccupation, gbcSecondColumn);

        // Add mail.
        JLabel lblMail = new JLabel("Mail:");
        gbcFirstColumn.gridx = 0;
        gbcFirstColumn.gridy = 5;
        frame.add(lblMail, gbcFirstColumn);

        JTextField txtMail = new JTextField(15);
        gbcSecondColumn.gridx = 1;
        gbcSecondColumn.gridy = 5;
        frame.add(txtMail, gbcSecondColumn);

        // Set it visible.
        frame.setVisible(true);
    }
}
