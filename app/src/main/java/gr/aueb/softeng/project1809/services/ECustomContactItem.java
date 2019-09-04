package gr.aueb.softeng.project1809.services;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class implements calculations on Users' contact.
 */
public class ECustomContactItem {
	gr.aueb.softeng.project1809.dao.EmployeesDAO dao;
	gr.aueb.softeng.project1809.domain.EReservation reservation;
	gr.aueb.softeng.project1809.domain.EEmployee employee;
	String message;
	
	public ECustomContactItem(gr.aueb.softeng.project1809.dao.EmployeesDAO dao, gr.aueb.softeng.project1809.domain.EReservation reservation, String message) {
		this.dao = dao;
		this.reservation = reservation;
		this.message = message;
	}
	
	public void assignToEmployee() {
		List<gr.aueb.softeng.project1809.domain.EEmployee> employees = dao.findAll();
		int empID =  ThreadLocalRandom.current().nextInt(1, employees.size());
		employee = employees.get(empID);
		employee.addReservation(reservation);
	}
	
	public String toString() {
		return "Employee " + employee.getFirstName() + " " + employee.getLastName() + " will help you with your reservation!";
	}
}
