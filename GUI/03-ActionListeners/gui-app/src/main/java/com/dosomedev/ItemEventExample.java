package com.dosomedev;

import java.awt.ItemSelectable;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ItemEventExample {
    public void run() {
        JFrame frame = new JFrame("Item Event Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel pnlMain = new JPanel();
        pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));

        JCheckBox chkJava = new JCheckBox("Java");
        JCheckBox chkPython = new JCheckBox("Python");

        JRadioButton rdoMale = new JRadioButton("Male");
        JRadioButton rdoFemale = new JRadioButton("Female");
        ButtonGroup bgrGender = new ButtonGroup();
        bgrGender.add(rdoMale);
        bgrGender.add(rdoFemale);

        JLabel lblSelection = new JLabel("No selection yet.");

        ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                ItemSelectable source = e.getItemSelectable();
                int state = e.getStateChange();
                String itemName = "";
                String stateText = (state == ItemEvent.SELECTED) ? "Selected" : "Deselected";

                if (source == chkJava) {
                    itemName = "Java";
                } else if (source == chkPython) {
                    itemName = "Python";
                } else if (source == rdoMale) {
                    itemName = "Male";
                } else if (source == rdoFemale) {
                    itemName = "Female";
                } else {
                    itemName = "Unknown";
                }

                lblSelection.setText(itemName + " is " + stateText);
            }
        };

        chkJava.addItemListener(itemListener);
        chkPython.addItemListener(itemListener);
        rdoMale.addItemListener(itemListener);
        rdoFemale.addItemListener(itemListener);

        pnlMain.add(chkJava);
        pnlMain.add(chkPython);
        pnlMain.add(rdoMale);
        pnlMain.add(rdoFemale);
        pnlMain.add(lblSelection);

        frame.add(pnlMain);

        frame.setVisible(true);
    }
}
