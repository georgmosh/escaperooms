package domain;
import java.util.Date;

public class PaymentReceipt {
	/* Domain Model: Instance variables */
    private String code;
    private MeansOfPayment type;
    private Date date;
    private float amount;
    
    /* Domain Model - Suite: Entity's Relations */
    private EPayment payment;

    /* Overloaded Constructor */
    public PaymentReceipt(String code, MeansOfPayment type, Date date, float amount) {
        this.code = code;
        this.type = type;
        this.date = date;
        this.amount = amount;
    }
    
    /* Setters */
    public void setPayment(EPayment payment) {
    	this.payment = payment;
    }

    /* Getters */
    public String getCode() {
        return code;
    }

    public MeansOfPayment getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public float getAmount() {
        return amount;
    }
    
    public EPayment getPayment() {
    	return payment;
    }
}
