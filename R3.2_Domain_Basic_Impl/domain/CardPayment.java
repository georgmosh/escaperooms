package domain;
import java.util.Date;

public class CardPayment extends EPayment {
	/* Domain Model: Instance variables */
    private String code;
    private String name;
    private java.util.Date expDate;

    /* Overloaded Constructor */
    public CardPayment(EPayment p, String code, String name, Date expDate) {
    	super(p.getPassword(), p.getOption(), p.getDate());
    	this.code = code;
        this.name = name;
        this.expDate = expDate;
    }

    /* Getters */
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Date getExpDate() {
        return expDate;
    }
}
