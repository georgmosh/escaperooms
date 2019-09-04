package gr.aueb.softeng.project1809;
import org.junit.*;
import java.util.Date;

import gr.aueb.softeng.project1809.domain.CardPayment;
import gr.aueb.softeng.project1809.domain.Currencies;
import gr.aueb.softeng.project1809.domain.EPayment;
import gr.aueb.softeng.project1809.domain.Money;


public class CardPaymentTest {

    @Test
    public void getterTest() {
        EPayment p = new EPayment("123","A",new Date(1,1,1), new Money(34, Currencies.EUR));
        String code = "test1";
        String name = "test2";
        Date expDate = new Date (2,1,1);

        CardPayment cp = new CardPayment(p,code,name,expDate);
        Assert.assertEquals("test1",cp.getCode());
        Assert.assertEquals("test2",cp.getName());
        Assert.assertEquals(expDate,cp.getExpDate());

    }
}