package dev.wagnercardoso.qr_api.main.services.qr_code;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import dev.wagnercardoso.qr_api.main.entities.MatrixDimensions;
import dev.wagnercardoso.qr_api.main.entities.QrCodeImage;

import java.awt.*;
import java.awt.image.BufferedImage;


public class GenerateQrCodeImageService {
    private final QRCodeWriter barcodeWriter;
    private final MatrixDimensions matrixDimensions;
    private BufferedImage image;

    public GenerateQrCodeImageService(MatrixDimensions matrixDimensions) {
        this.barcodeWriter = new QRCodeWriter();
        this.matrixDimensions = matrixDimensions;
    }

    public QrCodeImage execute(String url) throws WriterException {
        Graphics2D graphics = prepareGraphics();

        drawGraphics(graphics);

        return new QrCodeImage(image, graphics);
    }

    private BitMatrix buildMatrix(String url) throws WriterException {
        int WIDTH = 200;
        int HEIGHT = 200;

        return barcodeWriter.encode(url, BarcodeFormat.QR_CODE, WIDTH, HEIGHT);
    }

    private Graphics2D prepareGraphics() {
        buildImage();
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, matrixDimensions.getWidth(), matrixDimensions.getHeight());
        graphics.setColor(Color.BLACK);

        return graphics;
    }

    private void drawGraphics(Graphics2D graphics) {
        for (int i = 0; i < matrixDimensions.getWidth(); i++) {
            for (int j = 0; j < matrixDimensions.getHeight(); j++) {
                if (matrixDimensions.getMatrix().get(i, j)) {
                    graphics.fillRect(i, j, 1, 1);
                }
            }
        }
    }

    private void buildImage() {
        if (image == null) {
            this.image = new BufferedImage(matrixDimensions.getWidth(), matrixDimensions.getHeight(), BufferedImage.TYPE_INT_RGB);
        }
    }

    private MatrixDimensions getMatrixDimensions() {
        return matrixDimensions;
    }
}
