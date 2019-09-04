package gr.aueb.softeng.project1809.ui;

import gr.aueb.softeng.project1809.dao.RFID_Manager;

/**
 * This class illustrates a multiple data base objects container; such as a database library.
 */
public class DAO_UI_Adapter {

    private static gr.aueb.softeng.project1809.dao.CustomersStubDAO CUST;
    private static gr.aueb.softeng.project1809.dao.EmployeesStubDAO EMPL;
    private static gr.aueb.softeng.project1809.dao.ReservationsStubDAO RES;
    private static gr.aueb.softeng.project1809.dao.EscapeRoomStubDAO ESC;
    private static gr.aueb.softeng.project1809.dao.PaymentsStubDAO PAY;
    private static gr.aueb.softeng.project1809.dao.RFID_Manager RFID;

    public static void initialize() {
        gr.aueb.softeng.project1809.dao.EscapeRoomStubDAO dao = new gr.aueb.softeng.project1809.dao.EscapeRoomStubDAO();
        dao.initialize();
        ESC = dao;
        gr.aueb.softeng.project1809.dao.CustomersStubDAO dao1 = new gr.aueb.softeng.project1809.dao.CustomersStubDAO();
        dao1.initialize();
        CUST = dao1;
        gr.aueb.softeng.project1809.dao.EmployeesStubDAO dao2 = new gr.aueb.softeng.project1809.dao.EmployeesStubDAO();
        dao2.initialize();
        EMPL = dao2;
        gr.aueb.softeng.project1809.dao.ReservationsStubDAO dao3 = new gr.aueb.softeng.project1809.dao.ReservationsStubDAO();
        dao3.initialize();
        RES = dao3;
        gr.aueb.softeng.project1809.dao.PaymentsStubDAO dao4 = new gr.aueb.softeng.project1809.dao.PaymentsStubDAO();
        dao4.initialize();
        PAY = dao4;
        gr.aueb.softeng.project1809.dao.RFID_Manager rfid_manager = new RFID_Manager();
        RFID = rfid_manager;
    }

    public static gr.aueb.softeng.project1809.dao.CustomersStubDAO getCUST() {
        return CUST;
    }

    public static gr.aueb.softeng.project1809.dao.EmployeesStubDAO getEMPL() {
        return EMPL;
    }

    public static gr.aueb.softeng.project1809.dao.ReservationsStubDAO getRES() {
        return RES;
    }

    public static gr.aueb.softeng.project1809.dao.EscapeRoomStubDAO getESC() {
        return ESC;
    }

    public static gr.aueb.softeng.project1809.dao.PaymentsStubDAO getPAY() { return PAY; }

    public static gr.aueb.softeng.project1809.dao.RFID_Manager getRFID() { return RFID;}
}
