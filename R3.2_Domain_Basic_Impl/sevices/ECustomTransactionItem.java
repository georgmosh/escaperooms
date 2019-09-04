package sevices;

public class ECustomTransactionItem {
	dao.WebBankingAPI API;
	CardReaderService POS;
	
	public ECustomTransactionItem(dao.WebBankingAPI API, CardReaderService POS) {
		this.API = API;
		this.POS = POS;
	}
	
	public boolean enableSwipes() {
		return (API.getEligibility());
	}
	
	public domain.EPayment getTransactionDetails(CreditCard card, domain.EPayment payment, int mode) {
		domain.EPayment newPayment;
		if(mode == 0) {
			POS.readCard(card);
			newPayment = this.registerPayment(card, payment);
		}else if(mode == 1) {
			newPayment = new domain.CashPayment(payment);
		}else {
			newPayment = payment;
		}
		return newPayment;
	}
	
	public domain.EPayment registerPayment(CreditCard card, domain.EPayment payment){
		return new domain.CardPayment(payment, card.getCardCode(), card.getCardName(), card.getExpirationDate());
	}
}
