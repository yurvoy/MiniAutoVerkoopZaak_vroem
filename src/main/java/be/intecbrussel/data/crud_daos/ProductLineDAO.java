package be.intecbrussel.data.crud_daos;

import be.intecbrussel.entities.Productline;

public interface ProductLineDAO {

    void createProductLine(Productline productLine);
    Productline readProductLine(String productLineName);
    void updateProductLine(Productline productLine);
    void deleteProductLine(Productline productLine);

}
