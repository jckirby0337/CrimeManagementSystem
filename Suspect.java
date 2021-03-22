import java.util.UUID;
public class Suspect extends Details{
    private UUID suspectID;
    private Boolean tattoos;
    private String vehicle;
    private String licensePlate;
    private String address;
    private boolean bankAccount;
    private boolean creditCard;
    private boolean armed;
    private boolean publicRisk;
    private String nickNames;
    private String mentalState;
    private String housingLocation;
    private String educationLevel;
    public Suspect(String name, int age, String sex, String race, Boolean tattoos,
                   String vehicle, String licensePlate, String address, Boolean bankAccount,
                   Boolean creditCard, Boolean armed, Boolean publicRisk, String nickNames,
                   String mentalState, String housingLocation, String educationLevel) {
        super(name, age, sex, race);
        this.suspectID = UUID.randomUUID();
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
    public Suspect(UUID suspectID, String name, int age, String sex, String race, Boolean tattoos,
                   String vehicle, String licensePlate, String address, Boolean bankAccount,
                   Boolean creditCard, Boolean armed, Boolean publicRisk, String nickNames,
                   String mentalState, String housingLocation, String educationLevel) {
        super(name, age, sex, race);
        this.suspectID = suspectID;
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
    public void setSuspectID(UUID suspectID) {
        this.suspectID = suspectID;
    }
    public UUID getSuspectID() {
        return suspectID;
    }
    public boolean hasTattoos() {
        return tattoos;
    }
    public String getVehicle() {
        return vehicle;
    }
    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
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
    public void setNicknames(String nicknames) {
        this.nickNames = nicknames;
    }
    public String getMentalState() {
        return mentalState;
    }
    public void setMentalState(String mentalstate) {
        this.mentalState = mentalstate;
    }
    public String getHousingLocation() {
        return housingLocation;
    }
    public void setHousingLocation(String housinglocation) {
        this.housingLocation = housinglocation;
    }
    public String getEducationLevel() {
        return educationLevel;
    }
    public void setEducationLevel(String educationlevel) {
        this.educationLevel = educationlevel;
    }
}
