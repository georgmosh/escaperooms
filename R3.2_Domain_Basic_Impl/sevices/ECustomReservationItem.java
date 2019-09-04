package sevices;

import java.util.List;

public class ECustomReservationItem {
	domain.EReservation reservation;
	domain.ECustomer customer;
	domain.EEscapeRoom escapeRoom;
	
	public ECustomReservationItem(domain.EReservation res, String custID, int escID, dao.EscapeRoomsDAO dao1, dao.CustomersDAO dao2) {
		this.reservation = res;
		List<domain.EEscapeRoom> data1 = dao1.findAll();
		for(domain.EEscapeRoom e: data1) {
			if(e.CurrID == escID)
				this.escapeRoom = e;
		}
		List<domain.ECustomer> data2 = dao2.findAll();
		for(domain.ECustomer c: data2) {
			if(c.getID().equals(custID))
				this.customer = c;
		}
	}
	
	public ECustomReservationItem(domain.EReservation res, domain.ECustomer cust, domain.EEscapeRoom esc) {
		this.reservation = res;
		this.customer = cust;
		this.escapeRoom = esc;
	}
	
	public domain.ECustomer getCustomer(){
		return this.customer;
	}
	
	public domain.EEscapeRoom getEscapeRoom(){
		return this.escapeRoom;
	}
	
	public String getReservationInformation() {
		return this.reservation + "\n" + this.customer + "\n" + this.escapeRoom;
	}
}
