package org.example;

import io.javalin.Javalin;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Scanner;

public class Main {
   /* public static void main(String[] args) {
        System.out.println("Hello world!");

        var app = Javalin.create().get("/", ctx -> ctx.result("Hello World")).start();
        app.get("/",context -> {
            context.result("Hello World");
        });
    }

    */

    public static void main(String[] args) {

        int L = 500;
        int H = 100;


        BufferedImage image = new BufferedImage(L, H, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("SansSerif", Font.BOLD, 24));

        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString("╭∩╮ (òÓ,) ╭∩╮", 10, 20);

        for (int y = 0; y < H; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < L; x++) {
                sb.append(image.getRGB(x, y) == -16777216 ? " " : "#");
            }
            if (sb.toString().trim().isEmpty()) {
                continue;
            }
            System.out.println(sb);
        }
    }
}