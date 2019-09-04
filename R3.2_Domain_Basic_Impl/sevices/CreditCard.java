package sevices;

import java.util.Date;

public class CreditCard {
    private String cardCode;
    private String cardName;
    private Date expirationDate;
    
    public CreditCard(String code, String name, Date expiry) {
    	this.cardCode = code;
    	this.cardName = name;
    	this.expirationDate = expiry;
    }
    
    public String getCardCode() {
    	return cardCode;
    }
    
    public String getCardName() {
    	return cardCode;
    }
    
    public Date getExpirationDate() {
    	return expirationDate;
    }
}
