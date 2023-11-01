package com.example.pet.pet;

import com.example.pet.Animation.TextureGrapper;
import com.example.pet.util.ImageHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PetRenderer {

    JLabel imageLabel;
    Point location;
    TextureGrapper textureGrapper;
    int scaling;

    public PetRenderer(JFrame parent, int scalingFactor) {
        textureGrapper = new TextureGrapper();
        this.scaling = scalingFactor;
        renderPet(parent, scalingFactor);
    }

    public void hidePet() {
        imageLabel.setVisible(false);
    }

    public void showPet() {
        imageLabel.setVisible(true);
    }

    public void renderPet(JFrame parent, int scalingFactor) {
        BufferedImage image = textureGrapper.getTextureBySpriteCoords(1, 4);
        imageLabel = new JLabel(new ImageIcon(image.getScaledInstance(image.getWidth() * scalingFactor, image.getHeight() * scalingFactor, Image.SCALE_DEFAULT)));

        this.location = new Point(0, 0);
        parent.add(imageLabel);
        parent.revalidate();
        parent.repaint();
    }

    public void setTexture(Point spriteCoords, boolean mirror) {
        BufferedImage image = textureGrapper.getTextureBySpriteCoords(spriteCoords.x, spriteCoords.y);
        if(mirror) {
            image = ImageHelper.mirrorHorizontally(image);
        }
        imageLabel.setIcon(new ImageIcon(image.getScaledInstance(image.getWidth() * this.scaling, image.getHeight() * this.scaling, Image.SCALE_DEFAULT)));
    }

    public Dimension getIconDimension() {
        return new Dimension(imageLabel.getIcon().getIconWidth(), imageLabel.getIcon().getIconHeight());
    }

    public void setLocation(int x, int y) {
        imageLabel.setLocation(x, y);
        this.location = new Point(x, y);
        //(0|0) is the middle left is negative right is positive, up is negative down is positive
    }

    public Point getLocation() {
        return this.location;
    }
}
