package tests;
import domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EModifiedEscapeRoomTest {


    @Test
    public void testGetters(){
        String name="test1";
        int difficulty=2;
        int duration = 3;
        int capacity =4;
        Money configuredPrice= new Money (1.0f, Currencies.EUR ) ;
        ArrayList<String> arl = new ArrayList<String>();


        EReservation res = new EReservation(new Date(2,2,2),"info",10);

        EModifiedEscapeRoom esc = new EModifiedEscapeRoom(name,difficulty,duration,capacity,configuredPrice,arl);

        Assertions.assertEquals(configuredPrice,esc.getPrice());
        Assertions.assertEquals(arl,esc.getConfigInfo());
        Assertions.assertEquals(2,esc.getDifficulty());
        Assertions.assertEquals(3,esc.getDuration());
        Assertions.assertEquals(capacity,esc.getCapacity());
        Assertions.assertEquals(configuredPrice,esc.getPrice());
        Assertions.assertEquals("Difficulty: "+difficulty +"\nDuration :"+duration + "\nCapacity :" + capacity, esc.getEscapeRoomDescription());
        Assertions.assertEquals("Escape Room Details: \nName: "+name+"\nDifficulty: "+difficulty +"\nDuration :"+ duration + "\nCapacity :" + capacity,esc.toString());

        esc.addReservation(res);
        esc.addReservation(null);
        esc.insertReservation(res);


    }

}
/* public int getDifficulty() {
        return difficulty;
    }

    public int getDuration() {
        return duration;
    }

    public int getCapacity() {
        return capacity;
    }

    public abstract Money getPrice() ;

    public String getEscapeRoomName() {
        return name;
    }

    public Set<EReservation> getReservations() {
    	return reservations;
    }

    public String getEscapeRoomDescription() {
        return ("Difficulty: "+this.getDifficulty() +"\nDuration :"+ this.getDuration() + "\nCapacity :" + this.getCapacity() );
    }

    public String toString(){
        return ("Escape Room Details: \nName: "+this.getEscapeRoomName()+"\nDifficulty: "+this.getDifficulty() +"\nDuration :"+ this.getDuration() + "\nCapacity :" + this.getCapacity() );
    }
*/