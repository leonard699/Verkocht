package ui;

import verkocht.Lib;

import java.io.File;
import java.awt.image.BufferedImage;

public class Spritesheet{
    BufferedImage spriteSheet;
    int pixelHeigth, pixelWidth;
    BufferedImage[][] img = new BufferedImage[0][0];

    public Spritesheet(File path) {
        spriteSheet = Lib.loadImage(path);
    }

    public void loadFromSize(int width, int height) {
        img = new BufferedImage[spriteSheet.getWidth() / width][spriteSheet.getHeight() / height];

        for (int x = 0; x < spriteSheet.getWidth() / width; x++) {
            for (int y = 0; y < spriteSheet.getHeight() / height; y++) {
                img[x][y] = spriteSheet.getSubimage(x * width, y * height, width, height);
            }
        }
    }
}