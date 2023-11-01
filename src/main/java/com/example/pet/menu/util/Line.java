package com.example.pet.menu.util;

import javax.swing.*;
import java.awt.*;

public class Line extends JComponent {
    private Dimension e1, e2, e3, e4;
    private int totalW, totalH;

    public Line(Dimension e1, Dimension e2, Dimension e3, Dimension e4, int totalW, int totalH) {
        this.e1 = e1;
        this.e2 = e2;
        this.e3 = e3;
        this.e4 = e4;
        this.totalW = totalW;
        this.totalH = totalH;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK); // Set the line color to black

        // Draw a vertical line between left and right panels
        int verticalX = e1.width;
        g.drawLine(verticalX, 0, verticalX, totalH);

        // Draw a horizontal line between top and bottom panels
        int horizontalY = e1.height;
        g.drawLine(0, horizontalY, totalW, horizontalY);
    }
}
