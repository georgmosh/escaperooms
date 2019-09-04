package gr.aueb.softeng.project1809;

import org.junit.*;

import gr.aueb.softeng.project1809.domain.Currencies;
import gr.aueb.softeng.project1809.domain.EStandardEscapeRoom;
import gr.aueb.softeng.project1809.domain.Money;


public class EStandardEscapeRoomTest {

    @Test
    void getPrice() {
        String name ="test1";
        int difficulty = 10;
        int duration =30;
        int capacity=500;
        Money price = new Money(20.0f, Currencies.EUR);

        EStandardEscapeRoom esc = new EStandardEscapeRoom(name,difficulty,duration,capacity,price);

        Assert.assertEquals(name,esc.getName());
        Assert.assertEquals(difficulty,esc.getDifficulty());
        Assert.assertEquals(duration,esc.getDuration());
        Assert.assertEquals(capacity,esc.getCapacity());
        Assert.assertEquals(price,esc.getPrice());
    }
}