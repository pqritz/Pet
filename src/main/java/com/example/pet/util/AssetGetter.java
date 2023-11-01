package com.example.pet.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class AssetGetter {

    public BufferedImage getImage(String name) {
        // Load the image from the JAR's resources
        String resourcePath = "/assets/" + name;

        // this is the path within the jar file
        InputStream input = AssetGetter.class.getResourceAsStream(resourcePath);
        if (input == null) {
            // this is how we load file within editor (eg eclipse)
            input = AssetGetter.class.getClassLoader().getResourceAsStream(resourcePath);
        }
        if (input != null) {
            try {
                // Read the image from the input stream
                BufferedImage image = ImageIO.read(input);
                return image;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Resource not found in the JAR: " + resourcePath);
        }

        return null;
    }
}
