package dao;

import java.util.List;

public interface CustomersDAO {
	domain.ECustomer find(String visitorNo);
    void save(domain.ECustomer entity);
    void delete(domain.ECustomer entity);
    List<domain.ECustomer> findAll();
}
