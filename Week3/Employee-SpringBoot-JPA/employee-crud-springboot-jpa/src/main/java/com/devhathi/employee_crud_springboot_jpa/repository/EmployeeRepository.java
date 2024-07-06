package com.devhathi.employee_crud_springboot_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devhathi.employee_crud_springboot_jpa.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
