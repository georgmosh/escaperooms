package gr.aueb.softeng.project1809;
import org.junit.*;

import gr.aueb.softeng.project1809.domain.Currencies;
import gr.aueb.softeng.project1809.domain.Money;

public class MoneyTest {

    @Test
    public void testGetters(){
        Money mn = new Money(13.0f, Currencies.EUR);

        Assert.assertEquals(13.0f,mn.getValue(),0.1);
        Assert.assertEquals(Currencies.EUR,mn.getCurrency());

        Assert.assertNotNull(mn.toString());
    }

}