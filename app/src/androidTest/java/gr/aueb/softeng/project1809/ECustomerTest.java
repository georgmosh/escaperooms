package gr.aueb.softeng.project1809;
import org.junit.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gr.aueb.softeng.project1809.domain.Barcode;
import gr.aueb.softeng.project1809.domain.ECustomer;
import gr.aueb.softeng.project1809.domain.EEmployee;
import gr.aueb.softeng.project1809.domain.EReservation;


public class ECustomerTest {
ECustomer ec;
Barcode RFID;
    List<EReservation> reservations ;

    @Before
    void setUp() {




        String username = "username1";
        String password = "password1";
        String firstName = "first1";
        String lastName = "last1";
        String ID = "id1";
        RFID = new Barcode("data1","epc1");
        reservations = new ArrayList<EReservation>();
        ec = new ECustomer(username, password, firstName, lastName, ID, RFID, reservations);



    }


    @Test
    void insertReservation() {
        ECustomer ec2 = new ECustomer("username1", "password1", "first1", "last1", "id1", RFID, null);
        EReservation res = new EReservation(new Date(2,2,2),"info",10);
        ec2.insertReservation(null);
        ec2.insertReservation(res);
        ec2.insertReservation(res);

    }

    @Test
    void addReservation() {
        ec.addReservation(new EReservation(new Date(1821,5,15),"test1",12));
    }

    @Test
    void getFirstName() {
        Assert.assertEquals("first1",ec.getFirstName());
    }

    @Test
    void getLastName() {
        Assert.assertEquals("last1",ec.getLastName());
    }

    @Test
    void getID() {
        Assert.assertEquals("id1",ec.getID());
    }

    @Test
    void getRFID() {
        Assert.assertEquals(RFID,ec.getRFID());
    }

    @Test
    void getReservations() {
        Assert.assertEquals(reservations,ec.getReservations());
    }

    @Test
    void getsetEmployee() {
        EEmployee e1 = new EEmployee("a1","b1","c1","d1","e1");
        ec.setEmployee(e1);
        Assert.assertEquals(e1,ec.getEmployee());
    }

    @Test
    void printTest() {

        Assert.assertEquals("Customer details: \n" + "first1" + " " +  "last1" + "\nID: " + "id1" + "\n RFID:" + RFID,ec.toString());
    }
}