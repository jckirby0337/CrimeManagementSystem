import java.util.UUID;
/**
 * Creates the Witness Object which is a person and thus has its properties 
 * @author Team Coalition
 */
public class Witness extends Person {
    private UUID witnessID;
    private String details;
    private String story;
    private boolean isDefending;
    
    /**
     * Creates a Witness object with the following characteristics (parameters):
     * @param name of the witness
     * @param age of the witness
     * @param sex of the witness
     * @param race of the witness
     * @param phoneNumber of the witness
     * @param height of the witness
     * @param email of the witness  
     * @param details of the witness
     * @param story of the witness
     * @param isDefending behavior of the witness
     */
    public Witness(String name, int age, String sex, String race, String phoneNumber, String height, String email, String details, String story, boolean isDefending) {
        super(name, age, sex, race, phoneNumber, height, email);
        this.witnessID = UUID.randomUUID();
        this.details = details;
        this.story = story;
        this.isDefending = isDefending;
    }
    /**
     * Creates a Witness object with the following characteristics (parameters):
     * @param witnessID of the witness
     * @param name of the witness
     * @param age of the witness
     * @param sex of the witness
     * @param race of the witness
     * @param phoneNumber of the witness
     * @param height of the witness
     * @param email of the witness  
     * @param details of the witness
     * @param story of the witness
     * @param isDefending behavior of the witness
     */
    public Witness(UUID witnessID, String name, int age, String sex, String race, String phoneNumber, String height, String email, String details, String story, boolean isDefending) {
        super(name, age, sex, race, phoneNumber, height, email);
        this.witnessID = witnessID;
        this.details = details;
        this.story = story;
        this.isDefending = isDefending;
    }
    public UUID getWitnessID() {
        return witnessID;
    }

    public void setWitnessID(UUID witnessID) {
        this.witnessID = witnessID;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    public String getStory() {
        return story;
    }
    public void setStory(String story) {
        this.story = story;
    }
    public boolean getIsDefening() {
        return isDefending;
    }
    public void setIsDefending(boolean isDefending) {
        this.isDefending = isDefending;
    }
    /**
    * Prints the Object Witness
    * @return a String representation of the Witness object
    */
    public String print() {
        String print = "\n************ Victim *************" + super.print() + "\nDetails: " + details + "\nStory: " + story + "\nDefending: " + isDefending;
        return print;
    }
}
