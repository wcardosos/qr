package dev.wagnercardoso.qr_api.main.entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class QrCodeImage {
    private final BufferedImage image;
    private final Graphics2D graphics;

    public QrCodeImage(BufferedImage image, Graphics2D graphics) {
        this.image = image;
        this.graphics = graphics;
    }

    public BufferedImage getImage() {
        return this.image;
    }

    public Graphics2D getGraphics() {
        return this.graphics;
    }
}
