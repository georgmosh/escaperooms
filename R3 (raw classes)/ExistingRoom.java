public class ExistingRoom extends EscapeRoom{
    private Money price;

    public ExistingRoom(Money price) {
        this.price = price;
    }

    public Money getPrice() {
        return price;
    }
}
