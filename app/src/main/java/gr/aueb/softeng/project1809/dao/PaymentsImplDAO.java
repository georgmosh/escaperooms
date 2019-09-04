package gr.aueb.softeng.project1809.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * This class illustrates a sample data base object implementation for Payments.
 */
public class PaymentsImplDAO implements PaymentsDAO {
protected static List<gr.aueb.softeng.project1809.domain.EPayment> entities = new ArrayList<gr.aueb.softeng.project1809.domain.EPayment>();
    
    public void delete(gr.aueb.softeng.project1809.domain.EPayment entity) {
        entities.remove(entity);    
    }

    public List<gr.aueb.softeng.project1809.domain.EPayment> findAll() {
        return entities;
    }

    public void save(gr.aueb.softeng.project1809.domain.EPayment entity) {
        if (! entities.contains(entity)) {
            entities.add(entity);    
        }        
    }
    
    public gr.aueb.softeng.project1809.domain.EPayment find(String itemNo) {
        for(gr.aueb.softeng.project1809.domain.EPayment item : entities) {
            if (item.getPassword() .equals( itemNo)) {
                return item;
            }
        }
        return null;
    }
}
