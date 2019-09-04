package sevices;

public class PaymentSummary {
	dao.PaymentsDAO dao;
	domain.EPayment payment;
	
	public PaymentSummary(dao.PaymentsDAO dao, domain.EPayment payment) {
		this.dao = dao;
		this.payment = payment;
	}
	
	public void informDataWarehouse() {
		dao.save(payment);
	}
	
	public sevices.PaymentSummary notifier(){
		informDataWarehouse();
		return this;
	}
	
	public String toString() {
		return "Your payment, No. " + payment.getPassword() + " was successfully sumbited.";
	}
}
