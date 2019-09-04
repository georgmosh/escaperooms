package dao;

public class ReservationsStubDAO {
	ReservationsImplDAO stub = new ReservationsImplDAO();

	public void initialize() {
	}
	
	public ReservationsDAO getDAO() {
		return stub;
	}
}
