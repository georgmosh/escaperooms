public class EscapeRoom {
    private String name;
    private int difficulty;
    private int duration;
    private int capacity;

    public int getDifficulty() {
        return difficulty;
    }

    public int getDuration() {
        return duration;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    public String getEscapeRoomDescription() {
        return ("Difficulty: "+this.getDifficulty() +"\nDuration :"+ this.getDuration() + "\nCapacity :" + this.getCapacity() );
    }

    public String toString(){
        return ("Name: "+this.getName()+"\nDifficulty: "+this.getDifficulty() +"\nDuration :"+ this.getDuration() + "\nCapacity :" + this.getCapacity() );
    }

}
