package tests;

import domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PaymentReceiptTest {

    @Test
    public void testGet(){

         PaymentReceipt pr = new PaymentReceipt("test1", MeansOfPayment.bitcoin, new Date(1,1,1), 18.0f);
         EPayment ep= new EPayment("test 11","test22",new Date(2,2,2));
         pr.setPayment(ep);

        Assertions.assertEquals("test1",pr.getCode());
        Assertions.assertEquals(MeansOfPayment.bitcoin,pr.getType());
        Assertions.assertEquals(new Date(1,1,1),pr.getDate());
        Assertions.assertEquals(18.0f,pr.getAmount());
        Assertions.assertEquals(ep,pr.getPayment());
    }

}



