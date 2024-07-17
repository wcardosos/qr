package dev.wagnercardoso.qr_api.main.services.qr_code;

import dev.wagnercardoso.qr_api.main.entities.MatrixDimensions;
import dev.wagnercardoso.qr_api.main.entities.QrCode;
import dev.wagnercardoso.qr_api.main.entities.QrCodeImage;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AddQrCodeTextService {
    private final QrCodeImage initialQrCodeImage;
    private final MatrixDimensions matrixDimensions;

    private record QrCodeImageDimensions(int width, int height) {}

    public AddQrCodeTextService(QrCodeImage initialQrCodeImage, MatrixDimensions matrixDimensions) {
        this.initialQrCodeImage = initialQrCodeImage;
        this.matrixDimensions = matrixDimensions;
    }

    public BufferedImage execute(String topText, String bottomText) {
        FontMetrics fontMetrics = initialQrCodeImage.getGraphics().getFontMetrics();
        int topTextWidth = buildFontMetricTextWidth(topText, fontMetrics);
        int bottomTextWidth = buildFontMetricTextWidth(bottomText, fontMetrics);;
        QrCodeImageDimensions qrCodeImageDimensions = getFinalImageDimensions(fontMetrics, topTextWidth, bottomTextWidth);

        QrCodeImage finalQrCodeImage = buildQrCodeWithTextImage(qrCodeImageDimensions.width(), qrCodeImageDimensions.height());

        finalQrCodeImage.getGraphics().drawImage(initialQrCodeImage.getImage(), (qrCodeImageDimensions.width() - matrixDimensions.getWidth()) / 2, fontMetrics.getAscent() + 2, null);
        finalQrCodeImage.getGraphics().drawString(topText, (qrCodeImageDimensions.width() - topTextWidth) / 2, fontMetrics.getAscent() + 2);
        finalQrCodeImage.getGraphics().drawString(bottomText, (qrCodeImageDimensions.width() - bottomTextWidth) / 2, qrCodeImageDimensions.height() - fontMetrics.getDescent() - 5);

        return finalQrCodeImage.getImage();
    }

    private int buildFontMetricTextWidth(String text, FontMetrics fontMetrics) {
        return fontMetrics.stringWidth(text);
    }

    private QrCodeImage buildQrCodeWithTextImage(int width, int height) {
        BufferedImage finalImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D finalGraphics = finalImage.createGraphics();
        finalGraphics.setColor(Color.WHITE);
        finalGraphics.fillRect(0, 0, width, height);
        finalGraphics.setColor(Color.BLACK);

        return new QrCodeImage(finalImage, finalGraphics);
    }

    private QrCodeImageDimensions getFinalImageDimensions(FontMetrics fontMetrics, int topTextWidth, int bottomTextWidth) {
        int finalWidth = Math.max(matrixDimensions.getWidth(), Math.max(topTextWidth, bottomTextWidth)) + 1;
        int finalHeight = matrixDimensions.getHeight() + fontMetrics.getHeight() + fontMetrics.getAscent() + 1;

        return new QrCodeImageDimensions(finalWidth, finalHeight);
    }
}
