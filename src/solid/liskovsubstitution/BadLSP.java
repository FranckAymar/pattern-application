package solid.liskovsubstitution;

/**
 * BAD: Liskov Substitution Principle Violation
 * Square violates LSP because it cannot be substituted for Rectangle
 * while maintaining the expected behavior
 */

class Rectangle {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

// This violates LSP!
class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width; // Force square property
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
        this.width = height; // Force square property
    }
}

// Bad client code
class BadLSP {
    public static void printArea(Rectangle rect) {
        rect.setWidth(5);
        rect.setHeight(4);
        System.out.println("Area: " + rect.getArea());
        // Expected: 20, but with Square: 16 (4*4)
    }

    public static void main(String[] args) {
        printArea(new Rectangle()); // Works fine: 5 * 4 = 20
        printArea(new Square());    // Breaks LSP: 4 * 4 = 16, not 20!
    }
}
