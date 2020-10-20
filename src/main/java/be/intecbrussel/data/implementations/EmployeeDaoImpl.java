package be.intecbrussel.data.implementations;

import be.intecbrussel.data.crud_daos.EmployeeDAO;
import be.intecbrussel.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDAO {
    private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();


    @Override
    public void createEmployee(Employee employee) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            if (em.find(Employee.class, employee.getEmployeeNumber()) == null){
                em.persist(employee);
                System.out.println("Employee: " + employee.getEmployeeNumber() + " - created");
            } else {
                em.merge(employee);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Employee readEmployee(int employeeNumber) {
        Employee employee = new Employee();
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            employee = em.find(Employee.class, employeeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.merge(employee);
            transaction.commit();
            System.out.println("Employee: " + employee.getEmployeeNumber() + " - updated");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void deleteEmployee(Employee employee) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            Employee employeeToDelete = em.find(Employee.class, employee.getEmployeeNumber());
            em.remove(employeeToDelete);
            transaction.commit();
            System.out.println("Employee: " + employee.getEmployeeNumber() + " - deleted");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Employee> readAllEmployees() {
        EntityManager em = null;
        List<Employee> employeesList = new ArrayList<>();
        try {
            em = emf.createEntityManager();
            employeesList = em.createQuery("SELECT e FROM Employee e", Employee.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return employeesList;
    }
}
