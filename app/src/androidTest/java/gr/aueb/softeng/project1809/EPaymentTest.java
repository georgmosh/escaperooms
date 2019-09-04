package gr.aueb.softeng.project1809;
import org.junit.*;

import java.util.Date;

import gr.aueb.softeng.project1809.domain.Currencies;
import gr.aueb.softeng.project1809.domain.EPayment;
import gr.aueb.softeng.project1809.domain.EReservation;
import gr.aueb.softeng.project1809.domain.MeansOfPayment;
import gr.aueb.softeng.project1809.domain.Money;
import gr.aueb.softeng.project1809.domain.PaymentReceipt;


public class EPaymentTest {
    @Test
    public void tests(){
        EPayment ep= new EPayment("pass1", "DA",new Date(2019,2,5), new Money(34, Currencies.EUR)) ;

        EReservation res = new EReservation(new Date(1,1,5),"infos",35);
        PaymentReceipt rec = new PaymentReceipt("ax0", MeansOfPayment.bitcoin,new Date(4231,4,2),23f);

        ep.setReservation(res);
        ep.setReceipt(rec);
        ep.addReceipt(rec);
        ep.addReservation(res);


        Assert.assertEquals("pass1",ep.getPassword());
        Assert.assertEquals("DA",ep.getOption());
        Assert.assertEquals(new Date(2019,2,5),ep.getDate());
        Assert.assertEquals(res,ep.getReservation());
        Assert.assertEquals(rec,ep.getReceipt());
        Assert.assertEquals("pass1" + ", by " + "DA priced at: " + ep.getPayment().getValue() + " " + ep.getPayment().getCurrency() + ", " + new Date(2019,2,5),ep.toString());


    }




}
