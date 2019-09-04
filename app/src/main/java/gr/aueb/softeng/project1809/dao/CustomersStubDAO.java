package gr.aueb.softeng.project1809.dao;

/**
 * This class illustrates a sample data base object container.
 */
public class CustomersStubDAO {
	CustomersImplDAO stub = new CustomersImplDAO();

	public void initialize() {
		gr.aueb.softeng.project1809.domain.ECustomer c1 = new gr.aueb.softeng.project1809.domain.ECustomer("user1","1234","Georgios","Moschovis","USER021", new gr.aueb.softeng.project1809.domain.Barcode("BCD102", "DSlso2%&js"),null);
		gr.aueb.softeng.project1809.domain.ECustomer c2 = new gr.aueb.softeng.project1809.domain.ECustomer("user2","5678","Stavros","Markopoulos","USER052", new gr.aueb.softeng.project1809.domain.Barcode("BCD425", "KSo3$*sw!"),null);
		gr.aueb.softeng.project1809.domain.ECustomer c3 = new gr.aueb.softeng.project1809.domain.ECustomer("user3","7654","Professor Nikolaos","Diamantidis","USER052", new gr.aueb.softeng.project1809.domain.Barcode("BCD928", "KS92S#%l"),null);
		stub.save(c1);
		stub.save(c2);
		stub.save(c3);
	}
	
	public CustomersDAO getDAO() {
		return stub;
	}
}
