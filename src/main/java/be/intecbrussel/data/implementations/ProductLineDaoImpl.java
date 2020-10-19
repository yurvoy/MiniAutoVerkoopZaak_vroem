package be.intecbrussel.data.implementations;

import be.intecbrussel.data.daos.ProductLineDAO;
import be.intecbrussel.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.entities.ProductLine;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class ProductLineDaoImpl implements ProductLineDAO {
    private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();


    @Override
    public void createProductLine(ProductLine productLine) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            if (em.find(ProductLine.class, productLine.getProductLine()) == null){
                em.persist(productLine);
                System.out.println("ProductLine: " + productLine.getProductLine() + " - created");
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
    public ProductLine readProductLine(String productLineName) {
        ProductLine productLine = new ProductLine();
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            productLine = em.find(ProductLine.class, productLineName);
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
    public void updateProductLine(ProductLine productLine) {
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
    public void deleteProductLine(ProductLine productLine) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(productLine);
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

    @Override
    public List<ProductLine> readAllProductLines() {
        EntityManager em = null;
        List<ProductLine> productLinesList = new ArrayList<>();
        try {
            em = emf.createEntityManager();
            productLinesList = em.createQuery("SELECT p FROM ProductLine p", ProductLine.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return productLinesList;
    }
}
