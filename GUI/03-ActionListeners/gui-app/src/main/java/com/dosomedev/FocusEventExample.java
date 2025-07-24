package com.dosomedev;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class FocusEventExample {
    public void run() {
        JFrame frame = new JFrame("Focus Event Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel pnlMain = new JPanel();
        pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));
        
        JPanel pnlFirstName = new JPanel();
        pnlFirstName.setLayout(new BoxLayout(pnlFirstName, BoxLayout.X_AXIS));
        JLabel lblFirstName = new JLabel("First name:");
        JTextField txtFirstName = new JTextField(15);
        pnlFirstName.add(lblFirstName);
        pnlFirstName.add(txtFirstName);
        pnlMain.add(pnlFirstName);

        JPanel pnlLastName = new JPanel();
        pnlLastName.setLayout(new BoxLayout(pnlLastName, BoxLayout.X_AXIS));
        JLabel lblLastName = new JLabel("Last name:");
        JTextField txtLastName = new JTextField(15);
        pnlLastName.add(lblLastName);
        pnlLastName.add(txtLastName);
        pnlMain.add(pnlLastName);

        JLabel lblFocusStatus = new JLabel("No focus event yet.");
        pnlMain.add(lblFocusStatus);

        txtFirstName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                lblFocusStatus.setText("First name gained focus.");
                txtFirstName.setBackground(new Color(255, 255, 200));
            }

            @Override
            public void focusLost(FocusEvent e) {
                lblFocusStatus.setText("First name lost focus.");
                txtFirstName.setBackground(UIManager.getColor("TextField.background"));
            }
        });

        txtLastName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                lblFocusStatus.setText("Last name gained focus.");
                txtLastName.setBackground(new Color(255, 255, 200));
            }

            @Override
            public void focusLost(FocusEvent e) {
                lblFocusStatus.setText("Last name lost focus.");
                txtLastName.setBackground(UIManager.getColor("TextField.background"));
            }
        });

        frame.add(pnlMain);

        frame.setVisible(true);
    }
}
