package solid.interfacesegregation;

/**
 * GOOD: Interface Segregation Principle
 * Split fat interfaces into smaller, more specific ones
 * Clients depend only on methods they actually use
 */

// Segregated interfaces
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

interface Codeable {
    void code();
}

interface Testable {
    void test();
}

interface Designable {
    void design();
}

// Robot implements only what it needs
class GoodRobot implements Workable, Codeable, Testable {
    @Override
    public void work() {
        System.out.println("Robot is working...");
    }

    @Override
    public void code() {
        System.out.println("Robot is coding...");
    }

    @Override
    public void test() {
        System.out.println("Robot is testing...");
    }
}

// Developer implements all relevant interfaces
class GoodDeveloper implements Workable, Eatable, Codeable, Testable, Designable {
    @Override
    public void work() {
        System.out.println("Developer is working...");
    }

    @Override
    public void eat() {
        System.out.println("Developer is eating...");
    }

    @Override
    public void code() {
        System.out.println("Developer is coding...");
    }

    @Override
    public void test() {
        System.out.println("Developer is testing...");
    }

    @Override
    public void design() {
        System.out.println("Developer is designing...");
    }
}

// Manager only needs work and design
class Manager implements Workable, Designable, Eatable {
    @Override
    public void work() {
        System.out.println("Manager is working...");
    }

    @Override
    public void design() {
        System.out.println("Manager is planning design...");
    }

    @Override
    public void eat() {
        System.out.println("Manager is eating...");
    }
}

class GoodISP {
    public static void main(String[] args) {
        GoodRobot robot = new GoodRobot();
        robot.work();
        robot.code();

        GoodDeveloper developer = new GoodDeveloper();
        developer.eat();
        developer.code();

        Manager manager = new Manager();
        manager.design();
        // No unnecessary methods!
    }
}
