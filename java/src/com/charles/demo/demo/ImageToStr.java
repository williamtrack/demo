package com.charles.demo.demo;

import com.charles.demo.Constant;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//将图像转成字符画
public class ImageToStr {
    public static void test() {
        ImageToStr.createAsciiPic(Constant.path_res + "test.png");
    }

    public static void createAsciiPic(final String path) {
        final String base = "@#&$%*o!;. ";// 字符串由复杂到简单
//        final String base = "KSPksp;.";
        try {
            final BufferedImage image = ImageIO.read(new File(path));
            System.out.println("W:" + image.getWidth() + " H:" + image.getHeight());
            for (int y = 0; y < image.getHeight(); y += 2) {
                for (int x = 0; x < image.getWidth(); x++) {
                    final int pixel = image.getRGB(x, y);
                    final int r = (pixel & 0xff0000) >> 16, g = (pixel & 0xff00) >> 8, b = pixel & 0xff;
                    final float gray = 0.299f * r + 0.578f * g + 0.114f * b;
                    final int index = Math.round(gray * (base.length() + 1) / 255);
                    System.out.print(index >= base.length() ? " " : String.valueOf(base.charAt(index)));
                }
                System.out.println();
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
