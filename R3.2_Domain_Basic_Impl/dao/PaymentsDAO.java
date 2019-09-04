package dao;

import java.util.List;

public interface PaymentsDAO {
	   domain.EPayment find(String itemNo);
	    void save(domain.EPayment entity);
	    void delete(domain.EPayment entity);
	    List<domain.EPayment> findAll();
}
