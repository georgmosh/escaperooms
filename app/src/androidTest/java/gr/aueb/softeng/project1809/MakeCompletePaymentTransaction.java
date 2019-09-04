package gr.aueb.softeng.project1809;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import gr.aueb.softeng.project1809.dao.PaymentsDAO;
import gr.aueb.softeng.project1809.dao.PaymentsStubDAO;
import gr.aueb.softeng.project1809.dao.WebBankingStubAPI;
import gr.aueb.softeng.project1809.domain.Barcode;
import gr.aueb.softeng.project1809.domain.Currencies;
import gr.aueb.softeng.project1809.domain.ECustomer;
import gr.aueb.softeng.project1809.domain.EEscapeRoom;
import gr.aueb.softeng.project1809.domain.EPayment;
import gr.aueb.softeng.project1809.domain.EReservation;
import gr.aueb.softeng.project1809.domain.EStandardEscapeRoom;
import gr.aueb.softeng.project1809.domain.Money;
import gr.aueb.softeng.project1809.services.CardStubReaderService;
import gr.aueb.softeng.project1809.services.CreditCard;
import gr.aueb.softeng.project1809.services.ECustomPayment;
import gr.aueb.softeng.project1809.services.ECustomTransaction;


public class MakeCompletePaymentTransaction {

	@Test
	void test() {
		ECustomer c1 = new ECustomer("user1","1234","Georgios","Moschovis","USER021", new Barcode("BCD102", "DSlso2%&js"),null);
		ECustomer c2 = new ECustomer("user2","5678","Stavros","Markopoulos","USER052", new Barcode("BCD425", "KSo3$*sw!"),null);
		ECustomer c3 = new ECustomer("user3","7654","Professor Nikolaos","Diamantidis","USER052", new Barcode("BCD928", "KS92S#%l"),null);
		EEscapeRoom e1 = new EStandardEscapeRoom("Pireus", 10, 90, 5, new Money(15, Currencies.EUR));
		EEscapeRoom e2 = new EStandardEscapeRoom("Athens", 6, 30, 7, new Money(20, Currencies.EUR));
		EEscapeRoom e3 = new EStandardEscapeRoom("Washington", 10, 90, 5, new Money(5, Currencies.USD));
		EEscapeRoom e4 = new EStandardEscapeRoom("London", 10, 90, 5, new Money(5, Currencies.GBP));
		Date date = new Date(2018,4,21);
		Date dateOfCard = new Date(2023,7,27);
		Money money = new Money(34,Currencies.EUR);
		CreditCard card = new CreditCard("2382 2833 0182 9182", "MasterCard",dateOfCard );
		
		//TestCase1
		EPayment payment = new EPayment("PAY929", "Card", date, money);
		EReservation reservation = new EReservation(date, "receipt", 5);
		c1.addReservation(reservation);
		payment.addReservation(reservation);

		Assert.assertNotNull(reservation.getPayment());
		Assert.assertNotNull(payment.getReservation());
		Assert.assertNotNull(reservation.getPayment()+"", payment);
		Assert.assertNotNull(payment.getReservation()+"", reservation);
		e1.addReservation(reservation);
		Assert.assertNotNull(reservation.getEscapeRoom());
		Assert.assertNotNull(reservation.getEscapeRoom().getPrice());
		Assert.assertNotNull(reservation.getEscapeRoom().getPrice()+"", e1.getPrice());
		Assert.assertNotNull(reservation.getEscapeRoom().getPrice().getValue());
		ECustomPayment samplePaym = new ECustomPayment();
		samplePaym = samplePaym.submit("Card", date, reservation);
		Assert.assertNotNull(samplePaym);
		Assert.assertEquals(samplePaym.getReservation().getDate(), payment.getReservation().getDate());
		Assert.assertEquals(samplePaym.getReservation().getPaymentInfo(), payment.getReservation().getPaymentInfo());
		Assert.assertNotNull(samplePaym.getConfRequest());
		samplePaym = samplePaym.submit(new Date());
		Assert.assertNotNull(samplePaym);
		Assert.assertNotNull(samplePaym.getTransaction());
		ECustomTransaction paymentConf = samplePaym.getTransaction();
		paymentConf = paymentConf.submit(payment, date);
		Assert.assertNotNull(paymentConf);
		paymentConf = paymentConf.getCurrentPayment(new WebBankingStubAPI(), new CardStubReaderService(), card);
		Assert.assertNotNull(paymentConf.getReport());
		PaymentsStubDAO dao = new PaymentsStubDAO();
		Assert.assertNotNull(dao);
		dao.initialize();
		PaymentsDAO stub = dao.getDAO();
		paymentConf = paymentConf.setPaymentDetails(stub);
		Assert.assertNotNull(paymentConf);
		Assert.assertNotNull(paymentConf.getSummary());
		Assert.assertNotNull(paymentConf.getNotification());
		
		//TestCase2
		payment = new EPayment("PAY1028", "Cash", date, money);
		 reservation = new EReservation(date, "invoice", 5);
		c2.addReservation(reservation);
		payment.addReservation(reservation);
		Assert.assertNotNull(reservation.getPayment());
		Assert.assertNotNull(payment.getReservation());
		Assert.assertEquals(reservation.getPayment(), payment);
		Assert.assertEquals(payment.getReservation(), reservation);
		e2.addReservation(reservation);
		Assert.assertNotNull(reservation.getEscapeRoom());
		Assert.assertNotNull(reservation.getEscapeRoom().getPrice());
		Assert.assertEquals(reservation.getEscapeRoom().getPrice(), e2.getPrice());
		Assert.assertNotNull(reservation.getEscapeRoom().getPrice().getValue());

		samplePaym = new ECustomPayment();
		samplePaym = samplePaym.submit("Cash", date, reservation);
		Assert.assertNotNull(samplePaym);
		Assert.assertEquals(samplePaym.getReservation().getDate(), payment.getReservation().getDate());
		Assert.assertEquals(samplePaym.getReservation().getPaymentInfo(), payment.getReservation().getPaymentInfo());
		Assert.assertNotNull(samplePaym.getConfRequest());
		samplePaym = samplePaym.submit(new Date());
		Assert.assertNotNull(samplePaym);
		Assert.assertNotNull(samplePaym.getTransaction());
		paymentConf = samplePaym.getTransaction();
		Assert.assertNotNull(paymentConf);
		paymentConf = paymentConf.getCurrentPayment(new WebBankingStubAPI(), new CardStubReaderService(), card);
		Assert.assertNotNull(paymentConf.getReport());
		dao = new PaymentsStubDAO();
		Assert.assertNotNull(dao);
		dao.initialize();
		stub = dao.getDAO();
		paymentConf = paymentConf.setPaymentDetails(stub);
		Assert.assertNotNull(paymentConf);
		Assert.assertNotNull(paymentConf.getSummary());
		Assert.assertNotNull(paymentConf.getNotification());
		
		//TestCase3
		payment = new EPayment("PAY1532", "Bitcoin", date, money);
		 reservation = new EReservation(date, "bitcoin", 5);
		c3.addReservation(reservation);
		payment.addReservation(reservation);
		Assert.assertNotNull(reservation.getPayment());
		Assert.assertNotNull(payment.getReservation());
		Assert.assertEquals(reservation.getPayment(), payment);
		Assert.assertEquals(payment.getReservation(), reservation);
		e3.addReservation(reservation);
		Assert.assertNotNull(reservation.getEscapeRoom());
		Assert.assertNotNull(reservation.getEscapeRoom().getPrice());
		Assert.assertEquals(reservation.getEscapeRoom().getPrice(), e3.getPrice());
		Assert.assertNotNull(reservation.getEscapeRoom().getPrice().getValue());
		samplePaym = new ECustomPayment();
		samplePaym = samplePaym.submit("Bitcoin", date, reservation);
		Assert.assertNotNull(samplePaym);
		Assert.assertEquals(samplePaym.getReservation().getDate(), payment.getReservation().getDate());
		Assert.assertEquals(samplePaym.getReservation().getPaymentInfo(), payment.getReservation().getPaymentInfo());
		Assert.assertNotNull(samplePaym.getConfRequest());
		samplePaym = samplePaym.submit(new Date());
		Assert.assertNotNull(samplePaym);
		Assert.assertNotNull(samplePaym.getTransaction());
		paymentConf = samplePaym.getTransaction();
		paymentConf = paymentConf.submit(payment, date);
		Assert.assertNotNull(paymentConf);
		paymentConf = paymentConf.getCurrentPayment(new WebBankingStubAPI(), new CardStubReaderService(), card);
		Assert.assertNotNull(paymentConf.getReport());
		dao = new PaymentsStubDAO();
		Assert.assertNotNull(dao);
		dao.initialize();
		stub = dao.getDAO();
		paymentConf = paymentConf.setPaymentDetails(stub);
		Assert.assertNotNull(paymentConf);
		Assert.assertNotNull(paymentConf.getSummary());
		Assert.assertNotNull(paymentConf.getNotification());
		
		//TestCase4
		payment = new EPayment("PAY1764", "Card", date, money);
		 reservation = new EReservation(date, "check", 5);
		c3.addReservation(reservation);
		payment.addReservation(reservation);
		Assert.assertNotNull(reservation.getPayment());
		Assert.assertNotNull(payment.getReservation());
		Assert.assertEquals(reservation.getPayment(), payment);
		Assert.assertEquals(payment.getReservation(), reservation);
		e4.addReservation(reservation);
		Assert.assertNotNull(reservation.getEscapeRoom());
		Assert.assertNotNull(reservation.getEscapeRoom().getPrice());
		Assert.assertEquals(reservation.getEscapeRoom().getPrice(), e4.getPrice());
		Assert.assertNotNull(reservation.getEscapeRoom().getPrice().getValue());
		samplePaym = new ECustomPayment();
		samplePaym = samplePaym.submit("Card", date, reservation);
		Assert.assertNotNull(samplePaym);
		Assert.assertEquals(samplePaym.getReservation().getDate(), payment.getReservation().getDate());
		Assert.assertEquals(samplePaym.getReservation().getPaymentInfo(), payment.getReservation().getPaymentInfo());
		Assert.assertNotNull(samplePaym.getConfRequest());
		samplePaym = samplePaym.submit(new Date());
		Assert.assertNotNull(samplePaym);
		Assert.assertNotNull(samplePaym.getTransaction());
		paymentConf = samplePaym.getTransaction();
		paymentConf = paymentConf.submit(payment, date);
		Assert.assertNotNull(paymentConf);
		paymentConf = paymentConf.getCurrentPayment(new WebBankingStubAPI(), new CardStubReaderService(), card);
		Assert.assertNotNull(paymentConf.getReport());
		dao = new PaymentsStubDAO();
		Assert.assertNotNull(dao);
		dao.initialize();
		stub = dao.getDAO();
		paymentConf = paymentConf.setPaymentDetails(stub);
		Assert.assertNotNull(paymentConf);
		Assert.assertNotNull(paymentConf.getSummary());
		Assert.assertNotNull(paymentConf.getNotification());
	}

}
