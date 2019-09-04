package dao;

import java.util.List;

public interface ReservationsDAO {
	void save(domain.EReservation entity);
    void delete(domain.EReservation entity);
    List<domain.EReservation> findAll();
}
