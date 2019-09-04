package gr.aueb.softeng.project1809;

import org.junit.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gr.aueb.softeng.project1809.domain.Barcode;
import gr.aueb.softeng.project1809.domain.Currencies;
import gr.aueb.softeng.project1809.domain.ECustomer;
import gr.aueb.softeng.project1809.domain.EEmployee;
import gr.aueb.softeng.project1809.domain.EEscapeRoom;
import gr.aueb.softeng.project1809.domain.EPayment;
import gr.aueb.softeng.project1809.domain.EReservation;
import gr.aueb.softeng.project1809.domain.EStandardEscapeRoom;
import gr.aueb.softeng.project1809.domain.Money;


public class EReservationTest {


    @Test
    public void tests() {
        List<EReservation> reservations = new ArrayList<EReservation>();
        EEmployee employee = new EEmployee("user1", "pass1", "firstname1", "lastname1", "0011");
        ECustomer customer = new ECustomer("user2", "pass2", "firstname2", "lastname2", "id2", new Barcode("a", "b"), reservations);


        EPayment payment =new EPayment("pass3","AB", new Date(1,1,1), new Money(34, Currencies.EUR));
        EEscapeRoom escapeRoom = new EStandardEscapeRoom("a",1,2,3,new Money(30f,Currencies.EUR));

        EReservation res = new EReservation(new Date(2,2,2),"info",10);

        res.setEmployee(employee);
        res.setCustomer(customer);
        res.setPayment(payment);
        res.setEscapeRoom(escapeRoom);


        Assert.assertEquals(new Date(2,2,2),res.getDate());
        Assert.assertEquals("info",res.getPaymentInfo());
        Assert.assertEquals(10,res.getNumberOfPeople());
        Assert.assertEquals(employee,res.getEmployee());
        Assert.assertEquals(customer,res.getCustomer());
        Assert.assertEquals(escapeRoom,res.getEscapeRoom());
        Assert.assertEquals(payment,res.getPayment());
        Assert.assertEquals("Reservation with ID: 3  information:\n" + new Date(2,2,2) + " paid by " + "info"  + ", capacity: " + "10",res.toString());


    }
}