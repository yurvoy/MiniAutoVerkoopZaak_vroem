package be.intecbrussel.data.implementations;

import be.intecbrussel.data.crud_daos.ProductLineDAO;
import be.intecbrussel.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.entities.Productline;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;


public class ProductLineDaoImpl implements ProductLineDAO {
    private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();


    @Override
    public void createProductLine(Productline productLine) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            if (em.find(Productline.class, productLine.getProductLine()) == null){
                em.persist(productLine);
                System.out.println("Productline: " + productLine.getProductLine() + " - created");
            } else {
                em.merge(productLine);
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
    public Productline readProductLine(String productLineName) {
        Productline productLine = new Productline();
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            productLine = em.find(Productline.class, productLineName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return productLine;
    }

    @Override
    public void updateProductLine(Productline productLine) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.merge(productLine);
            transaction.commit();
            System.out.println("ProductLine: " + productLine.getProductLine() + " - updated");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void deleteProductLine(Productline productLine) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            Productline plToDelete = em.find(Productline.class, productLine.getProductLine());
            em.remove(plToDelete);
            transaction.commit();
            System.out.println("ProductLine: " + productLine.getProductLine() + " - deleted");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
