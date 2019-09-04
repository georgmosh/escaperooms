package gr.aueb.softeng.project1809.dao;

/**
 * This class illustrates a sample data base object container.
 */
public class EmployeesStubDAO {
    EmployeesImplDAO stub = new EmployeesImplDAO();

    public void initialize() {
        gr.aueb.softeng.project1809.domain.EEmployee e1 = new gr.aueb.softeng.project1809.domain.EEmployee("userE1","1234","Georgios","Moschovis","029152320");
        gr.aueb.softeng.project1809.domain.EEmployee e2 = new gr.aueb.softeng.project1809.domain.EEmployee("userE2","5678","Stavros","Markopoulos","029475698");
        gr.aueb.softeng.project1809.domain.EEmployee e3 = new gr.aueb.softeng.project1809.domain.EEmployee("userE3","7654","Professor Nikolaos","Diamantidis","025259887");
        stub.save(e1);
        stub.save(e2);
        stub.save(e3);
    }

    public EmployeesImplDAO getDAO() {
        return stub;
    }
}
