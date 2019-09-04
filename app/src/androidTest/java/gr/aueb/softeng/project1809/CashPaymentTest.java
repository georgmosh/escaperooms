package gr.aueb.softeng.project1809;
import org.junit.*;
import java.util.Date;

import gr.aueb.softeng.project1809.domain.CashPayment;
import gr.aueb.softeng.project1809.domain.Currencies;
import gr.aueb.softeng.project1809.domain.EPayment;
import gr.aueb.softeng.project1809.domain.Money;


public class CashPaymentTest {

    @Test
    public void tester(){
        CashPayment cp = new CashPayment(new EPayment("123","A", new Date(1,1,1),new Money(34, Currencies.EUR)));


    }

}