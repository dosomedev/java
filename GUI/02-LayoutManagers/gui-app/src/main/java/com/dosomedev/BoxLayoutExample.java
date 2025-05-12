package com.dosomedev;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BoxLayoutExample {
    public void run() {
        // Create the main frame.
        JFrame frame = new JFrame("Box Layout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Set layout.
        JPanel pnlMain = new JPanel();
        frame.add(pnlMain);
        pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));

        // Add components.

        // Add first name.
        JPanel pnlFirstName = new JPanel();
        pnlFirstName.setLayout(new BoxLayout(pnlFirstName, BoxLayout.X_AXIS));

        JLabel lblFirstName = new JLabel("First Name:");
        pnlFirstName.add(lblFirstName);
        pnlFirstName.add(Box.createHorizontalStrut(5)); // Add horizontal space.
        JTextField txtFirstName = new JTextField(15);
        pnlFirstName.add(txtFirstName);

        pnlMain.add(pnlFirstName);
        pnlMain.add(Box.createVerticalStrut(5));

        // Add last name.
        JPanel pnlLastName = new JPanel();
        pnlLastName.setLayout(new BoxLayout(pnlLastName, BoxLayout.X_AXIS));

        JLabel lblLastName = new JLabel("Last Name:");
        pnlLastName.add(lblLastName);
        pnlLastName.add(Box.createHorizontalStrut(5)); // Add horizontal space.
        JTextField txtLastName = new JTextField(15);
        pnlLastName.add(txtLastName);

        pnlMain.add(pnlLastName);
        pnlMain.add(Box.createVerticalStrut(5));

        // Add age.
        JPanel pnlAge = new JPanel();
        pnlAge.setLayout(new BoxLayout(pnlAge, BoxLayout.X_AXIS));

        JLabel lblAge = new JLabel("Age:");
        pnlAge.add(lblAge);
        pnlAge.add(Box.createHorizontalStrut(5)); // Add horizontal space.
        JTextField txtAge = new JTextField(15);
        pnlAge.add(txtAge);

        pnlMain.add(pnlAge);
        pnlMain.add(Box.createVerticalStrut(5));

        // Add place of birth.
        JPanel pnlPlaceOfBirth = new JPanel();
        pnlPlaceOfBirth.setLayout(new BoxLayout(pnlPlaceOfBirth, BoxLayout.X_AXIS));

        JLabel lblPlaceOfBirth = new JLabel("Place of Birth:");
        pnlPlaceOfBirth.add(lblPlaceOfBirth);
        pnlPlaceOfBirth.add(Box.createHorizontalStrut(5)); // Add horizontal space.
        JTextField txtPlaceOfBirth = new JTextField(15);
        pnlPlaceOfBirth.add(txtPlaceOfBirth);

        pnlMain.add(pnlPlaceOfBirth);
        pnlMain.add(Box.createVerticalStrut(5));

        // Add occupation.
        JPanel pnlOccupation = new JPanel();
        pnlOccupation.setLayout(new BoxLayout(pnlOccupation, BoxLayout.X_AXIS));

        JLabel lblOccupation = new JLabel("Occupation:");
        pnlOccupation.add(lblOccupation);
        pnlOccupation.add(Box.createHorizontalStrut(5)); // Add horizontal space.
        JTextField txtOccupation = new JTextField(15);
        pnlOccupation.add(txtOccupation);

        pnlMain.add(pnlOccupation);
        pnlMain.add(Box.createVerticalStrut(5));

        // Add mail.
        JPanel pnlMail = new JPanel();
        pnlMail.setLayout(new BoxLayout(pnlMail, BoxLayout.X_AXIS));

        JLabel lblMail = new JLabel("Mail:");
        pnlMail.add(lblMail);
        pnlMail.add(Box.createHorizontalStrut(5)); // Add horizontal space.
        JTextField txtMail = new JTextField(15);
        pnlMail.add(txtMail);

        pnlMain.add(pnlMail);
        pnlMain.add(Box.createVerticalStrut(5));

        // Set it visible.
        frame.setVisible(true);
    }
}
