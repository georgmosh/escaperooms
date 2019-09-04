package gr.aueb.softeng.project1809;
import gr.aueb.softeng.project1809.domain.Barcode;
import org.junit.*;


public class BarcodeTest {
    @Test
    public void getterTest(){
        Barcode bc = new Barcode("data1x","epc1");
        Assert.assertEquals("data1x",bc.getTransponderData());
        Assert.assertEquals("epc1",bc.getEPC());
    }
}