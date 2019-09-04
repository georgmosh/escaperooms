package gr.aueb.softeng.project1809.services;

import android.util.Log;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import gr.aueb.softeng.project1809.ui.DAO_UI_Adapter;

/**
 * This class implements Escape Rooms Reservations.
 */
public class ECustomReservation implements Serializable {
	gr.aueb.softeng.project1809.domain.EReservation reservation;
	gr.aueb.softeng.project1809.domain.ECustomer customer;
	gr.aueb.softeng.project1809.domain.EEscapeRoom escapeRoom;
	gr.aueb.softeng.project1809.dao.CustomersDAO custDAO;
	gr.aueb.softeng.project1809.dao.EmployeesDAO empDAO;
	String informationReport;
	ECustomReservationItem element;
	ECustomContactItem contactManager;
	PReservationSummary summary;
	
	public ECustomReservation() {}
	
	public ECustomReservation(gr.aueb.softeng.project1809.domain.EReservation reservation, gr.aueb.softeng.project1809.domain.ECustomer customer, gr.aueb.softeng.project1809.domain.EEscapeRoom escapeRoom, gr.aueb.softeng.project1809.dao.CustomersDAO dao2, gr.aueb.softeng.project1809.dao.EmployeesDAO dao) {
		this.reservation = reservation;
		this.customer = customer;
		this.escapeRoom = escapeRoom;
		this.custDAO = dao2;
		this.empDAO = dao;
	}
	
	public ECustomReservation submit(String CustomerUser, gr.aueb.softeng.project1809.domain.EEscapeRoom room, Date date, String paymentInfo, int numberOfPeople, gr.aueb.softeng.project1809.dao.CustomersDAO dao2, gr.aueb.softeng.project1809.dao.EmployeesDAO dao) {
		gr.aueb.softeng.project1809.domain.EReservation resDetails = new gr.aueb.softeng.project1809.domain.EReservation(date, paymentInfo, numberOfPeople);
		this.element = new ECustomReservationItem(resDetails, room, CustomerUser, dao2);
		ECustomReservation r = new ECustomReservation(resDetails, element.getCustomer(), element.getEscapeRoom(), dao2, dao);
		Log.e("ECUSTRES_CUSTOMER", element.getCustomer().getID() + " " + element.getCustomer().getFirstName());
		r.element = this.element;
		r.informationReport = element.getReservationInformation();
		return r;
	}
	
	public String getReport() {
		return informationReport;
	}
	
	public ECustomReservation confirm(gr.aueb.softeng.project1809.dao.ReservationsDAO dao, EmailProviderService mailServer, EmailAddress to) {
		escapeRoom.addReservation(reservation);
		//DAO_UI_Adapter.getESC().getDAO().find(escapeRoom.CurrID).addReservation(reservation);
		customer.addReservation(reservation);
		DAO_UI_Adapter.getCUST().getDAO().find(customer.getID()).addReservation(reservation);
		Log.e("ECUSTRES_VALIDCUSTOMER", customer.getID() + " " + reservation.getCustomer().getID() + reservation.getEscapeRoom());
		summary = new PReservationSummary(dao, reservation);
		summary.informDataWarehouse();
		if(to != null) {
			EmailMessage message = new EmailMessage(to, "Your EscapeRoom reservation details!", informationReport);
			summary.emailReservationDetails(mailServer, message);
		}
		return this;
	}
	
	public ECustomReservation contact(gr.aueb.softeng.project1809.ui.UIDialogTemplate dialog) {
		contactManager = new ECustomContactItem(empDAO, reservation, dialog.getFurtherDetails()[0]);
		contactManager.assignToEmployee();
		return this;
	}
	
	public gr.aueb.softeng.project1809.services.PReservationSummary summarize() {
		return summary.notifier();
	}
	
	public ECustomReservationItem getElement() {
		return element;
	}
	
	public ECustomContactItem getManager() {
		return contactManager;
	}

	public gr.aueb.softeng.project1809.domain.EReservation getReservation() {
		return reservation;
	}
	
}
