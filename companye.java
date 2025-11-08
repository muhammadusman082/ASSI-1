import java.util.List;
import java.util.ArrayList;

interface Employee {
    void doWork();
}

class Designer implements Employee {
    public void doWork() {
        System.out.println("Designer is designing the UI/UX...");
    }
}

class Programmer implements Employee {
    public void doWork() {
        System.out.println("Programmer is writing code...");
    }
}

class Tester implements Employee {
    public void doWork() {
        System.out.println("Tester is testing the application...");
    }
}

class Artist implements Employee {
    public void doWork() {
        System.out.println("Artist is creating game art...");
    }
}

abstract class Company {
    abstract List<Employee> getEmployees();

    public void createSoftware() {
        List<Employee> employees = getEmployees();
        for (Employee e : employees) {
            e.doWork();
        }
        System.out.println("Software creation completed!\n");
    }
}

class GameDevCompany extends Company {
    List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Designer());
        employees.add(new Artist());
        return employees;
    }
}

class OutsourcingCompany extends Company {
    List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Programmer());
        employees.add(new Tester());
        return employees;
    }
}

public class companye {
    public static void main(String[] args) {
        Company gameDev = new GameDevCompany();
        System.out.println("=== Game Development Company ===");
        gameDev.createSoftware();

        Company outsourcing = new OutsourcingCompany();
        System.out.println("=== Outsourcing Company ===");
        outsourcing.createSoftware();
    }
}
