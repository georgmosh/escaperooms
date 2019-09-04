package gr.aueb.softeng.project1809;
import org.junit.*;

import gr.aueb.softeng.project1809.dao.EscapeRoomStubDAO;
import gr.aueb.softeng.project1809.dao.EscapeRoomsDAO;
import gr.aueb.softeng.project1809.services.ECustomConfiguration;

public class ViewEscapeRooms {
	
	@Test
	void Test() {
		EscapeRoomStubDAO dao = new EscapeRoomStubDAO();
		dao.initialize();
		EscapeRoomsDAO stub = dao.getDAO();
		ECustomConfiguration config = new ECustomConfiguration();
		config = config.submit(1, stub);
		Assert.assertNotNull(config);
		Assert.assertNotNull(config.getconfiguredEscapeRoom());
		config = config.getCurrentConfiguration();
		Assert.assertNotNull(config.getname());
		Assert.assertNotNull(config.getdescription());
		//config = config.expand(stub);
		Assert.assertNotNull(config.getconfiguredEscapeRoomDetails());
		Assert.assertNotNull((config.getSummary().toString()));
	}

}
