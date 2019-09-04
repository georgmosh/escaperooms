package gr.aueb.softeng.project1809.services;

import android.util.Log;

import java.io.Serializable;

import gr.aueb.softeng.project1809.ui.DAO_UI_Adapter;

/**
 * This class illustrates a Reservation Summary.
 */
public class PReservationSummary implements Serializable {
	gr.aueb.softeng.project1809.dao.ReservationsDAO dao;
	gr.aueb.softeng.project1809.domain.EReservation reservation;
	
	public PReservationSummary(gr.aueb.softeng.project1809.dao.ReservationsDAO dao, gr.aueb.softeng.project1809.domain.EReservation reservation) {
		this.dao = dao;
		this.reservation = reservation;
	}
	
	public void informDataWarehouse() {
		dao.save(reservation);
		Log.e("ECUSTRES_STOREDCUSTOMER", reservation.getCustomer().getID() + reservation.getEscapeRoom());
		Log.e("ECUSTDAO_STOREDCUSTOMER", dao.findAll().get(0).getCustomer()+"");
		Log.e("ECOMMDAO_STOREDCUSTOMER", DAO_UI_Adapter.getRES().getDAO().findAll().get(0).getCustomer()+"");
	}
	
	public void emailReservationDetails(EmailProviderService mailServer, EmailMessage message) {
		mailServer.sendEmail(message);
	}
	
	public gr.aueb.softeng.project1809.services.PReservationSummary notifier(){
		return this;
	}
	
	public String toString() {
		return "Your reservation for " + reservation.getDate() + " successfully sumbited.";
	}
}
