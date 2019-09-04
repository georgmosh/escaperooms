package gr.aueb.softeng.project1809.services;

import gr.aueb.softeng.project1809.domain.Barcode;

/**
 * This class illustrates an interface for an RFID Scanner.
 */
public interface RFIDScannerService {
    public void scan(Barcode barcode);
}
