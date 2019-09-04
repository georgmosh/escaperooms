package domain;
import java.util.Date;

public class CashPayment extends EPayment {
	/* Overloaded Constructor */
    public CashPayment(EPayment p) {
    	super(p.getPassword(), p.getOption(), p.getDate());
    }
}
