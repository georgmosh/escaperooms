package dao;

import java.util.ArrayList;
import java.util.List;
import java.awt.Image;

public class EscapeRoomStubDAO  {
	EscapeRoomImplDAO stub = new EscapeRoomImplDAO();
	List<java.awt.Image> pictures = new ArrayList<java.awt.Image>();

	public void addEntities() {
		domain.EEscapeRoom e1 = new domain.EStandardEscapeRoom("Pireus", 10, 90, 5, new domain.Money(15, domain.Currencies.EUR));
		domain.EEscapeRoom e2 = new domain.EStandardEscapeRoom("Athens", 6, 30, 7, new domain.Money(20, domain.Currencies.EUR));
		domain.EEscapeRoom e3 = new domain.EStandardEscapeRoom("Washington", 10, 90, 5, new domain.Money(5, domain.Currencies.USD));
		domain.EEscapeRoom e4 = new domain.EStandardEscapeRoom("London", 10, 90, 5, new domain.Money(5, domain.Currencies.GBP));
		domain.EEscapeRoom e5 = new domain.EStandardEscapeRoom("Tokio", 10, 90, 5, new domain.Money(5, domain.Currencies.JPY));
		stub.save(e1); 
		stub.save(e2);
		stub.save(e3);
		stub.save(e4);
		stub.save(e5);
	}
	
	public void addPictures() {
		for(int i = 0; i < stub.entities.size(); i++)
			pictures.add(new ImageStub());
		EscapeRoomImplDAO.pictures = pictures;
	}
	
	public void initialize() {
		this.addEntities();
		this.addPictures();
	}
	
	public EscapeRoomsDAO getDAO() {
		return stub;
	}
}
