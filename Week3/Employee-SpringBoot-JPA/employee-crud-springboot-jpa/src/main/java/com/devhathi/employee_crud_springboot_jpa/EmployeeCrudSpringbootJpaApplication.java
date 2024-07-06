package com.devhathi.employee_crud_springboot_jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devhathi.employee_crud_springboot_jpa.entity.Employee;
import com.devhathi.employee_crud_springboot_jpa.service.EmployeeService;

@SpringBootApplication
public class EmployeeCrudSpringbootJpaApplication implements CommandLineRunner {

	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeCrudSpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Create Operation
		Employee employee1 = new Employee("John Wick", "IT");
		Employee createdEmployee1 = employeeService.createEmployee(employee1);
		System.out.println("\nFollowing employee has been created in database:");
		System.out.println(createdEmployee1);

		Employee employee2 = new Employee("Duncan", "Marketing");
		Employee createdEmployee2 = employeeService.createEmployee(employee2);
		System.out.println("\nFollowing employee has been created in database:");
		System.out.println(createdEmployee2);

		// Read Operation
		Long id = employee1.getId();
		Employee employee3 = employeeService.getEmployeeById(id);
		if (employee3 == null)
			System.out.println("\nCould not find employee with id " + id);
		else {
			System.out.println("\nEmployee Read from database:");
			System.out.println(employee3);
		}

		// Update employee
		employee3.setName("Bryce Myers");
		employee3.setDepartment("Sales");
		Employee updatedEmployee = employeeService.updateEmployee(employee3);
		System.out.println("\nFollowing employee has been updated in database:");
		System.out.println(updatedEmployee);

		// Delete employee
		Long idDelete = employee3.getId();
		employeeService.deleteEmployee(idDelete);
		System.out.println("\nEmployee with id " + idDelete + " has been deleted from database");

	}

}
