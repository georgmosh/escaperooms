package gr.aueb.softeng.project1809.dao;

import java.util.List;

/**
* This class illustrates a sample data base object interface for Customers.
*/
public interface CustomersDAO extends UsersDAO {
    gr.aueb.softeng.project1809.domain.ECustomer find(String visitorNo);
    void save(gr.aueb.softeng.project1809.domain.ECustomer entity);
    void delete(gr.aueb.softeng.project1809.domain.ECustomer entity);
    List<gr.aueb.softeng.project1809.domain.ECustomer> findAll();
}
