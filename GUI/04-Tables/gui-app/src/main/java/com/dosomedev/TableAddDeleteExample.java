package com.dosomedev;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TableAddDeleteExample {
    private JLabel lblRowCount = new JLabel();
    DefaultTableModel model;

    public void run() {
        JFrame frame = new JFrame("Table Add Delete Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pnlMain = new JPanel();
        pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));
        
        // Sample data.
        Object[][] data = {
            {"1", "John", "Doe"},
            {"2", "Jane", "Smith"},
            {"3", "Peter", "Jones"}
        };

        // Create table.
        String[] columnNames = {"ID", "First Name", "Last Name"};
        model = new DefaultTableModel(data, columnNames);
        updateRowCount();
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Input fields.
        JPanel pnlInput = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pnlId = new JPanel();
        JLabel lblId = new JLabel("ID:");
        JTextField txtId = new JTextField(5);
        pnlId.add(lblId);
        pnlId.add(txtId);

        JPanel pnlFirstName = new JPanel();
        JLabel lblFirstName = new JLabel("First Name:");
        JTextField txtFirstName = new JTextField(15);
        pnlFirstName.add(lblFirstName);
        pnlFirstName.add(txtFirstName);

        JPanel pnlLastName = new JPanel();
        JLabel lblLastName = new JLabel("Last Name:");
        JTextField txtLastName = new JTextField(15);
        pnlLastName.add(lblLastName);
        pnlLastName.add(txtLastName);

        JButton btnAdd = new JButton("Add Row");

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                String firstName = txtFirstName.getText();
                String lastName = txtLastName.getText();

                if (!id.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty()) {
                    model.addRow(new Object[]{id, firstName, lastName});
                    updateRowCount();
                    txtId.setText("");
                    txtFirstName.setText("");
                    txtLastName.setText("");
                }
            }
        });
        
        pnlInput.add(pnlId);
        pnlInput.add(pnlFirstName);
        pnlInput.add(pnlLastName);
        pnlInput.add(btnAdd);

        // Summary fields.
        JPanel pnlSummary = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnDelete = new JButton("Delete Selected Row");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    model.removeRow(selectedRow);
                    updateRowCount();
                }
            }
        });
        pnlSummary.add(lblRowCount);
        pnlSummary.add(btnDelete);
        
        // Put panels together.
        pnlMain.add(pnlInput);
        pnlMain.add(scrollPane);
        pnlMain.add(pnlSummary);
        frame.add(pnlMain);

        frame.pack();
        frame.setVisible(true);
    }

    private void updateRowCount() {
        if (model != null) {
            lblRowCount.setText("Row Count: " + model.getRowCount());
        }
    }
}
