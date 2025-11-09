package com.solid.lab.service;

import com.solid.lab.shapes.Shape;
import java.util.List;

public class AreaPrinter {

    public void printAreas(List<Shape> shapes) {
        for (int i = 0; i < shapes.size(); i++) {
            Shape shape = shapes.get(i);
            System.out.printf("Shape %d area: %.2f%n", i + 1, shape.calculateArea());
        }
    }

    public void printTotalArea(double totalArea) {
        System.out.printf("Total area: %.2f%n", totalArea);
    }
}