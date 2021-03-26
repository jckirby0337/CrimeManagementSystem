import java.util.UUID;
public class Victim extends Details{
    private UUID victimID;
    private String details;

    public Victim(String name, int age, String sex, String race, String details) {
        super(name, age, sex, race);
        this.victimID = UUID.randomUUID();
        this.details = details;
    }

    public Victim(UUID victimID, String name, int age, String sex, String race, String details) {
        super(name, age, sex, race);
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

    public String print(){
        String print = "\n************ Victim *************" + super.print() + "\nDetails: " + details;
        return print;
    }
}