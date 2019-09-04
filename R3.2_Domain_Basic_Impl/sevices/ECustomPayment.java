package sevices;

import java.util.Date;

public class ECustomPayment {
	domain.EPayment payment;
	domain.EReservation reservation;
	domain.PaymentReceipt receipt;
	sevices.PaymentSummary summary;
	static int rawID = 0;
	int ID;
	String report;
	
	public ECustomPayment() {}
	
	public ECustomPayment(domain.EPayment pay, domain.EReservation res, domain.PaymentReceipt rec) {
		this.payment = pay;
		this.reservation = res;
		this.receipt = rec;
		this.ID =rawID++;
	}
	
	public ECustomPayment submit(domain.EPayment payment, Date date) {
		domain.EReservation res = payment.getReservation();
		domain.PaymentReceipt rec = null;
		if(res.getPaymentInfo().equals("receipt")) {
			domain.MeansOfPayment m = domain.MeansOfPayment.receipt;
			rec = new domain.PaymentReceipt("REC"+payment.getPassword(), m, date, res.getEscapeRoom().getPrice().getValue());
		}else if(res.getPaymentInfo().equals("invoice")) {
			domain.MeansOfPayment m = domain.MeansOfPayment.invoice;
			rec = new domain.PaymentReceipt("REC"+payment.getPassword(), m, date, res.getEscapeRoom().getPrice().getValue());
		}else if(res.getPaymentInfo().equals("check")) {
			domain.MeansOfPayment m = domain.MeansOfPayment.check;
			rec = new domain.PaymentReceipt("REC"+payment.getPassword(), m, date, res.getEscapeRoom().getPrice().getValue());
		}else if(res.getPaymentInfo().equals("bitcoin")) {
			domain.MeansOfPayment m = domain.MeansOfPayment.bitcoin;
			rec = new domain.PaymentReceipt("REC"+payment.getPassword(), m, date, res.getEscapeRoom().getPrice().getValue());
		}
		return new ECustomPayment(payment, res, rec);
	}
	
	public ECustomPayment getCurrentPayment(dao.WebBankingAPI API, CardReaderService POS, CreditCard card) {
		this.report = ("Reservation: " + new ECustomReservationItem(reservation, reservation.getCustomer(), reservation.getEscapeRoom()).getReservationInformation());
		ECustomTransactionItem tran = new ECustomTransactionItem(API, POS);
		if(payment.getOption().equals("Card") && tran.enableSwipes()) {
			payment = tran.getTransactionDetails(card, payment, 0);
		}
		else if(payment.getOption().equals("Cash"))
			payment = tran.getTransactionDetails(null, payment, 1);
		else
			payment = tran.getTransactionDetails(null, payment, -1);
		report += "\nbeing paid as: No. " + payment;
		return this;
	}
	
	public String getReport() {
		return this.report;
	}
	
	public sevices.PaymentSummary getSummary() {
		return summary.notifier();
	}
	
	public String getNotification() {
		return (summary.notifier()).toString();
	}
	
	public ECustomPayment setPaymentDetails(dao.PaymentsDAO dao) {
		payment.addReservation(reservation);
		payment.addReceipt(receipt);
		summary = new PaymentSummary(dao, payment) ;
		return this;
	}
	
}
