import java.util.Date;

public class Reservation {
    private java.util.Date date;
    private String paymentInfo;
    private int numberOfPeople;

    public Reservation(Date date, String paymentInfo, int numberOfPeople) {
        this.date = date;
        this.paymentInfo = paymentInfo;
        this.numberOfPeople = numberOfPeople;
    }

    public Date getDate() {
        return date;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }
}
