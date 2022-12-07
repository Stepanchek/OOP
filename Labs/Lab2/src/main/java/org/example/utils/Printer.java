package org.example.utils;

import org.example.classes.Flower;

import java.util.List;

public class Printer {
    private Printer(){}

    public static void print(List<Flower> flowers){
        for (Flower flower : flowers){
            System.out.println(flower);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }
}
