package tests;
import domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    public void testGetters(){
        Money mn = new Money(13.0f, Currencies.EUR);

        Assertions.assertEquals(13.0f,mn.getValue());
        Assertions.assertEquals(Currencies.EUR,mn.getCurrency());

    }

}