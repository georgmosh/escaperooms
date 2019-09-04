package dao;

public class CustomersStubDAO {
	CustomersImplDAO stub = new CustomersImplDAO();

	public void initialize() {
		domain.ECustomer c1 = new domain.ECustomer("user1","1234","Georgios","Moschovis","USER021", new domain.Barcode("BCD102", "DSlso2%&js"),null);
		domain.ECustomer c2 = new domain.ECustomer("user2","5678","Stavros","Markopoulos","USER052", new domain.Barcode("BCD425", "KSo3$*sw!"),null);
		domain.ECustomer c3 = new domain.ECustomer("user3","7654","Professor Nikolaos","Diamantidis","USER052", new domain.Barcode("BCD928", "KS92S#%l"),null);
		stub.save(c1);
		stub.save(c2);
		stub.save(c3);
	}
	
	public CustomersDAO getDAO() {
		return stub;
	}
}
