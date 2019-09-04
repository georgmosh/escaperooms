package gr.aueb.softeng.project1809.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * This class illustrates a generic Escape Room.
 */
public abstract class EEscapeRoom implements Serializable {
	/* Domain Model: Instance variables */
    private String name;
    private int difficulty;
    private int duration;
    private int capacity;
    public static int ID;
public int CurrID;
    
    /* Domain Model - Suite: Entity's Relations */
    private Set<EReservation> reservations;

    /* Overloaded Constructor */
    public EEscapeRoom(String name, int difficulty, int duration, int capacity) {
    	this.name = name;
    	this.difficulty = difficulty;
    	this.duration = duration;
    	this.capacity = capacity;
    	this.CurrID = ID++;
    }
    /* Domain building methods */
    public boolean insertReservation(EReservation reservation) {
    	if (reservation != null) {
    		if(reservations == null)
        		reservations = new HashSet<EReservation>();
    		if (!reservations.contains(reservation)) {
    				this.reservations.add(reservation);
    				return true;
    		}
    		else 
    			System.err.println("This reservation is already registered!");
    	}
    	else 
    		System.err.println("System trying to handle null values. Insertion failed!");
    	return false;
    }
    
    public void addReservation(EReservation reservation) {
    	if(this.insertReservation(reservation))
    		reservation.setEscapeRoom(this);
    }

    /* Getters */
    public String getName() {
    	return this.name;
    }
    
    public int getDifficulty() {
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
        return ("Escape Room Details: \nName: "+this.getEscapeRoomName()+"\nDifficulty: "+this.getDifficulty() +"\nDuration :"+ this.getDuration() + " min.\nCapacity :" + this.getCapacity() );
    }

}
