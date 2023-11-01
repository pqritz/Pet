package com.example.pet.overlay;
import javax.swing.*;
import java.awt.*;


public class Overlay {
    private JFrame frame;

    public Overlay() {
        frame = new JFrame();
        frame.setAlwaysOnTop(true);
        frame.setUndecorated(true); // Remove the window decorations
        frame.setBackground(new Color(0,0,0,0));

        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

}
