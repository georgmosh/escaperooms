package dao;

import java.util.ArrayList;
import java.util.List;

public interface EscapeRoomsDAO {
    domain.EEscapeRoom find(int itemNo);
    void save(domain.EEscapeRoom entity);
    void delete(domain.EEscapeRoom entity);
    List<domain.EEscapeRoom> findAll();
    List<java.awt.Image> findDetails();
}
