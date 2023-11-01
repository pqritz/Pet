package com.example.pet.util;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;

public class ImageHelper {

    public static BufferedImage mirrorHorizontally(BufferedImage originalImage) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();

        // Create a new BufferedImage with the same transparency type as the original
        BufferedImage mirroredImage = new BufferedImage(width, height, originalImage.getType());

        // Create an AffineTransform to perform the horizontal mirroring
        AffineTransform at = new AffineTransform();
        at.concatenate(AffineTransform.getScaleInstance(-1, 1));
        at.concatenate(AffineTransform.getTranslateInstance(-width, 0));

        // Apply the AffineTransform to mirror the image
        BufferedImageOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        mirroredImage = op.filter(originalImage, null);

        return mirroredImage;
    }
}
