package dev.wagnercardoso.qr_api.main.controllers;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import dev.wagnercardoso.qr_api.main.entities.MatrixDimensions;
import dev.wagnercardoso.qr_api.main.entities.QrCode;
import dev.wagnercardoso.qr_api.main.entities.QrCodeImage;
import dev.wagnercardoso.qr_api.main.services.qr_code.AddQrCodeTextService;
import dev.wagnercardoso.qr_api.main.services.qr_code.BuildQrCodeMatrixDimensions;
import dev.wagnercardoso.qr_api.main.services.qr_code.GenerateQrCodeImageBytes;
import dev.wagnercardoso.qr_api.main.services.qr_code.GenerateQrCodeImageService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.zxing.qrcode.QRCodeWriter;
import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/qr-code")
public class QrCodeController {
    @PostMapping("/generate")
        public ResponseEntity<byte[]> generateQrCode(@RequestBody QrCode qrCode) throws WriterException, IOException {
            BuildQrCodeMatrixDimensions buildQrCodeMatrixDimensions = new BuildQrCodeMatrixDimensions();
            MatrixDimensions matrixDimensions = buildQrCodeMatrixDimensions.execute(qrCode.getUrl());

            GenerateQrCodeImageService generateQrCodeService = new GenerateQrCodeImageService(matrixDimensions);
            QrCodeImage qrCodeImage = generateQrCodeService.execute(qrCode.getUrl());

            AddQrCodeTextService addQrCodeTextService = new AddQrCodeTextService(qrCodeImage, matrixDimensions);
            BufferedImage finalImage = addQrCodeTextService.execute(qrCode.getTopText(), qrCode.getBottomText());

            GenerateQrCodeImageBytes generateQrCodeImageBytes = new GenerateQrCodeImageBytes();
            byte[] imageBytes = generateQrCodeImageBytes.execute(finalImage);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);

            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        }
}
