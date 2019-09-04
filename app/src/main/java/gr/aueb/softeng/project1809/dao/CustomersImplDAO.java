package gr.aueb.softeng.project1809.dao;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class illustrates a sample data base object implementation for Customers.
 */
public class CustomersImplDAO implements CustomersDAO, Serializable {
	protected static List<gr.aueb.softeng.project1809.domain.ECustomer> entities = new ArrayList<gr.aueb.softeng.project1809.domain.ECustomer>();
    
    public void delete(gr.aueb.softeng.project1809.domain.ECustomer entity) {
        entities.remove(entity);    
    }

    public List<gr.aueb.softeng.project1809.domain.ECustomer> findAll() {
        return entities;
    }

    public void save(gr.aueb.softeng.project1809.domain.ECustomer entity) {
        if (! entities.contains(entity)) {
            entities.add(entity);    
        }        
    }
    
    public gr.aueb.softeng.project1809.domain.ECustomer find(String itemNo) {
        for(gr.aueb.softeng.project1809.domain.ECustomer item : entities) {
            if (item.getID() .equals( itemNo)) {
                return item;
            }
        }
        return null;
    }
    
    public gr.aueb.softeng.project1809.domain.User verify(String username, String password){
    	for(gr.aueb.softeng.project1809.domain.ECustomer item: entities) {
    		if(item.getLoginData().getUsername().equals(username)) {
    			if(item.getLoginData().getPassword().equals(password)) return item;
    		}
    	}
    	return null;
    }
}
