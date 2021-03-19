public class Victim extends Details{
    private String details;

    public Victim(String name, int age, char sex, String race, String details) {
        super(name, age, sex, race);
        this.details = details;
    }
    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


}
