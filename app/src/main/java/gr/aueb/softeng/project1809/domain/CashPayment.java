package gr.aueb.softeng.project1809.domain;
import java.util.Date;

/**
 * This class illustrates a Cash Payment.
 */
public class CashPayment extends EPayment {
	/* Overloaded Constructor */
    public CashPayment(EPayment p) {
    	super(p.getPassword(), p.getOption(), p.getDate(), p.getPayment());
    }
}
