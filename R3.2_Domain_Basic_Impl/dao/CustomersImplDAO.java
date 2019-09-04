package dao;

import java.util.ArrayList;
import java.util.List;

public class CustomersImplDAO implements CustomersDAO {
	protected static List<domain.ECustomer> entities = new ArrayList<domain.ECustomer>();
    
    public void delete(domain.ECustomer entity) {
        entities.remove(entity);    
    }

    public List<domain.ECustomer> findAll() {
        return entities;
    }

    public void save(domain.ECustomer entity) {
        if (! entities.contains(entity)) {
            entities.add(entity);    
        }        
    }
    
    public domain.ECustomer find(String itemNo) {
        for(domain.ECustomer item : entities) {
            if (item.getID() .equals( itemNo)) {
                return item;
            }
        }
        return null;
    }
}
