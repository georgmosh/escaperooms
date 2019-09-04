public class User {
    Credentials loginData;


    public User(Credentials loginData) {
        this.loginData = loginData;
    }

    public User() {
    }

    public Credentials getLoginData() {
        return loginData;
    }

    private class Credentials {
        String userName;
        String password;
    }
}
