import java.util.ArrayList;

public class ConfiguredRoom {
    private Money ConfiguredPrice;
    private java.util.ArrayList<String> configInfo;

    public ConfiguredRoom(Money configuredPrice, ArrayList<String> configInfo) {
        ConfiguredPrice = configuredPrice;
        this.configInfo = configInfo;
    }

    public Money getConfiguredPrice() {
        return ConfiguredPrice;
    }

    public ArrayList<String> getConfigInfo() {
        return configInfo;
    }
}
