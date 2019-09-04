public class Customer extends User{
    private String firstName;
    private String lastName;
    private String password;
    private Barcode RFID;

    public Customer(String firstName, String lastName, String password, Barcode RFID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.RFID = RFID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public Barcode getRFID() {
        return RFID;
    }

    private class Barcode {
        private String TransponderData;
        private String EPC;
    }
}
