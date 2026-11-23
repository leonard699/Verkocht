package verkocht;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Lib {
    BufferedImage placeholderImage = null;

    public BufferedImage loadImage(File Filepath) {
        try {
            return ImageIO.read(Filepath);
        } catch (IOException e) {
            System.out.println(e);
        }

        if (placeholderImage != null) {
            return placeholderImage;
        }
        return null;
    }

    public BufferedImage loadImage(String path) {
        return loadImage(new File(path));
    }
}
