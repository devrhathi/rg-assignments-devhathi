import java.util.ArrayList;

class Employee {
    private int id;
    private String name;
    private String department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format("\nEmployee ID: %d\nEmployee Name: %s\nEmployee Department: %s", this.id, this.name,
                this.department);
    }
}

class EmployeeCRUD {
    private ArrayList<Employee> employees;

    public EmployeeCRUD() {
        this.employees = new ArrayList<>();
    }

    public void create(Employee employee) {
        employees.add(employee);
        System.out.println("\nAdded following employee:");
        System.out.println(employee);
    }

    public void read(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.println(String.format("\nReading employee with ID %d:", id));
                System.out.println(
                        employee);
                return;
            }
        }
        System.out.println(String.format("\nEmployee with ID %d not found.", id));
    }

    public void update(int id, Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                employees.set(i, employee);
                System.out.println(String.format("\nEmployee with ID %d is updated.", id));
                return;
            }
        }
        System.out.println(String.format("\nEmployee with ID %d not found.", id));
    }

    public void delete(int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                employees.remove(i);
                System.out.println(String.format("\nEmployee with ID %d is deleted.", id));
                return;
            }
        }
        System.out.println(String.format("\nEmployee with ID %d not found.", id));
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        EmployeeCRUD empCRUD = new EmployeeCRUD();

        // create employees
        Employee emp1 = new Employee(1, "John Wick", "IT");
        Employee emp2 = new Employee(2, "Bryce", "Marketing");

        // create operation
        empCRUD.create(emp1);
        empCRUD.create(emp2);

        // read operation
        empCRUD.read(1);

        // update operation
        empCRUD.update(2, new Employee(2, "Duncan", "Sales"));
        empCRUD.read(2);

        // delete operation
        empCRUD.delete(1);
        empCRUD.read(1);
    }
}
