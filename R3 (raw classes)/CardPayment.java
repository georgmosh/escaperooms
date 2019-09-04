import java.util.Date;

public class CardPayment {
    private String code;
    private String name;
    private java.util.Date expDate;

    public CardPayment(String code, String name, Date expDate) {
        this.code = code;
        this.name = name;
        this.expDate = expDate;
    }

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
