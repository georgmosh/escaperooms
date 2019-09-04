package gr.aueb.softeng.project1809;

import org.junit.*;
import java.util.Date;

import gr.aueb.softeng.project1809.dao.CustomersDAO;
import gr.aueb.softeng.project1809.dao.CustomersStubDAO;
import gr.aueb.softeng.project1809.dao.EscapeRoomStubDAO;
import gr.aueb.softeng.project1809.dao.EscapeRoomsDAO;
import gr.aueb.softeng.project1809.dao.ReservationsDAO;
import gr.aueb.softeng.project1809.dao.ReservationsStubDAO;
import gr.aueb.softeng.project1809.services.ECustomReservation;
import gr.aueb.softeng.project1809.services.EmailAddress;
import gr.aueb.softeng.project1809.services.EmailProviderService;
import gr.aueb.softeng.project1809.services.EmailProviderStub;


public class MakeSampleReservation {

	@Test
	void test() {
		String CustomerID = "USER021";
		int EscapeRoomID = 1;
		Date date = new Date(2018,4,21);
		String paymentInfo = "Cash";
		int numberOfPeople = 4;
		ReservationsStubDAO dao = new ReservationsStubDAO();
		Assert.assertNotNull(dao);
		dao.initialize();
		ReservationsDAO stub = dao.getDAO();
		Assert.assertNotNull(stub);
		EscapeRoomStubDAO dao1 = new EscapeRoomStubDAO();
		Assert.assertNotNull(dao1);
		dao1.initialize();
		EscapeRoomsDAO stub1 = dao1.getDAO();
		Assert.assertNotNull(stub1);
		CustomersStubDAO dao2 =  new CustomersStubDAO();
		Assert.assertNotNull(dao2);
		dao2.initialize();
		CustomersDAO stub2 = dao2.getDAO();
		Assert.assertNotNull(stub2);
		EmailProviderService mailServer = new EmailProviderStub();
		Assert.assertNotNull(mailServer);
		EmailAddress to = new EmailAddress("georgiosmoshovis@hotmail.gr");
		ECustomReservation reserv = new ECustomReservation();
		Assert.assertNotNull(reserv);
		//reserv = reserv.submit(CustomerID, EscapeRoomID, date, paymentInfo, numberOfPeople, stub1, stub2);
		//Assert.assertNotNull(reserv.getElement());
		//Assert.assertNotNull(reserv.getReport());
		reserv = reserv.confirm(stub, mailServer, to);
		Assert.assertNotNull((reserv.summarize().toString()));
	}

}
