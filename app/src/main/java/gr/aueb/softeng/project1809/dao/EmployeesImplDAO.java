package gr.aueb.softeng.project1809.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class illustrates a sample data base object implementation for Employees.
 */
public class EmployeesImplDAO implements EmployeesDAO, Serializable {
	protected static List<gr.aueb.softeng.project1809.domain.EEmployee> entities = new ArrayList<gr.aueb.softeng.project1809.domain.EEmployee>();

	public gr.aueb.softeng.project1809.domain.EEmployee find(String employeeSSN) {
		for(gr.aueb.softeng.project1809.domain.EEmployee item : entities) {
            if (item.getAMKA() .equals( employeeSSN)) {
                return item;
            }
        }
        return null;
	}

	public void save(gr.aueb.softeng.project1809.domain.EEmployee entity) {
		 if (! entities.contains(entity)) {
	            entities.add(entity);    
	        } 
	}

	public void delete(gr.aueb.softeng.project1809.domain.EEmployee entity) {
		 entities.remove(entity);
	}

	public List<gr.aueb.softeng.project1809.domain.EEmployee> findAll() {
		return entities;
	}
	
	public gr.aueb.softeng.project1809.domain.User verify(String username, String password){
    	for(gr.aueb.softeng.project1809.domain.EEmployee item: entities) {
    		if(item.getLoginData().getUsername().equals(username)) {
    			if(item.getLoginData().getPassword().equals(password)) return item;
    		}
    	}
    	return null;
    }

}
