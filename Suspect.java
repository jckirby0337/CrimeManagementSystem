import java.util.ArrayList;
public class Suspect extends Details{
    private Boolean tattoos;
    private int crimeID;
    private int offenderID;
    private String vehicle;
    private String licensePlate;
    private int crimeLevels;
    private String address;
    private boolean bankAccount;
    private boolean creditCard;
    private boolean armed;
    private boolean publicRisk;
    private String nickNames;
    private String mentalState;
    private String housingLocation;
    private String educationLevel;
    public POI(String name, int age, char sex, String race) {
        
    }
    public Suspect(String name, int age, char sex, String race, Boolean tattoos,
                   String vehicle, String licensePlate, String address, Boolean bankAccount,
                   Boolean creditCard, Boolean armed, Boolean publicRisk, String nickNames,
                   String mentalState, String housingLocation, String educationLevel) {
        this.name = Details.getName();
        this.age = Details.getAge();
        this.sex = Details.getSex();
        this.race = Details.getRace();
        this.tattoos = tattoos;
        this.vehicle = vehicle;
        this.licensePlate = licensePlate;
        this.address = address;
        this.bankAccount = bankAccount;
        this.creditCard = creditCard;
        this.armed = armed;
        this.publicRisk = publicRisk;
        this.nickNames = nickNames;
        this.mentalState = mentalState;
        this.housingLocation = housingLocation;
        this.educationLevel = educationLevel;
    }
    public boolean hasTattoos() {
        return tattoos;
    }
    public String getVehicle() {
        return vehicle;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public String getCrimeLevel() {
        return address;
    }
    public String getAddress() {
        return address;
    }
    public boolean hasBankAccount() {
       return bankAccount; 
    }
    public boolean hasCreditCard() {
        return creditCard;
    }
    public boolean isArmed() {
        return armed;
    }
    public boolean publicRisk() {
        return publicRisk;
    }
    public String getNicknames() {
        return nickNames;
    }
    public String getMentalState() {
        return mentalState;
    }
    public String getHousingLocation() {
        return housingLocation;
    }
    public String getEducationLevel() {
        return educationLevel;
    }
}
