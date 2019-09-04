package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import sevices.ECustomReservation;
import sevices.EmailAddress;
import sevices.EmailProviderService;

class MakeSampleReservation {

	@Test
	void test() {
		String CustomerID = "USER021";
		int EscapeRoomID = 1;
		Date date = new Date(2018,4,21);
		String paymentInfo = "Cash";
		int numberOfPeople = 4;
		dao.ReservationsStubDAO dao = new dao.ReservationsStubDAO();
		assertNotNull(dao);
		dao.initialize();
		dao.ReservationsDAO stub = dao.getDAO();
		assertNotNull(stub);
		dao.EscapeRoomStubDAO dao1 = new dao.EscapeRoomStubDAO();
		assertNotNull(dao1);
		dao1.initialize();
		dao.EscapeRoomsDAO stub1 = dao1.getDAO();
		assertNotNull(stub1);
		dao.CustomersStubDAO dao2 =  new dao.CustomersStubDAO();
		assertNotNull(dao2);
		dao2.initialize();
		dao.CustomersDAO stub2 = dao2.getDAO();
		assertNotNull(stub2);
		EmailProviderService mailServer = new sevices.EmailProviderStub();
		assertNotNull(mailServer);
		EmailAddress to = new sevices.EmailAddress("georgiosmoshovis@hotmail.gr");
		ECustomReservation reserv = new ECustomReservation();
		assertNotNull(reserv);
		reserv = reserv.submit(CustomerID, EscapeRoomID, date, paymentInfo, numberOfPeople, stub1, stub2);
		assertNotNull(reserv.getElement());
		assertNotNull(reserv.getReport());
		reserv = reserv.confirm(stub, mailServer, to);
		assertNotNull((reserv.summarize().toString()));
	}

}
