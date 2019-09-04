package gr.aueb.softeng.project1809.services;

import android.util.Log;

/**
 * This class implements Employees and Customers log-in.
 */
public class ECustomConnection {
	gr.aueb.softeng.project1809.domain.User user;
	boolean status;

	public ECustomConnection() {}
	
	public ECustomConnection(gr.aueb.softeng.project1809.domain.User user) {
		this.user = user;
	}
	
	public ECustomConnection submit(String username, String password, gr.aueb.softeng.project1809.dao.UsersDAO dao) {
	    gr.aueb.softeng.project1809.domain.User user =  dao.verify(username, password);
		ECustomConnection conn = new ECustomConnection(user);
		return conn;
	}
	
	public boolean getConnectionResult() {
		if(this.user != null) this.status = true;
			else this.status = false;
		return this.status;
	}
	
	public gr.aueb.softeng.project1809.domain.Credentials getConnectionData() {
		return this.user.getLoginData();
	}
}
