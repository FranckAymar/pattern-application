package solid.liskovsubstitution;

/**
 * GOOD: Liskov Substitution Principle
 * Subclasses are properly substitutable for their base type
 * Use composition or create appropriate hierarchy
 */

// Common interface for shapes
interface Shape {
    int getArea();
}

// Rectangle: can have different width and height
class GoodRectangle implements Shape {
    private int width;
    private int height;

    public GoodRectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getArea() {
        return width * height;
    }
}

// Square: enforces equal sides (separate concern)
class GoodSquare implements Shape {
    private int side;

    public GoodSquare(int side) {
        this.side = side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public int getArea() {
        return side * side;
    }
}

// Good client code
class GoodLSP {
    public static void printArea(Shape shape) {
        System.out.println("Area: " + shape.getArea());
    }

    public static void main(String[] args) {
        Shape rectangle = new GoodRectangle(5, 4);
        Shape square = new GoodSquare(4);

        printArea(rectangle); // 20
        printArea(square);    // 16

        // Each shape behaves correctly according to its contract
    }
}
