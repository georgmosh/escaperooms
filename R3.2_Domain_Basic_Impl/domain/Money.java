package domain;

public class Money {
	private float value;
	private Currencies currency;
	
	public Money(float value, Currencies currency) {
		this.value = value;
		this.currency = currency;
	}
	
	public float getValue() {
		return this.value;
	}
	
	public Currencies getCurrency() {
		return this.currency;
	}
}
