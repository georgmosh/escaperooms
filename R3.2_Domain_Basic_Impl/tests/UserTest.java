package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import domain.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void testgetter(){
        Credentials cu = new Credentials("steve","123");
        User u = new User("steve","123");
        User uu = new User(cu);
        Assertions.assertEquals(cu.getPassword(),u.getLoginData().getPassword());
        Assertions.assertEquals(cu.getUsername(),u.getLoginData().getUsername());



    }

}