package gr.aueb.softeng.project1809;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.*;

import gr.aueb.softeng.project1809.domain.Barcode;
import gr.aueb.softeng.project1809.domain.ECustomer;
import gr.aueb.softeng.project1809.domain.EEmployee;
import gr.aueb.softeng.project1809.domain.EReservation;

public class EEmployeeTest {

    @Test
    public void testall(){
        String username = "user1";
        String password = "password1";
        String firstName = "first1";
        String lastName = "last1";
        String AMKA = "AMKA1";
        String ID = "ID1";
        Barcode RFID = new Barcode("data1","epc1");;
        List<EReservation> reservations =new ArrayList<EReservation>();

        EEmployee em1 = new EEmployee(username,password,firstName,lastName,AMKA);

        Assert.assertEquals("first1",em1.getFirstName());
        Assert.assertEquals("last1",em1.getLastName());
        Assert.assertEquals("AMKA1", em1.getAMKA());


        EReservation res = new EReservation(new Date(2,2,2),"info",10);
        em1.insertReservation(res);
        ECustomer ec = new ECustomer(username, password, firstName, lastName, ID, RFID, reservations);
        em1.insertContact(ec);
        em1.addContact(ec);
        em1.addReservation(res);

    }

}