package sevices;

import java.util.List;

public class ECustomConfigurationItem {
	
	public java.awt.Image getItemInformation(dao.EscapeRoomsDAO dao, domain.EEscapeRoom configuredEscapeRoom){
		List<java.awt.Image> data = dao.findDetails();
		return data.get(configuredEscapeRoom.CurrID);
	}
}
