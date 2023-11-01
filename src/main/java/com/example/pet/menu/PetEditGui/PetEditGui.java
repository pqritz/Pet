package com.example.pet.menu.PetEditGui;

import com.example.pet.Animation.TextureGrapper;
import com.example.pet.Main;
import com.example.pet.menu.util.RoundButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class PetEditGui {

    boolean guiCreated;
    JFrame frame;

    public PetEditGui() {
        if(!this.guiCreated) {
            createGui();
        }
    }

    public void createGui() {
        this.guiCreated = true;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        frame = new JFrame("<3");
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.darkGray);
        frame.setBounds(screenSize.width / 4, screenSize.height / 4, screenSize.width / 2, screenSize.height / 2);

        createQuadrantsWithIntersectionAt(frame, new Point(70, 20));
    }


    //Point in percent from left to right and top to bottom meaning 40|50 would give the left side 40% of the frame and the top 50%
    private void createQuadrantsWithIntersectionAt(JFrame parent, Point p) {
        JPanel topLeft = new JPanel();
        JPanel topRight = new JPanel();
        JPanel bottomLeft = new JPanel();
        JPanel bottomRight = new JPanel();

        JPanel[] panels = {topLeft, topRight, bottomRight, bottomLeft};

        JPanel verticalSep = new JPanel();
        JPanel horizontalSep = new JPanel();

        verticalSep.setBackground(new Color(64, 64, 64)); //CHILLING RED 191, 85, 98
        horizontalSep.setBackground(new Color(64, 64, 64));

        for (JPanel panel : panels) {
            panel.setBackground(new Color(85, 98, 112));
        }

        int totalW = parent.getWidth();
        int totalH = parent.getHeight();

        int leftWidth = totalW * p.x / 100;
        int rightWidth = totalW - leftWidth;
        int topHeight = totalH * p.y / 100;
        int bottomHeight = totalH - topHeight;


        Point s1 = new Point(0, 0);
        Point s2 = new Point(leftWidth, 0);
        Point s3 = new Point(leftWidth, topHeight);
        Point s4 = new Point(0, topHeight);

        Dimension e1 = new Dimension(s3.x, s3.y);
        Dimension e2 = new Dimension(rightWidth, topHeight);
        Dimension e3 = new Dimension(rightWidth, bottomHeight);
        Dimension e4 = new Dimension(leftWidth, bottomHeight);


        // Set preferred sizes for the panels
        topLeft.setPreferredSize(e1);
        topRight.setPreferredSize(e2);
        bottomRight.setPreferredSize(e3);
        bottomLeft.setPreferredSize(e4);

        // Set positions
        topLeft.setBounds(s1.x, s1.y, e1.width, e1.height);
        topRight.setBounds(s2.x, s2.y, e2.width, e2.height);
        bottomRight.setBounds(s3.x, s3.y, e3.width, e3.height);
        bottomLeft.setBounds(s4.x, s4.y, e4.width, e4.height);


        verticalSep.setBounds(leftWidth - 2, 0, 2, totalH);
        horizontalSep.setBounds(0, topHeight - 2, totalW, 2);

        parent.add(verticalSep);
        parent.add(horizontalSep);

        topLeftContent(topLeft);
        topRightContent(topRight);
        bottomRightContent(bottomRight);
        bottomLeftContent(bottomLeft);

        parent.add(topLeft);
        parent.add(topRight);
        parent.add(bottomRight);
        parent.add(bottomLeft);
    }

    private void topLeftContent(JPanel parent) {
        parent.setLayout(new GridBagLayout());

        JLabel label = new JLabel("Ich liebe dich mein Schatz <3");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(new Color(34, 34, 34));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10); // Add some padding
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;


        parent.add(label, constraints);
    }

    private void topRightContent(JPanel parent) {
        //Cynthia
        parent.setLayout(new GridBagLayout());

        JLabel label = new JLabel("Cynthia");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(new Color(34, 34, 34));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10); // Add some padding
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;


        parent.add(label, constraints);
    }

    private void bottomLeftContent(JPanel parent) {
        parent.setLayout(new FlowLayout());

        JLabel label = new JLabel("<html>Hier kommt evtl noch viel mehr, " +
                "<br>aber vorerst werde ich weiter am Arduino arbeiten. " +
                "<br>Tut mir leid, ich hoffe trotzdem das gefällt dir." +
                "<br>Ich hab sie Cynthia getauft" +
                "<br>(Das ist ein name von Artemis, " +
                "<br>oft verbunden mit Katzen " +
                "<br>und Bastet die Ägyptische Gottheit mit Katzenkopf)." +
                "<br>Ich liebe dich über alles mein Schatz</html>");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setPreferredSize(new Dimension(parent.getWidth(), parent.getHeight()));
        label.setForeground(new Color(34, 34, 34));
        label.setBackground(Color.RED);

        label.setHorizontalTextPosition(0);
        label.setVerticalTextPosition(0);

        parent.add(label);
    }

    private void bottomRightContent(JPanel parent) {
        parent.setLayout(new FlowLayout());

        JPanel top = new JPanel();
        JPanel bottom = new JPanel();

        JPanel horizontalSeparator = new JPanel();
        horizontalSeparator.setBackground(new Color(64, 64, 64));

        top.setPreferredSize(new Dimension(parent.getWidth(), parent.getHeight() / 2));
        horizontalSeparator.setPreferredSize(new Dimension(parent.getWidth(), 2));
        bottom.setPreferredSize(new Dimension(parent.getWidth(), parent.getHeight() / 2));

        top.setBackground(new Color(0, 0, 0, 0));
        bottom.setBackground(new Color(0, 0, 0, 0));

        top.setLayout(new GridLayout());
        bottom.setLayout(new FlowLayout());

        BufferedImage image = new TextureGrapper().getTextureBySpriteCoords(0, 0).getSubimage(0, 20, 12, 12);
        ImageIcon imgIcon = new ImageIcon(image.getScaledInstance(image.getWidth() * 7, image.getHeight() * 7, Image.SCALE_DEFAULT));
        JLabel imageLabel = new JLabel(imgIcon);

        top.add(imageLabel);


        //Bottom Settings
        final boolean[] buttonState = {false}; //Hidden True False
        JButton btn = new RoundButton("", 75, false);
        btn.setPreferredSize(new Dimension(20, 20));
        btn.setBackground(Color.GREEN);

        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getButton() == MouseEvent.BUTTON1) {
                    buttonState[0] = !buttonState[0];
                    Main.getInstance().getPet().setHidden(buttonState[0]);
                    if(buttonState[0]) {
                        btn.setBackground(Color.RED);
                    } else {
                        btn.setBackground(Color.GREEN);
                    }
                }
            }
        });

        JLabel label = new JLabel("Show/Hide Pet");
        label.setFont(new Font("Arial", Font.BOLD, 15));
        label.setForeground(new Color(34, 34, 34));

        bottom.add(btn);
        bottom.add(label);

        parent.add(top);
        parent.add(horizontalSeparator);
        parent.add(bottom);
    }

    public void setVisible(boolean visibility) {
        this.frame.setVisible(visibility);
    }
}
