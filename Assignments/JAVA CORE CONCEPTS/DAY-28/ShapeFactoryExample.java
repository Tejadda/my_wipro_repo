package com.DAY_28;
import java.util.HashMap;
import java.util.Map;

// Abstract Shape class
abstract class Shape {
    public abstract void draw();
}

// Concrete Circle class
class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

// Concrete Square class
class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a square");
    }
}

// Concrete Rectangle class
class Rectangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

// ShapeFactory class
class ShapeFactory {
    private static final Map<String, Class<? extends Shape>> shapeMap = new HashMap<>();

    static {
        shapeMap.put("circle", Circle.class);
        shapeMap.put("square", Square.class);
        shapeMap.put("rectangle", Rectangle.class);
    }

    public static Shape createShape(String shapeType) {
        Class<? extends Shape> shapeClass = shapeMap.get(shapeType);
        if (shapeClass!= null) {
            try {
                return shapeClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                System.err.println("Error creating shape: " + e.getMessage());
            }
        }
        return null;
    }
}

// Main class
public class ShapeFactoryExample {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.createShape("circle");
        circle.draw(); // Output: Drawing a circle

        Shape square = ShapeFactory.createShape("square");
        square.draw(); // Output: Drawing a square

        Shape rectangle = ShapeFactory.createShape("rectangle");
        rectangle.draw(); // Output: Drawing a rectangle
    }
}
