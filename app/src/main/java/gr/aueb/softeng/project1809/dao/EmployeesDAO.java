package gr.aueb.softeng.project1809.dao;

import java.util.List;

/**
 * This class illustrates a sample data base object interface for Employees.
 */
public interface EmployeesDAO extends UsersDAO {
    gr.aueb.softeng.project1809.domain.EEmployee find(String employeeSSN);
    void save(gr.aueb.softeng.project1809.domain.EEmployee entity);
    void delete(gr.aueb.softeng.project1809.domain.EEmployee entity);
    List<gr.aueb.softeng.project1809.domain.EEmployee> findAll();
}
