package gr.aueb.softeng.project1809.services;

import android.util.Log;

import java.util.ArrayList;

import gr.aueb.softeng.project1809.domain.Currencies;

/**
 * This class implements calculations on standard Escape Rooms configurations modification.
 */
public class ECustomModificationItem {
	String[] modificationDescription;
	ArrayList<String> modificationElements = null;
	gr.aueb.softeng.project1809.domain.EStandardEscapeRoom room;
	
	public ECustomModificationItem(String[] s) {
		this.modificationDescription = s;
	}

	public void elicitateAttributes(String name) {
		String[] Price = modificationDescription[0].split(" ");
		float num = Float.parseFloat(Price[0]);
		Currencies curr = null;
		if(Price[1].equals("EUR")) curr = Currencies.EUR;
			else if(Price[1].equals("USD")) curr = Currencies.USD;
			else if(Price[1].equals("GBP")) curr = Currencies.GBP;
			else if(Price[1].equals("JPY")) curr = Currencies.JPY;
			else if(Price[1].equals("CHF")) curr = Currencies.CHF;
		gr.aueb.softeng.project1809.domain.Money price = new gr.aueb.softeng.project1809.domain.Money(num, curr);
		int difficulty = Integer.parseInt(modificationDescription[1]);
		int duration = Integer.parseInt(modificationDescription[2]);
		int capacity = Integer.parseInt(modificationDescription[3]);
		Log.e("NEW_DIFFICULTY", difficulty+"");
		Log.e("NEW_DURATION", duration+"");
		Log.e("NEW_CAPACITY", capacity+"");
		Log.e("NEW_PRICE", price.toString());
		room = new gr.aueb.softeng.project1809.domain.EStandardEscapeRoom(name, difficulty, duration, capacity, price);
	}
	
	public void generateModification() {
		String[] references = modificationDescription[modificationDescription.length-1].split(".");
		modificationElements = new ArrayList<String>(references.length);
		for(String ref: references) {
			if(ref.startsWith(" ")) ref = ref.substring(1, ref.length());
			modificationElements.add(ref);
		}
	}

	public gr.aueb.softeng.project1809.domain.EStandardEscapeRoom getRoom() {
		return this.room;
	}

	public ArrayList<String> getGeneratedModification() {
		return modificationElements;
	}
}
