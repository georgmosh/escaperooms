package gr.aueb.softeng.project1809;
import org.junit.*;

import gr.aueb.softeng.project1809.domain.Credentials;


public class CredentialsTest {
    @Test
    public void gettersTest(){
        String userName="test1";
        String password="test2";
        Credentials cr = new Credentials(userName,password);
        Assert.assertEquals("test1",cr.getUsername());
        Assert.assertEquals("test2",cr.getPassword());
    }




}