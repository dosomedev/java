package com.dosomedev;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Simple Swing example.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Create the main frame.
        JFrame frame = new JFrame("Simple Swing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Set layout.
        frame.setLayout(new GridLayout(3, 1, 5, 5));

        // Add components.
        JPanel pnlDataEntry = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pnlAction = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pnlDataView = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlDataEntry.setBorder(BorderFactory.createTitledBorder("Data Entry"));
        pnlAction.setBorder(BorderFactory.createTitledBorder("Action"));
        pnlDataView.setBorder(BorderFactory.createTitledBorder("Data View"));

        JLabel lblName = new JLabel("Enter your name:");
        JTextField txtName = new JTextField(15);
        pnlDataEntry.add(lblName);
        pnlDataEntry.add(txtName);

        JButton btnCopyText = new JButton("Copy Text");
        pnlAction.add(btnCopyText);

        JLabel lblEnteredName = new JLabel("Entered name:");
        JTextField txtEnteredName = new JTextField(15);
        pnlDataView.add(lblEnteredName);
        pnlDataView.add(txtEnteredName);

        // Add action.
        btnCopyText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtEnteredName.setText(txtName.getText());
            }
        });

        frame.add(pnlDataEntry);
        frame.add(pnlAction);
        frame.add(pnlDataView);

        // Set frame visible.
        frame.setVisible(true);
    }
}
