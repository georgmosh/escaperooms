package gr.aueb.softeng.project1809;
import org.junit.*;

import gr.aueb.softeng.project1809.domain.ReservationInfo;

public class ReservationInfoTest {

    @Test
    public void testGetters(){
        String[] names = new String[2];
        names[0]="steve";
        names[1]="george";
        ReservationInfo ri = new ReservationInfo(names);
        Assert.assertEquals(names,ri.getNames());

    }

}