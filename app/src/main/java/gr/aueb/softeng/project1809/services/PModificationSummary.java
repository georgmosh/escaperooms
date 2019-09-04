package gr.aueb.softeng.project1809.services;

import android.util.Log;

/**
 * This class illustrates a Standard Configuration modification summary.
 */
public class PModificationSummary {
	gr.aueb.softeng.project1809.dao.EscapeRoomsDAO dao;
	gr.aueb.softeng.project1809.domain.EEscapeRoom escaperoom;
	
	public PModificationSummary(gr.aueb.softeng.project1809.dao.EscapeRoomsDAO dao, gr.aueb.softeng.project1809.domain.EEscapeRoom room) {
		this.dao = dao;
		this.escaperoom = room;
	}
	
	public void informDataWarehouse() {
		dao.save(escaperoom);
	}
	
	public void emailReservationDetails(EmailProviderService mailServer, EmailMessage message) {
		Log.e("MAIL_MESSAGE", (message!=null)+"");
		Log.e("MAIL_RECEIP", message.getTo().getAddress());
		Log.e("MAIL_SUBJECT", message.getSubject());
		Log.e("MAIL_BODY", message.getBody());
		Log.e("MAIL_SERVICE", "Ready to send mail");
		mailServer.sendEmail(message);
	}
	
	public gr.aueb.softeng.project1809.services.PModificationSummary notifier(){
		return this;
	}
	
	public String toString() {
		return "Your modification for " + escaperoom.getName() + " successfully sumbited.";
	}
}
