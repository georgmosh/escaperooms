package domain;
import java.util.ArrayList;

public class EModifiedEscapeRoom extends EEscapeRoom {
	/* Domain Model: Instance variables */
	private Money ConfiguredPrice;
    private java.util.ArrayList<String> configInfo;
    
    /* Overloaded Constructor */
    public EModifiedEscapeRoom(String name, int difficulty, int duration, int capacity, Money configuredPrice, ArrayList<String> configInfo) {
    	super(name, difficulty, duration, capacity);
    	ConfiguredPrice = configuredPrice;
        this.configInfo = configInfo;
    }

    /* Getters */
    public Money getPrice() {
        return ConfiguredPrice;
    }

    public ArrayList<String> getConfigInfo() {
        return configInfo;
    }
}
