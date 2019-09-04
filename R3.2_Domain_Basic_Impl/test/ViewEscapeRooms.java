package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class ViewEscapeRooms {
	
	@Test
	void Test() {
		dao.EscapeRoomStubDAO dao = new dao.EscapeRoomStubDAO();
		dao.initialize();
		dao.EscapeRoomsDAO stub = dao.getDAO();
		sevices.ECustomConfiguration config = new sevices.ECustomConfiguration();
		config = config.submit(1, stub);
		assertNotNull(config);	
		assertNotNull(config.getconfiguredEscapeRoom());
		config = config.getCurrentConfiguration();
		assertNotNull(config.getname());
		assertNotNull(config.getdescription());
		config = config.expand(stub);
		assertNotNull(config.getconfiguredEscapeRoomDetails());
		assertNotNull((config.getSummary().toString()));
	}

}
