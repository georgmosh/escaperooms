package gr.aueb.softeng.project1809;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import gr.aueb.softeng.project1809.domain.Currencies;
import gr.aueb.softeng.project1809.domain.EPayment;
import gr.aueb.softeng.project1809.domain.EReservation;
import gr.aueb.softeng.project1809.domain.MeansOfPayment;
import gr.aueb.softeng.project1809.domain.Money;
import gr.aueb.softeng.project1809.domain.PaymentReceipt;
import gr.aueb.softeng.project1809.domain.User;
import gr.aueb.softeng.project1809.services.ECustomConnection;
import gr.aueb.softeng.project1809.ui.DAO_UI_Adapter;


public class MakeSampleConnection {
    @Before
    public void setup() {
        DAO_UI_Adapter.initialize();
    }

    @Test
    public void tests(){

User u = DAO_UI_Adapter.getCUST().getDAO().findAll().get(0);
        ECustomConnection c = new ECustomConnection(u);
        Assert.assertNotNull(u);
        Assert.assertNotNull(c);
        Assert.assertNotNull(c.getConnectionData());
        Assert.assertEquals("user1", c.getConnectionData().getUsername());
        Assert.assertEquals("1234", c.getConnectionData().getPassword());
        Assert.assertTrue(c.getConnectionResult());
        ECustomConnection c1 = new ECustomConnection();
        c1 =c1.submit("user1", "1234", DAO_UI_Adapter.getCUST().getDAO());
        Assert.assertNotNull(c1);
        Assert.assertNotNull(c1.getConnectionData());
        Assert.assertTrue(c1.getConnectionResult());
        ECustomConnection c2 = new ECustomConnection();
        c2 =c1.submit("user1", "eisvoleas", DAO_UI_Adapter.getCUST().getDAO());
        Assert.assertFalse(c2.getConnectionResult());
    }




}
