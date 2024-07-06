package com.devhathi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO;
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                EmployeeConfig.class)) {
            employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");
        }

        Employee employee = new Employee(1, "John", "IT");
        Employee employee2 = new Employee(2, "Duncan", "Marketing");

        // Create operation
        employeeDAO.saveEmployee(employee);
        employeeDAO.saveEmployee(employee2);

        // Read operation
        Employee employee3 = employeeDAO.getEmployeeById(1);

        // Update operation
        employee3.setName("Bryce");
        employee3.setDepartment("Sales");
        employeeDAO.updateEmployee(employee3);

        // Delete operation
        employeeDAO.deleteEmployee(2);

    }
}