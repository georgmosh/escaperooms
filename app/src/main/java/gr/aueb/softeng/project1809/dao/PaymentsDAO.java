package gr.aueb.softeng.project1809.dao;

import java.util.List;

/**
 * This class illustrates a sample data base object interface for Payments.
 */
public interface PaymentsDAO {
	gr.aueb.softeng.project1809.domain.EPayment find(String itemNo);
	    void save(gr.aueb.softeng.project1809.domain.EPayment entity);
	    void delete(gr.aueb.softeng.project1809.domain.EPayment entity);
	    List<gr.aueb.softeng.project1809.domain.EPayment> findAll();
}
