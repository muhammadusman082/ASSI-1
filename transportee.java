interface Engine {
    void move();
}

interface Driver {
    void navigate();
}

class CombustionEngine implements Engine {
    public void move() {
        System.out.println("Combustion engine moving using fuel...");
    }
}

class ElectricEngine implements Engine {
    public void move() {
        System.out.println("Electric engine moving silently using battery...");
    }
}

class Robot implements Driver {
    public void navigate() {
        System.out.println("Robot navigating automatically using sensors...");
    }
}

class Human implements Driver {
    public void navigate() {
        System.out.println("Human navigating manually using steering...");
    }
}

class Transport {
    private Engine engine;
    private Driver driver;

    public Transport(Engine engine, Driver driver) {
        this.engine = engine;
        this.driver = driver;
    }

    public void deliver(String destination, String cargo) {
        System.out.println("\nStarting delivery of " + cargo + " to " + destination + "...");
        driver.navigate();
        engine.move();
        System.out.println("Delivery of " + cargo + " completed successfully!");
    }
}

public class transportee {
    public static void main(String[] args) {
        Transport truck = new Transport(new CombustionEngine(), new Human());
        truck.deliver("Lahore", "Construction Materials");

        Transport drone = new Transport(new ElectricEngine(), new Robot());
        drone.deliver("Karachi", "Medical Supplies");
    }
}
