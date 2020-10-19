package be.intecbrussel.data.daos;

import be.intecbrussel.entities.ProductLine;

import java.util.List;

public interface ProductLineDAO {

    void createProductLine(ProductLine productLine);
    ProductLine readProductLine(String productLineName);
    void updateProductLine(ProductLine productLine);
    void deleteProductLine(ProductLine productLine);
    List<ProductLine> readAllProductLines();
}
