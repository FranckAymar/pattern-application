package solid.singleresponsibility;

/**
 * GOOD: Single Responsibility Principle
 * Each class has only one reason to change
 */

// Class 1: Only responsible for user data
public class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User: " + name + ", Email: " + email;
    }
}

// Class 2: Only responsible for saving to file
class UserFileRepository {
    public void saveToFile(User user, String filename) {
        System.out.println("Saving user " + user.getName() + " to " + filename);
        // File writing logic...
    }
}

// Class 3: Only responsible for saving to database
class UserDatabaseRepository {
    public void saveToDatabase(User user) {
        System.out.println("Saving user " + user.getName() + " to database");
        // Database logic...
    }
}

// Client usage
class GoodSRP {
    public static void main(String[] args) {
        User user = new User("John Doe", "john@example.com");

        UserFileRepository fileRepo = new UserFileRepository();
        fileRepo.saveToFile(user, "users.txt");

        UserDatabaseRepository dbRepo = new UserDatabaseRepository();
        dbRepo.saveToDatabase(user);
    }
}
