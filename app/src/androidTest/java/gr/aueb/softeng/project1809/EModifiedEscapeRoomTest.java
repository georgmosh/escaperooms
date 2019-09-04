package gr.aueb.softeng.project1809;
import junit.framework.Assert;

import org.junit.*;

import java.util.ArrayList;
import java.util.Date;

import gr.aueb.softeng.project1809.domain.Currencies;
import gr.aueb.softeng.project1809.domain.EModifiedEscapeRoom;
import gr.aueb.softeng.project1809.domain.EReservation;
import gr.aueb.softeng.project1809.domain.Money;


public class EModifiedEscapeRoomTest {


    @Test
    public void testGetters(){
        String name="test1";
        int difficulty=2;
        int duration = 3;
        int capacity =4;
        Money configuredPrice= new Money(1.0f, Currencies.EUR ) ;
        ArrayList<String> arl = new ArrayList<String>();


        EReservation res = new EReservation(new Date(2,2,2),"info",10);

        EModifiedEscapeRoom esc = new EModifiedEscapeRoom(name,difficulty,duration,capacity,configuredPrice,arl);

        Assert.assertEquals(name,esc.getName());
        Assert.assertEquals(configuredPrice,esc.getPrice());
        Assert.assertEquals(arl,esc.getConfigInfo());
        Assert.assertEquals(2,esc.getDifficulty());
        Assert.assertEquals(3,esc.getDuration());
        Assert.assertEquals(capacity,esc.getCapacity());
        Assert.assertEquals(configuredPrice,esc.getPrice());
        Assert.assertEquals("Difficulty: "+difficulty +"\nDuration :"+duration + "\nCapacity :" + capacity, esc.getEscapeRoomDescription());
        Assert.assertEquals("Escape Room Details: \nName: "+name+"\nDifficulty: "+difficulty +"\nDuration :"+ duration + " min.\nCapacity :" + capacity,esc.toString());

        esc.addReservation(res);
        esc.addReservation(null);
        esc.addReservation(res);

    }

}