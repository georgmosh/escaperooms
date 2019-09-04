package gr.aueb.softeng.project1809.dao;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1809.R;

/**
 * This class illustrates a sample data base object container.
 */
public class EscapeRoomStubDAO  {
	EscapeRoomImplDAO stub = new EscapeRoomImplDAO();
	List<Integer> pictures = new ArrayList<Integer>();

	public EscapeRoomStubDAO() {}

	public void addEntities() {
		gr.aueb.softeng.project1809.domain.EEscapeRoom e1 = new gr.aueb.softeng.project1809.domain.EStandardEscapeRoom("Escape Room Pireus", 10, 90, 5, new gr.aueb.softeng.project1809.domain.Money(15, gr.aueb.softeng.project1809.domain.Currencies.EUR));
		gr.aueb.softeng.project1809.domain.EEscapeRoom e2 = new gr.aueb.softeng.project1809.domain.EStandardEscapeRoom("Escape Room Athens", 6, 30, 7, new gr.aueb.softeng.project1809.domain.Money(20, gr.aueb.softeng.project1809.domain.Currencies.EUR));
		gr.aueb.softeng.project1809.domain.EEscapeRoom e3 = new gr.aueb.softeng.project1809.domain.EStandardEscapeRoom("Escape Room Washington", 10, 90, 5, new gr.aueb.softeng.project1809.domain.Money(5, gr.aueb.softeng.project1809.domain.Currencies.USD));
		gr.aueb.softeng.project1809.domain.EEscapeRoom e4 = new gr.aueb.softeng.project1809.domain.EStandardEscapeRoom("Escape Room London", 10, 90, 5, new gr.aueb.softeng.project1809.domain.Money(5, gr.aueb.softeng.project1809.domain.Currencies.GBP));
		gr.aueb.softeng.project1809.domain.EEscapeRoom e5 = new gr.aueb.softeng.project1809.domain.EStandardEscapeRoom("Escape Room Tokio", 10, 90, 5, new gr.aueb.softeng.project1809.domain.Money(5, gr.aueb.softeng.project1809.domain.Currencies.JPY));
		stub.save(e1); 
		stub.save(e2);
		stub.save(e3);
		stub.save(e4);
		stub.save(e5);
	}
	
	public void addPictures() {
		pictures.add(R.drawable.image1);
		pictures.add(R.drawable.image2);
		pictures.add(R.drawable.image3);
		pictures.add(R.drawable.image4);
		pictures.add(R.drawable.image5);
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
