import java.util.UUID;
public class Witness extends Details {
    private UUID witnessID;
    private String details;
    private String story;
    private boolean isDefending;

    public Witness(String name, int age, String sex, String race, String details, String story, boolean isDefending) {
        super(name, age, sex, race);
        this.witnessID = UUID.randomUUID();
        this.details = details;
        this.story = story;
        this.isDefending = isDefending;
    }
    public Witness(UUID witnessID, String name, int age, String sex, String race, String details, String story, boolean isDefending) {
        super(name, age, sex, race);
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

    public String print() {
        String print = "\n************ Victim *************" + super.print() + "\nDetails: " + details + "\nStory: " + story + "\nDefending: " + isDefending;
        return print;
    }
}
