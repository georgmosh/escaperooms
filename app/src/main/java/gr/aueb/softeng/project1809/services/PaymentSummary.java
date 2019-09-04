package gr.aueb.softeng.project1809.services;

/**
 * This class illustrates a payment summary.
 */
public class PaymentSummary {
	gr.aueb.softeng.project1809.dao.PaymentsDAO dao;
	gr.aueb.softeng.project1809.domain.EPayment payment;
	
	public PaymentSummary(gr.aueb.softeng.project1809.dao.PaymentsDAO dao, gr.aueb.softeng.project1809.domain.EPayment payment) {
		this.dao = dao;
		this.payment = payment;
	}
	
	public void informDataWarehouse() {
		dao.save(payment);
	}
	
	public gr.aueb.softeng.project1809.services.PaymentSummary notifier(){
		informDataWarehouse();
		return this;
	}
	
	public String toString() {
		return "Your payment, No. " + payment.getPassword() + " was successfully submitted.";
	}
}
