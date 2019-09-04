package gr.aueb.softeng.project1809.services;

import android.graphics.Bitmap;
import android.widget.ImageView;

import java.util.List;

/**
 * This class implements computations on sample or modified Escape Room configurations.
 */
public class ECustomConfigurationItem {
	
	public Integer getItemInformation(gr.aueb.softeng.project1809.dao.EscapeRoomsDAO dao, gr.aueb.softeng.project1809.domain.EEscapeRoom configuredEscapeRoom){
		List<Integer> data = dao.findDetails();
		return data.get(configuredEscapeRoom.CurrID);
	}
}
