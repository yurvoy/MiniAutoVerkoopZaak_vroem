package be.intecbrussel.data.implementations;

import be.intecbrussel.data.daos.OfficeDAO;
import be.intecbrussel.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.entities.Employee;
import be.intecbrussel.entities.Office;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class OfficeDaoImpl implements OfficeDAO {
    private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();

    @Override
    public void createOffice(Office office) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            if (em.find(Office.class, office.getOfficeCode()) == null){
                em.persist(office);
                System.out.println("Office: " + office.getOfficeCode() + " - created");
            } else {
                em.merge(office);
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
    public Office readOffice(String officeCode) {
        Office office = new Office();
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            office = em.find(Office.class, officeCode);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return office;
    }

    @Override
    public void updateOffice(Office office) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.merge(office);
            transaction.commit();
            System.out.println("Office: " + office.getOfficeCode() + " - updated");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void deleteOffice(Office office) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            Office officeToDelete = em.find(Office.class, office.getOfficeCode());
            em.remove(officeToDelete);
            transaction.commit();
            System.out.println("Office: " + office.getOfficeCode() + " - deleted");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Office> readAllOffices() {
        EntityManager em = null;
        List<Office> officesList = new ArrayList<>();
        try {
            em = emf.createEntityManager();
            officesList = em.createQuery("SELECT o FROM Office o", Office.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return officesList;
    }
}
