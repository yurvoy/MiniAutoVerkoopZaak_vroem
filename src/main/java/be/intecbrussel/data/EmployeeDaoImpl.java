package be.intecbrussel.data;

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
            em.persist(employee);
            transaction.commit();
            if (employee != null) {
                System.out.println("Employee: " + employee.getFirstName() + " "+ employee.getLastName() + " - created");
            }
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
            System.out.println("Customer: " + employee.getFirstName() + " "+ employee.getLastName() + " - updated");
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
            em.remove(employee);
            transaction.commit();
            System.out.println("Customer: " + employee.getFirstName() + " "+ employee.getLastName() + " - deleted");
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
