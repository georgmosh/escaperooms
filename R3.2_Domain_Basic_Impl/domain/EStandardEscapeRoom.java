package domain;
public class EStandardEscapeRoom extends EEscapeRoom{
	/* Domain Model: Instance variables */
	private Money price;

	/* Overloaded Constructor */
    public EStandardEscapeRoom(String name, int difficulty, int duration, int capacity, Money price) {
    	super(name, difficulty, duration, capacity);
        this.price = price;
    }

    /* Getters */
    public Money getPrice() {
        return price;
    }
}
