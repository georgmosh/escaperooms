package gr.aueb.softeng.project1809.services;

import android.graphics.Bitmap;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements Escape Rooms Demonstration; as sample or modified configurations.
 */
public class ECustomConfiguration implements Serializable {
	private gr.aueb.softeng.project1809.domain.EEscapeRoom configuredEscapeRoom;
	private ECustomConfigurationItem configuredEscapeRoomDetails;
	private ECustomModificationItem modifiedEscapeRoomDetails;
	private String name, description;
	private String[] descriptionPrefix;
	gr.aueb.softeng.project1809.dao.EscapeRoomsDAO dao;
	gr.aueb.softeng.project1809.services.PConfigurationSummary summary;
	gr.aueb.softeng.project1809.services.PModificationSummary modSummary;
	
	public ECustomConfiguration() {}
	
	public ECustomConfiguration(int escapeRoomID, gr.aueb.softeng.project1809.dao.EscapeRoomsDAO dao) {
		List<gr.aueb.softeng.project1809.domain.EEscapeRoom> data = dao.findAll();
		for(gr.aueb.softeng.project1809.domain.EEscapeRoom e: data) {
			if(e.CurrID == escapeRoomID)configuredEscapeRoom = e;
		}
		this.dao = dao;
	}
	
	public ECustomConfiguration submit(int ID, gr.aueb.softeng.project1809.dao.EscapeRoomsDAO dao) {
		ECustomConfiguration e = new ECustomConfiguration(ID, dao);
		return e;
	}
	
	public ECustomConfiguration getCurrentConfiguration() {
		this.name = configuredEscapeRoom.getEscapeRoomName();
		this.description = configuredEscapeRoom.getEscapeRoomDescription();
		ECustomConfigurationItem configurationElement = new ECustomConfigurationItem();
		Integer view = configurationElement.getItemInformation(dao, configuredEscapeRoom);
		summary = new PConfigurationSummary(view);
		return this;
	}
	
	public ECustomConfiguration expand() {
		gr.aueb.softeng.project1809.domain.Money price = configuredEscapeRoom.getPrice();
		summary = new PConfigurationSummary(name, description, summary.getView(), price);
		return this;
	}
	
	public ECustomConfiguration modify(gr.aueb.softeng.project1809.ui.UIDialogTemplate dialog) {
		descriptionPrefix = dialog.getFurtherDetails();
		modifiedEscapeRoomDetails = new ECustomModificationItem(descriptionPrefix);
		summary = new PConfigurationSummary(summary, descriptionPrefix[4]);
		return this;
	}
	
	public void setModificationEnabled(EmailProviderService mailServer, EmailAddress to) {
		modifiedEscapeRoomDetails.elicitateAttributes(configuredEscapeRoom.getName());
		modifiedEscapeRoomDetails.generateModification();
		ArrayList<String> modification = modifiedEscapeRoomDetails.getGeneratedModification();
		gr.aueb.softeng.project1809.domain.EEscapeRoom tempEscapeRoom = modifiedEscapeRoomDetails.getRoom();
		configuredEscapeRoom = new gr.aueb.softeng.project1809.domain.EModifiedEscapeRoom(tempEscapeRoom.getName(), tempEscapeRoom.getDifficulty(), tempEscapeRoom.getDuration(),tempEscapeRoom.getCapacity(), tempEscapeRoom.getPrice(),modification);
		modSummary = new PModificationSummary(dao,configuredEscapeRoom);
		summary = new PConfigurationSummary(tempEscapeRoom, summary.getView(), descriptionPrefix[4]);
		modSummary.informDataWarehouse();
		if(to != null) {
			EmailMessage message = new EmailMessage(to, "Your EscapeRoom reservation details!", summary.toString());
			modSummary.emailReservationDetails(mailServer, message);
		}
	}
	
	public gr.aueb.softeng.project1809.domain.EEscapeRoom getconfiguredEscapeRoom(){
		return configuredEscapeRoom;
	}
	
	public ECustomConfigurationItem getconfiguredEscapeRoomDetails() {
		return configuredEscapeRoomDetails;
	}
	
	public String getname() {
		return name;
	}
	
	public String getdescription() {
		return description;
	}
	
	public gr.aueb.softeng.project1809.services.PConfigurationSummary getSummary() {
		return summary;
	}
}
