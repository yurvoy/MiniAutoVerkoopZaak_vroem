package be.intecbrussel.data.implementations;

import be.intecbrussel.data.daos.ProductDAO;
import be.intecbrussel.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.entities.Employee;
import be.intecbrussel.entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDAO {
    private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();

    @Override
    public void createProduct(Product product) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            if (em.find(Product.class, product.getProductCode()) == null){
                em.persist(product);
                System.out.println("Product: " + product.getProductCode() + " - created");
            } else {
                em.merge(product);
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
    public Product readProduct(String productCode) {
        Product product = new Product();
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            product = em.find(Product.class, productCode);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return product;
    }

    @Override
    public void updateProduct(Product product) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.merge(product);
            transaction.commit();
            System.out.println("Product: " + product.getProductCode() + " - updated");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void deleteProduct(Product product) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            Product productToDelete = em.find(Product.class, product.getProductCode());
            em.remove(productToDelete);
            transaction.commit();
            System.out.println("Product: " + product.getProductCode() + " - deleted");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Product> readAllProducts() {
        EntityManager em = null;
        List<Product> productsList = new ArrayList<>();
        try {
            em = emf.createEntityManager();
            productsList = em.createQuery("SELECT p FROM Product p", Product.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return productsList;
    }
}
