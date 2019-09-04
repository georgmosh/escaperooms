package domain;
public class ReservationInfo {
	/* Domain Model: Instance variables */
    private String[] names;

    /* Overloaded Constructor */
    public ReservationInfo(String[] names) {
        this.names = names;
    }

    /* Getters */
    public String[] getNames() {
        return names;
    }
}
