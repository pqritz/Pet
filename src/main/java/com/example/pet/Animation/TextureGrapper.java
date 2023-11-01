package com.example.pet.Animation;

import com.example.pet.util.AssetGetter;

import java.awt.image.BufferedImage;

public class TextureGrapper {

    // (0|0) will be the top left image
    public BufferedImage getTextureBySpriteCoords(int sx, int sy) {
        AssetGetter assetGetter = new AssetGetter();
        int spriteWidth = 19;
        int spriteHeight = 32;
        BufferedImage image = assetGetter.getImage("croppedImage.png");

        BufferedImage cutImage = image.getSubimage(sx * spriteWidth, sy * spriteHeight,
                spriteWidth, spriteHeight);

        return cutImage;
    }
}
