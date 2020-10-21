package be.intecbrussel.data.crud_daos;

import be.intecbrussel.entities.Office;

public interface OfficeDAO {

    void createOffice(Office office);
    Office readOffice(String officeCode);
    void updateOffice(Office office);
    void deleteOffice(Office office);

}
