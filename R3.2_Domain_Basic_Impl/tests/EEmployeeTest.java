package tests;

import domain.Barcode;
import domain.ECustomer;
import domain.EEmployee;
import domain.EReservation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class EEmployeeTest {

    @Test
    public void testall(){
        String username = "user1";
        String password = "password1";
        String firstName = "first1";
        String lastName = "last1";
        String AMKA = "AMKA1";
        String ID = "ID1";
        Barcode RFID = new Barcode("data1","epc1");;
        Set<EReservation> reservations =new HashSet<EReservation>();

        EEmployee em1 = new EEmployee(username,password,firstName,lastName,AMKA);

        Assertions.assertEquals("first1",em1.getFirstName());
        Assertions.assertEquals("last1",em1.getLastName());
        Assertions.assertEquals("AMKA1", em1.getAMKA());


        EReservation res = new EReservation(new Date(2,2,2),"info",10);
        em1.insertReservation(res);
        ECustomer ec = new ECustomer(username, password, firstName, lastName, ID, RFID, reservations);
        em1.insertContact(ec);
        em1.addContact(ec);
        em1.addReservation(res);

    }

}