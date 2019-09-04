import java.util.Date;

public class Payment {
    private String password;
    private String option; //Τρόπος πληρωμής
    private java.util.Date date;

    public Payment(String password, String option, Date date) {
        this.password = password;
        this.option = option;
        this.date = date;
    }

    public String getPassword() {
        return password;
    }

    public String getOption() {
        return option;
    }

    public Date getDate() {
        return date;
    }
}
