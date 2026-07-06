package solid.singleresponsibility;

/**
 * BAD: Single Responsibility Principle Violation
 * This class has multiple responsibilities: managing user data and saving to file
 */
public class BadSRP {
    private String name;
    private String email;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Responsibility 1: User data management
    public String getUser() {
        return "User: " + name + ", Email: " + email;
    }

    // Responsibility 2: File operations (SHOULD NOT BE HERE)
    public void saveToFile(String filename) {
        System.out.println("Saving user " + name + " to " + filename);
        // File writing logic...
    }

    // Responsibility 3: Database operations (SHOULD NOT BE HERE)
    public void saveToDatabase() {
        System.out.println("Saving user " + name + " to database");
        // Database logic...
    }
}
