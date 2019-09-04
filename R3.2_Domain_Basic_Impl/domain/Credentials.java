package domain;
    public class Credentials {
    	/* Domain Model: Instance variables */
        String userName;
        String password;
        
        /* Overloaded Constructor */
        public Credentials(String userName, String password) {
        	this.userName = userName;
        	this.password = password;
        }
        
        /* Getters */
        public String getUsername() {
        	return userName;
        }
        
        public String getPassword() {
        	return password;
        }
    }