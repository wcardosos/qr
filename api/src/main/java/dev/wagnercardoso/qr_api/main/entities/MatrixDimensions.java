package dev.wagnercardoso.qr_api.main.entities;

import com.google.zxing.common.BitMatrix;

public class MatrixDimensions {
    private final int width;
    private final int height;
    private final BitMatrix matrix;

    public MatrixDimensions(int width, int height, BitMatrix matrix) {
        this.width = width;
        this.height = height;
        this.matrix = matrix;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public BitMatrix getMatrix() {
        return this.matrix;
    }
}
