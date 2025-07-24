package com.dosomedev;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseEventExample {
    public void run() {
        JFrame frame = new JFrame("Mouse Event Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        JPanel pnlSurface = new JPanel();

        pnlSurface.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.printf(
                    "Mouse Clicked at  x=%s y=%s%n",
                    e.getPoint().getX(),
                    e.getPoint().getY()
                );
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.printf(
                    "Mouse Pressed at  x=%s y=%s%n",
                    e.getPoint().getX(),
                    e.getPoint().getY()
                );
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.printf(
                    "Mouse Released at x=%s y=%s%n",
                    e.getPoint().getX(),
                    e.getPoint().getY()
                );
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.printf(
                    "Mouse Entered at  x=%s y=%s%n",
                    e.getPoint().getX(),
                    e.getPoint().getY()
                );
                pnlSurface.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.printf(
                    "Mouse Exited at   x=%s y=%s%n",
                    e.getPoint().getX(),
                    e.getPoint().getY()
                );
                pnlSurface.setBackground(null);
            }
        });

        frame.add(pnlSurface);
        
        frame.setVisible(true);
    }
}
