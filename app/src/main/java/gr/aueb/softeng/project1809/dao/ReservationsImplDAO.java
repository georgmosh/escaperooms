package gr.aueb.softeng.project1809.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class illustrates a sample data base object implementation for Reservations.
 */
public class ReservationsImplDAO implements ReservationsDAO, Serializable {
		protected static List<gr.aueb.softeng.project1809.domain.EReservation> entities = new ArrayList<gr.aueb.softeng.project1809.domain.EReservation>();
	    
	    public void delete(gr.aueb.softeng.project1809.domain.EReservation entity) {
	        entities.remove(entity);    
	    }

	    public List<gr.aueb.softeng.project1809.domain.EReservation> findAll() {
	        return entities;
	    }

	    public void save(gr.aueb.softeng.project1809.domain.EReservation entity) {
	        if (! entities.contains(entity)) {
	            entities.add(entity);    
	        }        
	    }
	    
}
