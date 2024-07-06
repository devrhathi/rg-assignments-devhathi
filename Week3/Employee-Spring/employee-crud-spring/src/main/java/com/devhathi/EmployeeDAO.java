package com.devhathi;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.JdbcUpdateAffectedIncorrectNumberOfRowsException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveEmployee(Employee employee) {
        String sql = "INSERT INTO employee (id, name, department) VALUES (?, ?, ?)";
        int res = jdbcTemplate.update(sql, employee.getId(), employee.getName(),
                employee.getDepartment());
        if (res > 0) {
            System.out.println("\nInserted following Employee to Database:");
            System.out.println(employee);
        } else {
            throw new JdbcUpdateAffectedIncorrectNumberOfRowsException(sql, 1, res);
        }

    }

    public Employee getEmployeeById(int id) {
        String sql = "SELECT * from employee e WHERE e.id=?";
        Employee employee = jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), id);
        if (employee == null) {
            System.out.println("Employee not found");
        } else {
            System.out.println("\nRead following employee with id " + id + ":");
            System.out.println(employee);
        }
        return employee;
    }

    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employee e SET e.name=?, e.department=? WHERE e.id=?";
        int res = jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(),
                employee.getId());
        if (res > 0) {
            System.out.println("\nUpdated following Employee to Database:");
            System.out.println(employee);
        } else {
            throw new JdbcUpdateAffectedIncorrectNumberOfRowsException(sql, 1, res);
        }
    }

    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employee e WHERE e.id=?";
        int res = jdbcTemplate.update(sql, id);
        if (res > 0) {
            System.out.println("\nDeleted employee with id " + id + " from Database");
        } else {
            throw new JdbcUpdateAffectedIncorrectNumberOfRowsException(sql, 1, res);
        }
    }

    private static class EmployeeRowMapper implements RowMapper<Employee> {

        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setDepartment(rs.getString("department"));
            return employee;
        }
    }
}
