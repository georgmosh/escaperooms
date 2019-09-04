package domain;
import java.util.Date;

public class EPayment {
	/* Domain Model: Instance variables */
    private String password;
    private String option;
    private java.util.Date date;
    
    /* Domain Model - Suite: Entity's Relations */
    private EReservation reservation;
    private PaymentReceipt receipt;

    /* Overloaded Constructor */
    public EPayment(String password, String option, Date date) {
        this.password = password;
        this.option = option;
        this.date = date;
    }
    
    /* Setters */
    public void setReservation(EReservation reservation) {
    	this.reservation = reservation;
    }
    
    public void setReceipt(PaymentReceipt receipt) {
    	this.receipt = receipt;
    }
    
    /* Domain building methods */
    public void addReservation(EReservation reservation) {
    	this.setReservation(reservation);
    	reservation.setPayment(this);
    }
    
    public void addReceipt(PaymentReceipt receipt) {
    	this.setReceipt(receipt);
    	receipt.setPayment(this);
    }

    /* Getters */
    public String getPassword() {
        return password;
    }

    public String getOption() {
        return option;
    }

    public Date getDate() {
        return date;
    }
    
    public EReservation getReservation() {
    	return reservation;
    }
    
    public PaymentReceipt getReceipt() {
    	return receipt;
    }
    
    public String toString() {
    	return this.password + ", by " + this.getOption() + " " + this.date;
    }
}
