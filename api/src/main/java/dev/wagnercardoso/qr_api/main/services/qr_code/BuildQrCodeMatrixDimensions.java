package dev.wagnercardoso.qr_api.main.services.qr_code;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import dev.wagnercardoso.qr_api.main.entities.MatrixDimensions;

public class BuildQrCodeMatrixDimensions {
    private final QRCodeWriter barcodeWriter;

    public BuildQrCodeMatrixDimensions() {
        this.barcodeWriter = new QRCodeWriter();
    }

    public MatrixDimensions execute(String qrCodeUrl) throws WriterException {
        BitMatrix matrix = buildMatrix(qrCodeUrl);
        return new MatrixDimensions(matrix.getWidth(), matrix.getHeight(), matrix);
    }

    private BitMatrix buildMatrix(String url) throws WriterException {
        int WIDTH = 200;
        int HEIGHT = 200;

        return barcodeWriter.encode(url, BarcodeFormat.QR_CODE, WIDTH, HEIGHT);
    }
}
