public class Secretariat extends User{
    private String firstName;
    private String lastName;
    private String AMKA;

    public Secretariat(String firstName, String lastName, String AMKA) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.AMKA = AMKA;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAMKA() {
        return AMKA;
    }
}
