package dao;

import java.util.ArrayList;
import java.util.List;

public class EscapeRoomImplDAO  implements EscapeRoomsDAO{
	protected static List<domain.EEscapeRoom> entities = new ArrayList<domain.EEscapeRoom>();
	protected static List<java.awt.Image> pictures = new ArrayList<java.awt.Image>();
    
    public void delete(domain.EEscapeRoom entity) {
        entities.remove(entity);    
    }

    public List<domain.EEscapeRoom> findAll() {
        return entities;
    }
    
    public List<java.awt.Image> findDetails() {
        return pictures;
    }

    public void save(domain.EEscapeRoom entity) {
        if (! entities.contains(entity)) {
            entities.add(entity);    
        }        
    }
    public domain.EEscapeRoom find(int itemNo) {
        for(domain.EEscapeRoom item : entities) {
            if (item.ID == itemNo) {
                return item;
            }
        }
        return null;
    }
}
