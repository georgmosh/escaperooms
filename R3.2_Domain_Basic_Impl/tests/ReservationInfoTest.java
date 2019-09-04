package tests;

import domain.ReservationInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationInfoTest {

    @Test
    public void testGetters(){
        String[] names = new String[2];
        names[0]="steve";
        names[1]="george";
        ReservationInfo ri = new ReservationInfo(names);
        Assertions.assertEquals(names,ri.getNames());

    }

}