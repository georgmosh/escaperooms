package sevices;

public class PReservationSummary {
	dao.ReservationsDAO dao;
	domain.EReservation reservation;
	
	public PReservationSummary(dao.ReservationsDAO dao, domain.EReservation reservation) {
		this.dao = dao;
		this.reservation = reservation;
	}
	
	public void informDataWarehouse() {
		dao.save(reservation);
	}
	
	public void emailReservationDetails(EmailProviderService mailServer, EmailMessage message) {
		mailServer.sendEmail(message);
	}
	
	public sevices.PReservationSummary notifier(){
		return this;
	}
	
	public String toString() {
		return "Your reservation for " + reservation.getDate() + " successfully sumbited.";
	}
}
