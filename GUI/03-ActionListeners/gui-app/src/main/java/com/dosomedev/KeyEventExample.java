package com.dosomedev;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class KeyEventExample {
    public void run() {
        JFrame frame = new JFrame("Key Event Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());
        JTextArea textArea = new JTextArea();

        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.printf("Key Typed:    %s%n", e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.printf("Key Pressed:  %s%n", e.getKeyChar());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.printf("Key Released: %s%n", e.getKeyChar());
                System.out.printf("Text: %s%n", textArea.getText());
            }
        });

        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        textArea.requestFocusInWindow();

        frame.setVisible(true);
    }
}
