package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import domain.*;

import static org.junit.jupiter.api.Assertions.*;

class EStandardEscapeRoomTest {

    @Test
    void getPrice() {
        String name ="test1";
        int difficulty = 10;
        int duration =30;
        int capacity=500;
        Money price = new Money(20.0f,Currencies.EUR);

        EStandardEscapeRoom esc = new EStandardEscapeRoom(name,difficulty,duration,capacity,price);

        Assertions.assertEquals(price,esc.getPrice());
    }
}