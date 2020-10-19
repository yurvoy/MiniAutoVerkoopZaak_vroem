package be.intecbrussel.data.daos;

import be.intecbrussel.entities.Office;

import java.util.List;

public interface OfficeDAO {

    void createOffice(Office office);
    Office readOffice(int officeCode);
    void updateOffice(Office office);
    void deleteOffice(Office office);
    List<Office> readAllOffices();
}
