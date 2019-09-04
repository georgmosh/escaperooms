package gr.aueb.softeng.project1809;

import org.junit.*;
import java.util.Date;

import gr.aueb.softeng.project1809.domain.Currencies;
import gr.aueb.softeng.project1809.domain.EPayment;
import gr.aueb.softeng.project1809.domain.MeansOfPayment;
import gr.aueb.softeng.project1809.domain.Money;
import gr.aueb.softeng.project1809.domain.PaymentReceipt;


public class PaymentReceiptTest {

    @Test
    public void testGet(){

         PaymentReceipt pr = new PaymentReceipt("test1", MeansOfPayment.bitcoin, new Date(1,1,1), 18.0f);
         EPayment ep= new EPayment("test 11","test22",new Date(2,2,2), new Money(34, Currencies.EUR));
         pr.setPayment(ep);

        Assert.assertEquals("test1",pr.getCode());
        Assert.assertEquals(MeansOfPayment.bitcoin,pr.getType());
        Assert.assertEquals(new Date(1,1,1),pr.getDate());
        Assert.assertEquals(18.0f,pr.getAmount(),0.1);
        Assert.assertEquals(ep,pr.getPayment());
    }

}



