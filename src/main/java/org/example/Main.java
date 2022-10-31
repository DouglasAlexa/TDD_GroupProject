package org.example;

import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        var app = Javalin.create().get("/", ctx -> ctx.result("Hello World")).start();
        app.get("/",context -> {
            context.result("Hello World");
        });
    }
}