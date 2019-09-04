package gr.aueb.softeng.project1809;
import org.junit.*;

import gr.aueb.softeng.project1809.domain.Credentials;
import gr.aueb.softeng.project1809.domain.User;

public class UserTest {

    @Test
    public void testgetter(){
        Credentials cu = new Credentials("steve","123");
        User u = new User("steve","123");
        Assert.assertEquals(cu.getPassword(),u.getLoginData().getPassword());
        Assert.assertEquals(cu.getUsername(),u.getLoginData().getUsername());



    }

}