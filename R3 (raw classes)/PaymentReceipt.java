import java.util.Date;

public class PaymentReceipt {
    private String code;
    private MeansOfPayment type;
    private java.util.Date date;
    private float amount;

    public PaymentReceipt(String code, MeansOfPayment type, Date date, float amount) {
        this.code = code;
        this.type = type;
        this.date = date;
        this.amount = amount;
    }

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
}
