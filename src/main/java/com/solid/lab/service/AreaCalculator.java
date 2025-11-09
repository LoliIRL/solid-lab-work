package com.solid.lab.service;

import com.solid.lab.shapes.Shape;
import java.util.List;

public class AreaCalculator {

    public double calculateTotalArea(List<Shape> shapes) {
        return shapes.stream()
                .mapToDouble(Shape::calculateArea)
                .sum();
    }
}