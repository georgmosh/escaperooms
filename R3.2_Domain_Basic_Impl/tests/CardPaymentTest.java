package tests;
import domain.*;
import java.util.Date;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CardPaymentTest {

    @Test
    public void getterTest() {
        EPayment p = new EPayment("123","A",new Date(1,1,1));
        String code = "test1";
        String name = "test2";
        Date expDate = new Date (2,1,1);

        CardPayment cp = new CardPayment(p,code,name,expDate);
        Assertions.assertEquals("test1",cp.getCode());
        Assertions.assertEquals("test2",cp.getName());
        Assertions.assertEquals(expDate,cp.getExpDate());

    }
}