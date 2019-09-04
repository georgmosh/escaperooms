package gr.aueb.softeng.project1809.services;

import java.util.List;

/**
 * This class implements Reservations' previews.
 */
public class ECustomPreview {
	gr.aueb.softeng.project1809.domain.ECustomer customer;
	List<gr.aueb.softeng.project1809.domain.EReservation> reservations;
	ECustomReservationItem element;
	
	public ECustomPreview(String clientID, gr.aueb.softeng.project1809.dao.CustomersDAO dao) {
		List<gr.aueb.softeng.project1809.domain.ECustomer> data = dao.findAll();
		for(gr.aueb.softeng.project1809.domain.ECustomer c: data) {
			if(c.getID() == clientID)customer = c;
		}
	}
	
	public ECustomPreview submit(String ID, gr.aueb.softeng.project1809.dao.CustomersDAO dao) {
		ECustomPreview e = new ECustomPreview(ID, dao);
		return e;
	}
	
	public ECustomPreview confirm(gr.aueb.softeng.project1809.domain.EReservation reservationSelected) {
		this.element = new ECustomReservationItem(reservationSelected, customer, reservationSelected.getEscapeRoom());
		return this;
	}
	
	public List<gr.aueb.softeng.project1809.domain.EReservation> getReservations() {
		this.reservations = customer.getReservations();
		return this.reservations;
	}
	
	public ECustomReservationItem getElement() {
		return element;
	}
}
