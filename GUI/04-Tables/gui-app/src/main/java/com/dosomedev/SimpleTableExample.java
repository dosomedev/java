package com.dosomedev;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SimpleTableExample {
    public void run() {
        JFrame frame = new JFrame("Simple Table Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Sample data.
        Object[][] data = {
            {"1", "John", "Doe"},
            {"2", "Jane", "Smith"},
            {"3", "Peter", "Jones"}
        };

        // Create table.
        String[] columnNames = {"ID", "First Name", "Last Name"};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(scrollPane);

        frame.setVisible(true);
    }
}
