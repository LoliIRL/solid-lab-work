package com.solid.lab;

import com.solid.lab.service.AreaCalculator;
import com.solid.lab.service.AreaPrinter;
import com.solid.lab.service.ShapeFactory;
import com.solid.lab.shapes.Shape;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем фабрику для создания фигур (Dependency Injection)
        ShapeFactory factory = new ShapeFactory();

        // Создаем список фигур
        List<Shape> shapes = new ArrayList<>();
        shapes.add(factory.createCircle(5.0));
        shapes.add(factory.createRectangle(4.0, 6.0));
        shapes.add(factory.createSquare(3.0));
        shapes.add(factory.createCircle(2.5));

        // Вычисляем площади (SRP - отдельный сервис для вычислений)
        AreaCalculator calculator = new AreaCalculator();
        double totalArea = calculator.calculateTotalArea(shapes);

        // Выводим результаты (SRP - отдельный сервис для вывода)
        AreaPrinter printer = new AreaPrinter();
        printer.printAreas(shapes);
        printer.printTotalArea(totalArea);

        // Демонстрация LSP - все фигуры взаимозаменяемы
        System.out.println("\nLSP Demonstration:");
        demonstrateLSP(shapes);
    }

    private static void demonstrateLSP(List<Shape> shapes) {
        AreaCalculator calculator = new AreaCalculator();

        // Мы можем использовать любую подпоследовательность фигур
        // без нарушения работы программы (LSP)
        for (int i = 0; i < shapes.size(); i++) {
            List<Shape> subList = shapes.subList(0, i + 1);
            double subTotal = calculator.calculateTotalArea(subList);
            System.out.printf("Area of first %d shapes: %.2f%n", i + 1, subTotal);
        }
    }
}