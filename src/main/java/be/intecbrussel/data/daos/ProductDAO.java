package be.intecbrussel.data.daos;

import be.intecbrussel.entities.Product;

import java.util.List;

public interface ProductDAO  {

    void createProduct(Product product);
    Product readProduct(String productCode);
    void updateProduct(Product product);
    void deleteProduct(Product product);
    List<Product> readAllProducts();
}
