package solid.openclosed;

/**
 * GOOD: Open/Closed Principle
 * Open for extension (new shapes can be added)
 * Closed for modification (existing code doesn't need to change)
 */

// Interface: closed for modification, open for extension
interface Shape {
    double calculateArea();
}

// Concrete implementations: new shapes without modifying existing code
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

// New shape can be added without changing existing code
class Pentagon implements Shape {
    private double side;

    public Pentagon(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return (Math.sqrt(25 + 10 * Math.sqrt(5)) / 4) * side * side;
    }
}

// AreaCalculator: closed for modification
class AreaCalculator {
    public double calculateArea(Shape shape) {
        return shape.calculateArea();
    }

    public double calculateTotalArea(Shape[] shapes) {
        double total = 0;
        for (Shape shape : shapes) {
            total += shape.calculateArea();
        }
        return total;
    }
}

// Client usage
class GoodOCP {
    public static void main(String[] args) {
        AreaCalculator calculator = new AreaCalculator();

        Shape[] shapes = {
                new Circle(5),
                new Rectangle(4, 6),
                new Triangle(3, 4),
                new Pentagon(5)
        };

        System.out.println("Total area: " + calculator.calculateTotalArea(shapes));
    }
}
