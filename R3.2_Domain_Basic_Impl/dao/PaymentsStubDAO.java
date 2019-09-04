package dao;

public class PaymentsStubDAO {
		PaymentsImplDAO stub = new PaymentsImplDAO();

		public void initialize() {
		}
		
		public PaymentsDAO getDAO() {
			return stub;
		}
}
