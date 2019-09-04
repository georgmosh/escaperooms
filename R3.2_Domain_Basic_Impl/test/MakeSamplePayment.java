package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import sevices.ECustomPayment;

class MakeSamplePayment {

	@Test
	void test() {
		domain.ECustomer c1 = new domain.ECustomer("user1","1234","Georgios","Moschovis","USER021", new domain.Barcode("BCD102", "DSlso2%&js"),null);
		domain.ECustomer c2 = new domain.ECustomer("user2","5678","Stavros","Markopoulos","USER052", new domain.Barcode("BCD425", "KSo3$*sw!"),null);
		domain.ECustomer c3 = new domain.ECustomer("user3","7654","Professor Nikolaos","Diamantidis","USER052", new domain.Barcode("BCD928", "KS92S#%l"),null);
		domain.EEscapeRoom e1 = new domain.EStandardEscapeRoom("Pireus", 10, 90, 5, new domain.Money(15, domain.Currencies.EUR));
		domain.EEscapeRoom e2 = new domain.EStandardEscapeRoom("Athens", 6, 30, 7, new domain.Money(20, domain.Currencies.EUR));
		domain.EEscapeRoom e3 = new domain.EStandardEscapeRoom("Washington", 10, 90, 5, new domain.Money(5, domain.Currencies.USD));
		domain.EEscapeRoom e4 = new domain.EStandardEscapeRoom("London", 10, 90, 5, new domain.Money(5, domain.Currencies.GBP));
		Date date = new Date(2018,4,21);
		Date dateOfCard = new Date(2023,7,27);
		sevices.CreditCard card = new sevices.CreditCard("2382 2833 0182 9182", "MasterCard",dateOfCard );
		
		//TestCase1
		domain.EPayment payment = new domain.EPayment("PAY929", "Card", date);
		domain.EReservation reservation = new domain.EReservation(date, "receipt", 5);
		c1.addReservation(reservation);
		payment.addReservation(reservation);
		assertNotNull(reservation.getPayment());
		assertNotNull(payment.getReservation());
		assertEquals(reservation.getPayment(), payment);
		assertEquals(payment.getReservation(), reservation);
		e1.addReservation(reservation);
		assertNotNull(reservation.getEscapeRoom());
		assertNotNull(reservation.getEscapeRoom().getPrice());
		assertEquals(reservation.getEscapeRoom().getPrice(), e1.getPrice());
		assertNotNull(reservation.getEscapeRoom().getPrice().getValue());
		ECustomPayment paymentConf = new ECustomPayment();
		paymentConf = paymentConf.submit(payment, date);
		assertNotNull(paymentConf);
		paymentConf = paymentConf.getCurrentPayment(new dao.WebBankingStubAPI(), new sevices.CardStubReaderService(), card);
		assertNotNull(paymentConf.getReport());
		dao.PaymentsStubDAO dao = new dao.PaymentsStubDAO();
		assertNotNull(dao);
		dao.initialize();
		dao.PaymentsDAO stub = dao.getDAO();
		paymentConf = paymentConf.setPaymentDetails(stub);
		assertNotNull(paymentConf);
		assertNotNull(paymentConf.getSummary());
		assertNotNull(paymentConf.getNotification());
		
		//TestCase2
		payment = new domain.EPayment("PAY1028", "Cash", date);
		 reservation = new domain.EReservation(date, "invoice", 5);
		c2.addReservation(reservation);
		payment.addReservation(reservation);
		assertNotNull(reservation.getPayment());
		assertNotNull(payment.getReservation());
		assertEquals(reservation.getPayment(), payment);
		assertEquals(payment.getReservation(), reservation);
		e2.addReservation(reservation);
		assertNotNull(reservation.getEscapeRoom());
		assertNotNull(reservation.getEscapeRoom().getPrice());
		assertEquals(reservation.getEscapeRoom().getPrice(), e2.getPrice());
		assertNotNull(reservation.getEscapeRoom().getPrice().getValue());
		paymentConf = new ECustomPayment();
		paymentConf = paymentConf.submit(payment, date);
		assertNotNull(paymentConf);
		paymentConf = paymentConf.getCurrentPayment(new dao.WebBankingStubAPI(), new sevices.CardStubReaderService(), card);
		assertNotNull(paymentConf.getReport());
		dao = new dao.PaymentsStubDAO();
		assertNotNull(dao);
		dao.initialize();
		stub = dao.getDAO();
		paymentConf = paymentConf.setPaymentDetails(stub);
		assertNotNull(paymentConf);
		assertNotNull(paymentConf.getSummary());
		assertNotNull(paymentConf.getNotification());
		
		//TestCase3
		payment = new domain.EPayment("PAY1532", "Bitcoin", date);
		 reservation = new domain.EReservation(date, "bitcoin", 5);
		c3.addReservation(reservation);
		payment.addReservation(reservation);
		assertNotNull(reservation.getPayment());
		assertNotNull(payment.getReservation());
		assertEquals(reservation.getPayment(), payment);
		assertEquals(payment.getReservation(), reservation);
		e3.addReservation(reservation);
		assertNotNull(reservation.getEscapeRoom());
		assertNotNull(reservation.getEscapeRoom().getPrice());
		assertEquals(reservation.getEscapeRoom().getPrice(), e3.getPrice());
		assertNotNull(reservation.getEscapeRoom().getPrice().getValue());
		paymentConf = new ECustomPayment();
		paymentConf = paymentConf.submit(payment, date);
		assertNotNull(paymentConf);
		paymentConf = paymentConf.getCurrentPayment(new dao.WebBankingStubAPI(), new sevices.CardStubReaderService(), card);
		assertNotNull(paymentConf.getReport());
		dao = new dao.PaymentsStubDAO();
		assertNotNull(dao);
		dao.initialize();
		stub = dao.getDAO();
		paymentConf = paymentConf.setPaymentDetails(stub);
		assertNotNull(paymentConf);
		assertNotNull(paymentConf.getSummary());
		assertNotNull(paymentConf.getNotification());
		
		//TestCase4
		payment = new domain.EPayment("PAY1764", "Card", date);
		 reservation = new domain.EReservation(date, "check", 5);
		c3.addReservation(reservation);
		payment.addReservation(reservation);
		assertNotNull(reservation.getPayment());
		assertNotNull(payment.getReservation());
		assertEquals(reservation.getPayment(), payment);
		assertEquals(payment.getReservation(), reservation);
		e4.addReservation(reservation);
		assertNotNull(reservation.getEscapeRoom());
		assertNotNull(reservation.getEscapeRoom().getPrice());
		assertEquals(reservation.getEscapeRoom().getPrice(), e4.getPrice());
		assertNotNull(reservation.getEscapeRoom().getPrice().getValue());
		paymentConf = new ECustomPayment();
		paymentConf = paymentConf.submit(payment, date);
		assertNotNull(paymentConf);
		paymentConf = paymentConf.getCurrentPayment(new dao.WebBankingStubAPI(), new sevices.CardStubReaderService(), card);
		assertNotNull(paymentConf.getReport());
		dao = new dao.PaymentsStubDAO();
		assertNotNull(dao);
		dao.initialize();
		stub = dao.getDAO();
		paymentConf = paymentConf.setPaymentDetails(stub);
		assertNotNull(paymentConf);
		assertNotNull(paymentConf.getSummary());
		assertNotNull(paymentConf.getNotification());
	}

}
