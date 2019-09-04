package sevices;

import java.util.Date;

public class ECustomReservation {
	domain.EReservation reservation;
	domain.ECustomer customer;
	domain.EEscapeRoom escapeRoom;
	String informationReport;
	PReservationSummary summary;
	ECustomReservationItem element;
	
	public ECustomReservation() {}
	
	public ECustomReservation(domain.EReservation reservation, domain.ECustomer customer, domain.EEscapeRoom escapeRoom) {
		this.reservation = reservation;
		this.customer = customer;
		this.escapeRoom = escapeRoom;
	}
	
	public ECustomReservation submit(String CustomerID, int EscapeRoomID, Date date, String paymentInfo, int numberOfPeople, dao.EscapeRoomsDAO dao1, dao.CustomersDAO dao2) {
		domain.EReservation resDetails = new domain.EReservation(date, paymentInfo, numberOfPeople);
		this.element = new ECustomReservationItem(resDetails, CustomerID, EscapeRoomID, dao1, dao2);
		ECustomReservation r = new ECustomReservation(resDetails, element.getCustomer(), element.getEscapeRoom());
		r.element = this.element;
		r.informationReport = element.getReservationInformation();
		return r;
	}
	
	public String getReport() {
		return informationReport;
	}
	
	public ECustomReservation confirm(dao.ReservationsDAO dao, EmailProviderService mailServer, EmailAddress to) {
		escapeRoom.addReservation(reservation);
		customer.addReservation(reservation);
		summary = new PReservationSummary(dao, reservation);
		summary.informDataWarehouse();
		if(to != null) {
			EmailMessage message = new EmailMessage(to, "Your EscapeRoom reservation details!", informationReport);
			summary.emailReservationDetails(mailServer, message);
		}
		return this;
	}
	
	public sevices.PReservationSummary summarize() {
		return summary.notifier();
	}
	
	public ECustomReservationItem getElement() {
		return element;
	}
	
}
