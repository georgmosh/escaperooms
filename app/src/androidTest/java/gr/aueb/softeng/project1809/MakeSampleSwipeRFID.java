package gr.aueb.softeng.project1809;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1809.dao.CustomersStubDAO;
import gr.aueb.softeng.project1809.domain.Barcode;
import gr.aueb.softeng.project1809.services.ECustomScan;
import gr.aueb.softeng.project1809.services.RFIDScannerService;
import gr.aueb.softeng.project1809.services.RFIDStubScannerService;
import gr.aueb.softeng.project1809.ui.DAO_UI_Adapter;


public class MakeSampleSwipeRFID {
    @Before
    public void setup() {
        DAO_UI_Adapter.initialize();
    }
    @Test
    public void getterTest(){
        ECustomScan scan = new ECustomScan();
        Barcode b = new Barcode("TRANSPONDER", "EPC");
        CustomersStubDAO dao = new CustomersStubDAO();
        dao.initialize();
        scan = scan.submit(b.getTransponderData(), b.getEPC(), dao.getDAO(), new RFIDStubScannerService());
        Assert.assertNotNull(scan);
        scan.enableChipScan(new RFIDStubScannerService());
        scan.validate(50);
    }
}