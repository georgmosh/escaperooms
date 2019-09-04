package tests;
import domain.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BarcodeTest {
    @Test
    public void getterTest(){
        Barcode bc = new Barcode("data1x","epc1");
        Assertions.assertEquals("data1x",bc.getTransponderData());
        Assertions.assertEquals("epc1",bc.getEPC());
    }
}