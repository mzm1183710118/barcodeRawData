package org.example;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SelfScanner {
    private String path;
    public SelfScanner(String path) {
        this.path = path;
    }

    public byte[] detectBitMatrixFrom() {
        try {
            BufferedImage bf = ImageIO.read(Files.newInputStream(Paths.get(this.path)));
            BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(bf);
            HybridBinarizer hybridBinarizer = new HybridBinarizer(source);
            BinaryBitmap bitmap = new BinaryBitmap(hybridBinarizer);
            // detect
            MultiFormatReader reader = new MultiFormatReader();
            Result result = reader.decode(bitmap);
            return result.getRawBytes();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

