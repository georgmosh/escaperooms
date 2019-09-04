package gr.aueb.softeng.project1809.services;

import android.graphics.Bitmap;
import android.widget.ImageView;

import java.io.Serializable;

import gr.aueb.softeng.project1809.domain.EEscapeRoom;

/**
 * This class illustrates a configuration summary.
 */
public class PConfigurationSummary implements Serializable {
	private String name, description;
	private Integer view;
	private gr.aueb.softeng.project1809.domain.Money price;

	public PConfigurationSummary(Integer view) {
		this.view = view;
	}
	
	public PConfigurationSummary(String name, String description, Integer view, gr.aueb.softeng.project1809.domain.Money price) {
		this.name = name;
		this.description = description;
		this.view = view;
		this.price = price;
	}
	
	public PConfigurationSummary(PConfigurationSummary basic, String description) {
		this.name = basic.name;
		this.description = basic.description + "\n" + description;
		this.view = basic.view;
		this.price = basic.price;
	}

	public PConfigurationSummary(EEscapeRoom room, Integer view, String s) {
		this.name = room.getEscapeRoomName();
		this.description = room.getEscapeRoomDescription() + "\nExtras: " + s;
		this.view = view;
		this.price = room.getPrice();
	}

	public Integer getView() {
		return view;
	}

	public String toString() {
		return "Name: " + this.name + " \nPrice: " + this.price.getValue() + " " + this.price.getCurrency().toString()  + " \n" + this.description;
	}
}
