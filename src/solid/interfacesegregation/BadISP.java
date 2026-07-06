package solid.interfacesegregation;

/**
 * BAD: Interface Segregation Principle Violation
 * Clients are forced to implement methods they don't need
 */

// Fat interface with too many responsibilities
interface Worker {
    void work();
    void eat();
    void code();
    void test();
    void design();
}

// Robot doesn't eat but must implement it
class Robot implements Worker {
    @Override
    public void work() {
        System.out.println("Robot is working...");
    }

    @Override
    public void eat() {
        // Robot doesn't eat! But forced to implement
        throw new UnsupportedOperationException("Robot cannot eat");
    }

    @Override
    public void code() {
        System.out.println("Robot is coding...");
    }

    @Override
    public void test() {
        System.out.println("Robot is testing...");
    }

    @Override
    public void design() {
        throw new UnsupportedOperationException("Robot cannot design");
    }
}

// Human developer
class Developer implements Worker {
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

class BadISP {
    public static void main(String[] args) {
        Worker robot = new Robot();
        robot.work();
        // robot.eat(); // Would throw exception!
    }
}
