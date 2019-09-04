package domain;
import java.util.Date;

public class EReservation {
	/* Domain Model: Instance variables */
    private Date date;
    private String paymentInfo;
    private int numberOfPeople;
    
    /* Domain Model - Suite: Entity's Relations */
    private EEmployee employee;
    private ECustomer customer;
    private EPayment payment;
    private EEscapeRoom escapeRoom;

    /* Overloaded Constructor */
    public EReservation(Date date, String paymentInfo, int numberOfPeople) {
        this.date = date;
        this.paymentInfo = paymentInfo;
        this.numberOfPeople = numberOfPeople;
    }
    
    /* Setters */
    public void setEmployee(EEmployee employee) {
    	this.employee = employee;
    }

    public void setCustomer(ECustomer customer) {
    	this.customer = customer;
    }

    public void setPayment (EPayment payment) {
    	this.payment = payment;
    }

    public void setEscapeRoom (EEscapeRoom escapeRoom) {
    	this.escapeRoom = escapeRoom;
    }

    /* Getters */
    public Date getDate() {
        return date;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }
    
    public EEmployee getEmployee() {
    	return employee;
    }
    
    public ECustomer getCustomer() {
    	return customer;
    }
    
    public EPayment getPayment () {
    	return payment;
    }
    
    public EEscapeRoom getEscapeRoom () {
    	return escapeRoom;
    }
    
    public String toString() {
    	return "Reservation information:\n" + getDate() + " paid by " + getPaymentInfo()  + ", capacity: " + getNumberOfPeople();
    }
}
