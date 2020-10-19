package be.intecbrussel.data.daos;

import be.intecbrussel.entities.Employee;

import java.util.List;

public interface EmployeeDAO {

    void createEmployee(Employee employee);
    Employee readEmployee(int employeeId);
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);

    List<Employee> readAllEmployees();
}
