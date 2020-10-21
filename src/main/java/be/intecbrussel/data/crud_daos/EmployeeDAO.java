package be.intecbrussel.data.crud_daos;

import be.intecbrussel.entities.Employee;

public interface EmployeeDAO {

    void createEmployee(Employee employee);
    Employee readEmployee(int employeeId);
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
}
