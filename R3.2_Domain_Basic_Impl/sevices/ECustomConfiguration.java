package sevices;

import java.util.List;

public class ECustomConfiguration {
	private domain.EEscapeRoom configuredEscapeRoom;
	private ECustomConfigurationItem configuredEscapeRoomDetails;
	private String name, description;
	sevices.PConfigurationSummary summary;
	
	public ECustomConfiguration() {}
	
	public ECustomConfiguration(int escapeRoomID, dao.EscapeRoomsDAO dao) {
		List<domain.EEscapeRoom> data = dao.findAll();
		for(domain.EEscapeRoom e: data) {
			if(e.CurrID == escapeRoomID)configuredEscapeRoom = e;
		}
	}
	
	public ECustomConfiguration submit(int ID, dao.EscapeRoomsDAO dao) {
		ECustomConfiguration e = new ECustomConfiguration(ID, dao);
		return e;
	}
	
	public ECustomConfiguration getCurrentConfiguration() {
		this.name = configuredEscapeRoom.getEscapeRoomName();
		this.description = configuredEscapeRoom.getEscapeRoomDescription();
		return this;
	}
	
	public ECustomConfiguration expand(dao.EscapeRoomsDAO dao) {
		configuredEscapeRoomDetails = new ECustomConfigurationItem();
		java.awt.Image view = configuredEscapeRoomDetails.getItemInformation(dao, configuredEscapeRoom);
		summary = new PConfigurationSummary(name, description, view);
		return this;
	}
	
	public domain.EEscapeRoom getconfiguredEscapeRoom(){
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
	
	public sevices.PConfigurationSummary getSummary() {
		return summary;
	}
}
