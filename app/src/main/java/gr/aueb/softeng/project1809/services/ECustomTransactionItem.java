package gr.aueb.softeng.project1809.services;

/**
 * This class implements computations on Transactions.
 */
public class ECustomTransactionItem {
	gr.aueb.softeng.project1809.dao.WebBankingAPI API;
	CardReaderService POS;
	
	public ECustomTransactionItem(gr.aueb.softeng.project1809.dao.WebBankingAPI API, CardReaderService POS) {
		this.API = API;
		this.POS = POS;
	}
	
	public boolean enableSwipes() {
		return (API.getEligibility());
	}
	
	public gr.aueb.softeng.project1809.domain.EPayment getTransactionDetails(CreditCard card, gr.aueb.softeng.project1809.domain.EPayment payment, int mode) {
		gr.aueb.softeng.project1809.domain.EPayment newPayment;
		if(mode == 0) {
			POS.readCard(card);
			newPayment = this.registerPayment(card, payment);
		}else if(mode == 1) {
			newPayment = new gr.aueb.softeng.project1809.domain.CashPayment(payment);
		}else {
			newPayment = payment;
		}
		return newPayment;
	}
	
	public gr.aueb.softeng.project1809.domain.EPayment registerPayment(CreditCard card, gr.aueb.softeng.project1809.domain.EPayment payment){
		return new gr.aueb.softeng.project1809.domain.CardPayment(payment, card.getCardCode(), card.getCardName(), card.getExpirationDate());
	}
}
