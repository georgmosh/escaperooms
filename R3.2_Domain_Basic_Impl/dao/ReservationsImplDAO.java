package dao;

import java.util.ArrayList;
import java.util.List;

public class ReservationsImplDAO implements ReservationsDAO {
		protected static List<domain.EReservation> entities = new ArrayList<domain.EReservation>();
	    
	    public void delete(domain.EReservation entity) {
	        entities.remove(entity);    
	    }

	    public List<domain.EReservation> findAll() {
	        return entities;
	    }

	    public void save(domain.EReservation entity) {
	        if (! entities.contains(entity)) {
	            entities.add(entity);    
	        }        
	    }
	    
}
