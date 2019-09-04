package tests;

import domain.EPayment;
import domain.EReservation;
import domain.MeansOfPayment;
import domain.PaymentReceipt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EPaymentTest {
    @Test
    public void tests(){
        EPayment ep= new EPayment("pass1", "DA",new Date(2019,2,5)) ;

        EReservation res = new EReservation(new Date(1,1,5),"infos",35);
        PaymentReceipt rec = new PaymentReceipt("ax0",MeansOfPayment.bitcoin,new Date(4231,4,2),23f);

        ep.setReservation(res);
        ep.setReceipt(rec);
        ep.addReceipt(rec);
        ep.addReservation(res);


        Assertions.assertEquals("pass1",ep.getPassword());
        Assertions.assertEquals("DA",ep.getOption());
        Assertions.assertEquals(new Date(2019,2,5),ep.getDate());
        Assertions.assertEquals(res,ep.getReservation());
        Assertions.assertEquals(rec,ep.getReceipt());
        Assertions.assertEquals("pass1" + ", by " + "DA" + " " + new Date(2019,2,5),ep.toString());


    }




}
