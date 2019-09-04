package gr.aueb.softeng.project1809.services;

/**
 * This class implements Billing fan-out.
 */
public class ECustomBilling {

    gr.aueb.softeng.project1809.domain.EReservation reservation;
    gr.aueb.softeng.project1809.domain.EPayment payment;
    String report;

    public ECustomBilling() {}

    public ECustomBilling(gr.aueb.softeng.project1809.domain.EReservation r, gr.aueb.softeng.project1809.domain.EPayment p) {
        this.reservation = r;
        this.payment = p;
    }

    public ECustomBilling submit(gr.aueb.softeng.project1809.domain.EReservation r, gr.aueb.softeng.project1809.domain.EPayment p) {
        ECustomBilling b = new ECustomBilling(r, p);
        b = b.setReport();
        return b;
    }

    private ECustomBilling setReport() {
        report = ("Reservation: " + new ECustomReservationItem(reservation, reservation.getCustomer(), reservation.getEscapeRoom()).getReservationInformation());
        report += "\nbeing paid as: No. " + payment;
        return this;
    }

    public String getReport() {
        return this.report;
    }
}
