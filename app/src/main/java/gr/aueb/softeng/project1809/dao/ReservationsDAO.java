package gr.aueb.softeng.project1809.dao;

import java.util.List;

/**
 * This class illustrates a sample data base object interface for Reservations.
 */
public interface ReservationsDAO {
	void save(gr.aueb.softeng.project1809.domain.EReservation entity);
    void delete(gr.aueb.softeng.project1809.domain.EReservation entity);
    List<gr.aueb.softeng.project1809.domain.EReservation> findAll();
}
