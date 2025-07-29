package com.dosomedev;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.BorderLayout;

public class TableFilterSortExample {
    public void run() {
        JFrame frame = new JFrame("Table Filter Sort Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Sample data.
        Object[][] data = {
            {"1", "John", "Doe", false},
            {"2", "Jane", "Smith", true},
            {"3", "Peter", "Jones", false},
            {"4", "Alice", "Brown", true}
        };

        // Create table.
        String[] columnNames = {"ID", "First Name", "Last Name", "Is Active"};
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                // Make the last column a Boolean for the checkbox editor.
                return columnIndex == getColumnCount() - 1 ? Boolean.class : String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                // Make only the "Is Active" column editable.
                return column == getColumnCount() - 1;
            }
        };

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Sorting.
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        // Filtering.
        JPanel pnlFilter = new JPanel(new BorderLayout());
        JLabel lblFilter = new JLabel("Filter:");
        JTextField txtFilter = new JTextField();
        txtFilter.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                filter(txtFilter.getText());
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                filter(txtFilter.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filter(txtFilter.getText());
            }

            private void filter(String text) {
                if (text.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
        });
        pnlFilter.add(lblFilter, BorderLayout.WEST);
        pnlFilter.add(txtFilter, BorderLayout.CENTER);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(pnlFilter, BorderLayout.NORTH);

        frame.setVisible(true);
    }
}
