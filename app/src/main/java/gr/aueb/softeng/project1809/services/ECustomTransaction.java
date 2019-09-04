package gr.aueb.softeng.project1809.services;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import gr.aueb.softeng.project1809.dao.ReservationsDAO;
import gr.aueb.softeng.project1809.domain.EReservation;
import gr.aueb.softeng.project1809.ui.DAO_UI_Adapter;
/**
 * This class implements Transactions.
 */
public class ECustomTransaction implements Serializable {
	gr.aueb.softeng.project1809.domain.EPayment payment;
	gr.aueb.softeng.project1809.domain.EReservation reservation;
	gr.aueb.softeng.project1809.domain.PaymentReceipt receipt;
	gr.aueb.softeng.project1809.services.PaymentSummary summary;
	String report;
	
	public ECustomTransaction() {}
	
	public ECustomTransaction(gr.aueb.softeng.project1809.domain.EPayment pay, gr.aueb.softeng.project1809.domain.EReservation res, gr.aueb.softeng.project1809.domain.PaymentReceipt rec) {
		this.payment = pay;
		this.reservation = res;
		this.receipt = rec;
	}
	
	public ECustomTransaction submit(gr.aueb.softeng.project1809.domain.EPayment payment, Date date) {
		gr.aueb.softeng.project1809.domain.EReservation res = payment.getReservation();
		gr.aueb.softeng.project1809.domain.PaymentReceipt rec = null;
		if(res.getPaymentInfo().equals("Receipt")) {
			gr.aueb.softeng.project1809.domain.MeansOfPayment m = gr.aueb.softeng.project1809.domain.MeansOfPayment.receipt;
			rec = new gr.aueb.softeng.project1809.domain.PaymentReceipt("REC"+payment.getPassword(), m, date, res.getEscapeRoom().getPrice().getValue());
		}else if(res.getPaymentInfo().equals("Invoice")) {
			gr.aueb.softeng.project1809.domain.MeansOfPayment m = gr.aueb.softeng.project1809.domain.MeansOfPayment.invoice;
			rec = new gr.aueb.softeng.project1809.domain.PaymentReceipt("REC"+payment.getPassword(), m, date, res.getEscapeRoom().getPrice().getValue());
		}else if(res.getPaymentInfo().equals("Check")) {
			gr.aueb.softeng.project1809.domain.MeansOfPayment m = gr.aueb.softeng.project1809.domain.MeansOfPayment.check;
			rec = new gr.aueb.softeng.project1809.domain.PaymentReceipt("REC"+payment.getPassword(), m, date, res.getEscapeRoom().getPrice().getValue());
		}else if(res.getPaymentInfo().equals("Bitcoin")) {
			gr.aueb.softeng.project1809.domain.MeansOfPayment m = gr.aueb.softeng.project1809.domain.MeansOfPayment.bitcoin;
			rec = new gr.aueb.softeng.project1809.domain.PaymentReceipt("REC"+payment.getPassword(), m, date, res.getEscapeRoom().getPrice().getValue());
		}
		return new ECustomTransaction(payment, res, rec);
	}
	
	public ECustomTransaction getCurrentPayment(gr.aueb.softeng.project1809.dao.WebBankingAPI API, CardReaderService POS, CreditCard card) {
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
	
	public gr.aueb.softeng.project1809.services.PaymentSummary getSummary() {
		return summary.notifier();
	}
	
	public String getNotification() {
		return (getSummary()).toString();
	}
	
	public ECustomTransaction setPaymentDetails(gr.aueb.softeng.project1809.dao.PaymentsDAO dao) {
		payment.addReceipt(receipt);
		ECustomPayment daoPayment;
		List<EReservation> resDAO = DAO_UI_Adapter.getRES().getDAO().findAll();
		for(EReservation res: resDAO) {
			if(res.getID() == payment.getReservation().getID())
				res.getPayment().addReceipt(receipt);
		}
		summary = new PaymentSummary(dao, payment) ;
		return this;
	}
	
}
