import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

}

class EmployeeJDBC {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/question7";
    private static final String USER = "YOUR_USERNAME";
    private static final String PASSWORD = "YOUR_PASSWORD";
    private static final String CREATE_EMPLOYEE_SQL = "INSERT INTO Employee (id, name, department) VALUES (?, ?, ?)";
    private static final String READ_EMPLOYEE_SQL = "SELECT * FROM Employee WHERE id = ?";
    private static final String UPDATE_EMPLOYEE_SQL = "UPDATE Employee SET name = ?, department = ? WHERE id = ?";
    private static final String DELETE_EMPLOYEE_SQL = "DELETE FROM Employee WHERE id = ?";

    public void createEmployee(Employee employee) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(CREATE_EMPLOYEE_SQL);
        statement.setInt(1, employee.getId());
        statement.setString(2, employee.getName());
        statement.setString(3, employee.getDepartment());
        statement.executeUpdate();
        statement.close();
        connection.close();
        System.out.println(String.format(
                "\nCreated following employee:\nEmployee ID: %d\nEmployee Name: %s\nEmployee Department: %s",
                employee.getId(), employee.getName(), employee.getDepartment()));
    }

    public Employee readEmployee(int id) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(READ_EMPLOYEE_SQL);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Employee employee = null;
        if (resultSet.next()) {
            employee = new Employee(resultSet.getInt("id"), resultSet.getString("name"),
                    resultSet.getString("department"));
            System.out.println(String.format(
                    "\nRead following employee:\nEmployee ID: %d\nEmployee Name: %s\nEmployee Department: %s",
                    employee.getId(), employee.getName(), employee.getDepartment()));
        }
        resultSet.close();
        statement.close();
        connection.close();

        return employee;
    }

    public void updateEmployee(Employee employee) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);
        statement.setString(1, employee.getName());
        statement.setString(2, employee.getDepartment());
        statement.setInt(3, employee.getId());
        statement.executeUpdate();
        statement.close();
        connection.close();
        System.out.println(String.format(
                "\nUpdated employee with ID: %d\nUpdated Employee Name: %s\nUpdated Employee Department: %s",
                employee.getId(), employee.getName(), employee.getDepartment()));
    }

    public void deleteEmployee(int id) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
        connection.close();
        System.out.println(String.format(
                "\nDeleted employee with Employee ID: %d",
                id));
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }
}

public class Main {
    public static void main(String[] args) throws SQLException {
        EmployeeJDBC employeeJDBC = new EmployeeJDBC();

        // create operation
        Employee employee1 = new Employee(1, "John Wick", "IT");
        employeeJDBC.createEmployee(employee1);
        Employee employee2 = new Employee(2, "Bryce Myers", "Marketing");
        employeeJDBC.createEmployee(employee2);

        // read operation
        Employee employee3 = employeeJDBC.readEmployee(1);

        // update operation
        employee3.setName("Duncan");
        employee3.setDepartment("Sales");
        employeeJDBC.updateEmployee(employee3);

        // delete operation
        employeeJDBC.deleteEmployee(1);
    }
}