package dao;

import java.util.ArrayList;
import java.util.List;

public class PaymentsImplDAO implements PaymentsDAO {
protected static List<domain.EPayment> entities = new ArrayList<domain.EPayment>();
    
    public void delete(domain.EPayment entity) {
        entities.remove(entity);    
    }

    public List<domain.EPayment> findAll() {
        return entities;
    }

    public void save(domain.EPayment entity) {
        if (! entities.contains(entity)) {
            entities.add(entity);    
        }        
    }
    
    public domain.EPayment find(String itemNo) {
        for(domain.EPayment item : entities) {
            if (item.getPassword() .equals( itemNo)) {
                return item;
            }
        }
        return null;
    }
}
