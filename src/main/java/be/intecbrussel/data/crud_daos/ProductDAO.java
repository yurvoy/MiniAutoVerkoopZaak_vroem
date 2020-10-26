package be.intecbrussel.data.crud_daos;


import be.intecbrussel.entities.Product;

public interface ProductDAO  {

    void createProduct(Product product);
    Product readProduct(String productCode);
    void updateProduct(Product product);
    void deleteProduct(Product product);
}
