package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import domain.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class EReservationTest {


    @Test
    public void tests() {
        Set<EReservation> reservations = new HashSet<EReservation>();
        EEmployee employee = new EEmployee("user1", "pass1", "firstname1", "lastname1", "0011");
        ECustomer customer = new ECustomer("user2", "pass2", "firstname2", "lastname2", "id2", new Barcode("a", "b"), reservations);


        EPayment payment =new EPayment("pass3","AB", new Date(1,1,1));
        EEscapeRoom escapeRoom = new EStandardEscapeRoom("a",1,2,3,new Money(30f,Currencies.EUR));

        EReservation res = new EReservation(new Date(2,2,2),"info",10);

        res.setEmployee(employee);
        res.setCustomer(customer);
        res.setPayment(payment);
        res.setEscapeRoom(escapeRoom);


        Assertions.assertEquals(new Date(2,2,2),res.getDate());
        Assertions.assertEquals("info",res.getPaymentInfo());
        Assertions.assertEquals(10,res.getNumberOfPeople());
        Assertions.assertEquals(employee,res.getEmployee());
        Assertions.assertEquals(customer,res.getCustomer());
        Assertions.assertEquals(escapeRoom,res.getEscapeRoom());
        Assertions.assertEquals(payment,res.getPayment());
        Assertions.assertEquals("Reservation information:\n" + new Date(2,2,2) + " paid by " + "info"  + ", capacity: " + "10",res.toString());


    }
}