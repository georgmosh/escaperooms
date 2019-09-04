package gr.aueb.softeng.project1809.dao;

import android.graphics.Bitmap;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class illustrates a sample data base object implementation for Escape Rooms.
 */
public class EscapeRoomImplDAO  implements EscapeRoomsDAO, Serializable{
	protected static List<gr.aueb.softeng.project1809.domain.EEscapeRoom> entities = new ArrayList<gr.aueb.softeng.project1809.domain.EEscapeRoom>();
	protected static List<Integer> pictures = new ArrayList<Integer>();
    
    public void delete(gr.aueb.softeng.project1809.domain.EEscapeRoom entity) {
        entities.remove(entity);    
    }

    public List<gr.aueb.softeng.project1809.domain.EEscapeRoom> findAll() {
        return entities;
    }
    
    public List<Integer> findDetails() {
        return pictures;
    }

    public void save(gr.aueb.softeng.project1809.domain.EEscapeRoom entity) {
        if (! entities.contains(entity)) {
            entities.add(entity);    
        }        
    }
    public gr.aueb.softeng.project1809.domain.EEscapeRoom find(int itemNo) {
        for(gr.aueb.softeng.project1809.domain.EEscapeRoom item : entities) {
            if (item.ID == itemNo) {
                return item;
            }
        }
        return null;
    }
}
