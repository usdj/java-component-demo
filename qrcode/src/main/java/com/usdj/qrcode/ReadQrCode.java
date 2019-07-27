package com.usdj.qrcode;

import cn.hutool.extra.qrcode.QrCodeUtil;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gerrydeng
 * @date 2019-07-16 13:57
 * @Description:
 */
public class ReadQrCode {
    public static void main(String[] args) {
        try {
            MultiFormatReader formatReader = new MultiFormatReader();
            File file = new File("/Users/gerrydeng/Desktop/qrcode.png");
            BufferedImage image = ImageIO.read(file);
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
            Map hints = new HashMap(1);
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            Result result = formatReader.decode(binaryBitmap, hints);
            System.out.println("Result格式:" + result.getBarcodeFormat());
            System.out.println("Result内容:" + result.getText());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }


    }
}
