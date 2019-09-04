package tests;

import domain.CashPayment;
import domain.EPayment;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CashPaymentTest {

    @Test
    public void tester(){
        CashPayment cp = new CashPayment(new EPayment("123","A", new Date(1,1,1)));


    }

}