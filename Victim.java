import java.util.UUID;
/**
 * Creates the Victim Object
 * @author Team Coalition
 */
public class Victim extends Person{
    private UUID victimID;
    private String details;
    
    /**
     * Constructs a Victim with the following characteristics: 
     * @param name of the victim
     * @param age of the victim
     * @param sex of the victim
     * @param race of the victim
     * @param phoneNumber of the victim
     * @param height of the victim
     * @param email of the victim
     * @param details of the victim
     */
    public Victim(String name, int age, String sex, String race, String phoneNumber, String height, String email, String details) {
        super(name, age, sex, race, phoneNumber, height, email);
        this.victimID = UUID.randomUUID();
        this.details = details;
    }

    /**
     * Constructs a Victim with the following characteristics: 
     * @param victimID of the victim
     * @param name of the victim
     * @param age of the victim
     * @param sex of the victim
     * @param race of the victim
     * @param phoneNumber of the victim
     * @param height of the victim
     * @param email of the victim
     * @param details of the victim
     */
    public Victim(UUID victimID, String name, int age, String sex, String race, String phoneNumber, String height, String email, String details) {
        super(name, age, sex, race, phoneNumber, height, email);
        this.victimID = victimID;
        this.details = details;
    }

    public UUID getVictimID() {
        return victimID;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    /**
     * Prints the Object Victim
     * @return Returns a String representation of the Victim and its characteristics
     */
    public String print(){
        String print = "\n************ Victim *************" + super.print() + "\nDetails: " + details;
        return print;
    }
}