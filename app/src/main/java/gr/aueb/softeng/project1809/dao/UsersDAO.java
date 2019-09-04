package gr.aueb.softeng.project1809.dao;

/**
 * This class illustrates a sample data base object interface for Users.
 */
public interface UsersDAO {
	gr.aueb.softeng.project1809.domain.User verify(String username, String password);
}
