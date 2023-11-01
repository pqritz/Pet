package com.example.pet.menu;

import com.example.pet.Main;
import com.example.pet.menu.PetEditGui.PetEditGui;
import com.example.pet.util.AssetGetter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class MenuButton {

    PetEditGui petEditGui;
    boolean showGui;

    public MenuButton(JFrame parent) {
        renderButton(parent, 1.5f);
    }

    private void renderButton(JFrame parent, float scaleMultiplier) {

        petEditGui = new PetEditGui();

        BufferedImage image = new AssetGetter().getImage("catTree.png");
        ImageIcon imgIcon = new ImageIcon(image);

        JLabel imageLabel = new JLabel(new ImageIcon(imgIcon.getImage().getScaledInstance((int) (imgIcon.getIconWidth() * scaleMultiplier), (int) (imgIcon.getIconHeight() * scaleMultiplier), Image.SCALE_DEFAULT)));

        parent.add(imageLabel);
        parent.revalidate();
        parent.repaint();

        imageLabel.setLocation(-Toolkit.getDefaultToolkit().getScreenSize().width / 2 + imageLabel.getIcon().getIconWidth() / 2 + 10,
                -Toolkit.getDefaultToolkit().getScreenSize().height / 2 + imageLabel.getIcon().getIconHeight() / 2 + 10);

        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showGui = !showGui;
                Main.getInstance().getPet().setActive(!showGui);
                petEditGui.setVisible(showGui);
                //Main.getInstance().getPet().setActive(!Main.getInstance().getPet().getActive());
            }
        });
    }
}