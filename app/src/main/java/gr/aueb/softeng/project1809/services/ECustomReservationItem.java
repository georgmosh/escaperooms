package gr.aueb.softeng.project1809.services;

import java.io.Serializable;
import java.util.List;

/**
 * This class implements calculations on Escape Rooms Reservations.
 */
public class ECustomReservationItem implements Serializable {
	gr.aueb.softeng.project1809.domain.EReservation reservation;
	gr.aueb.softeng.project1809.domain.ECustomer customer;
	gr.aueb.softeng.project1809.domain.EEscapeRoom escapeRoom;
	
	public ECustomReservationItem(gr.aueb.softeng.project1809.domain.EReservation res, gr.aueb.softeng.project1809.domain.EEscapeRoom room, String custUserName, gr.aueb.softeng.project1809.dao.CustomersDAO dao2) {
		this.reservation = res;
		this.escapeRoom = room;
		List<gr.aueb.softeng.project1809.domain.ECustomer> data2 = dao2.findAll();
		for(gr.aueb.softeng.project1809.domain.ECustomer c: data2) {
			if(c.getLoginData().getUsername().equals(custUserName))
				this.customer = c;
		}
	}
	
	public ECustomReservationItem(gr.aueb.softeng.project1809.domain.EReservation res, gr.aueb.softeng.project1809.domain.ECustomer cust, gr.aueb.softeng.project1809.domain.EEscapeRoom esc) {
		this.reservation = res;
		this.customer = cust;
		this.escapeRoom = esc;
	}

	public ECustomReservationItem(gr.aueb.softeng.project1809.domain.EReservation res) {
		this.reservation = res;
		this.customer = res.getCustomer();
		this.escapeRoom = res.getEscapeRoom();
	}
	
	public gr.aueb.softeng.project1809.domain.ECustomer getCustomer(){
		return this.customer;
	}
	
	public gr.aueb.softeng.project1809.domain.EEscapeRoom getEscapeRoom(){
		return this.escapeRoom;
	}
	
	public String getReservationInformation() {
		return this.reservation + "\n" + this.customer + "\n" + this.escapeRoom;
	}
}
