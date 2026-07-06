package solid.openclosed;

/**
 * BAD: Open/Closed Principle Violation
 * The class is not open for extension and is closed for modification
 * We need to modify the class every time we add a new shape
 */
public class BadOCP {

    public double calculateArea(String shapeType, double dimension1, double dimension2) {
        if (shapeType.equals("circle")) {
            return Math.PI * dimension1 * dimension1;
        } else if (shapeType.equals("rectangle")) {
            return dimension1 * dimension2;
        } else if (shapeType.equals("triangle")) {
            return 0.5 * dimension1 * dimension2;
        }
        // Every time we add a new shape, we must modify this method!
        throw new IllegalArgumentException("Unknown shape: " + shapeType);
    }
}
