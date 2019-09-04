package gr.aueb.softeng.project1809.dao;

import android.graphics.Bitmap;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * This class illustrates a sample data base object interface for Escape Rooms.
 */
public interface EscapeRoomsDAO {
    gr.aueb.softeng.project1809.domain.EEscapeRoom find(int itemNo);
    void save(gr.aueb.softeng.project1809.domain.EEscapeRoom entity);
    void delete(gr.aueb.softeng.project1809.domain.EEscapeRoom entity);
    List<gr.aueb.softeng.project1809.domain.EEscapeRoom> findAll();
    List<Integer> findDetails();
}
