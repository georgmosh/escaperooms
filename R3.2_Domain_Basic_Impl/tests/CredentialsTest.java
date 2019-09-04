package tests;

import domain.Credentials;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CredentialsTest {
    @Test
    public void gettersTest(){
        String userName="test1";
        String password="test2";
        Credentials cr = new Credentials(userName,password);
        Assertions.assertEquals("test1",cr.getUsername());
        Assertions.assertEquals("test2",cr.getPassword());
    }




}