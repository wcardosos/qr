package dev.wagnercardoso.qr_api.main.entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class QrCode {
    private String url;
    private String topText;
    private String bottomText;
    private BufferedImage image;
    private Graphics2D graphics;

    public QrCode(String url, String topText, String bottomText) {
        this.url = url;
        this.topText = topText;
        this.bottomText = bottomText;
    }

    public String getUrl() {
        return this.url;
    }

    public String getTopText() {
        return this.topText;
    }

    public String getBottomText() {
        return this.bottomText;
    }
}
