package be.intecbrussel.data.crud_daos;

import be.intecbrussel.entities.ProductLine;

public interface ProductLineDAO {

    void createProductLine(ProductLine productLine);
    ProductLine readProductLine(String productLineName);
    void updateProductLine(ProductLine productLine);
    void deleteProductLine(ProductLine productLine);

}
