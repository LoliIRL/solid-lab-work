package com.solid.lab.service;

import com.solid.lab.shapes.Circle;
import com.solid.lab.shapes.Rectangle;
import com.solid.lab.shapes.Shape;
import com.solid.lab.shapes.Square;

public class ShapeFactory {

    public Shape createCircle(double radius) {
        return new Circle(radius);
    }

    public Shape createRectangle(double width, double height) {
        return new Rectangle(width, height);
    }

    public Shape createSquare(double side) {
        return new Square(side);
    }
}