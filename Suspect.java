import java.util.UUID;
public class Suspect extends Details{
    private UUID suspectID;
    private String tattoos;
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
    private String hairColor;
    private String clothing;
    public Suspect(String name, int age, String sex, String race, String phoneNumber, String height, String email, String tattoos,
                   String vehicle, String licensePlate, String address, Boolean bankAccount,
                   Boolean creditCard, Boolean armed, Boolean publicRisk, String nickNames,
                   String mentalState, String housingLocation, String educationLevel, String hairColor, String clothing) {
        super(name, age, sex, race, phoneNumber, height, email);
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
        this.hairColor = hairColor;
        this.clothing = clothing;
    }
    public Suspect(UUID suspectID, String name, int age, String sex, String race, String phoneNumber, String height, String email, String tattoos,
                   String vehicle, String licensePlate, String address, Boolean bankAccount,
                   Boolean creditCard, Boolean armed, Boolean publicRisk, String nickNames,
                   String mentalState, String housingLocation, String educationLevel, String hairColor, String clothing) {
        super(name, age, sex, race, phoneNumber, height, email);
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
        this.hairColor = hairColor;
        this.clothing = clothing;
    }
    public void setSuspectID(UUID suspectID) {
        this.suspectID = suspectID;
    }
    public UUID getSuspectID() {
        return suspectID;
    }
    public String getTattoos() {
        return this.tattoos;
    }
    public void setTattoos(String tattoos) {
        this.tattoos = tattoos;
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
    public String getHairColor() {
        return hairColor;
    }
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }
    public String getClothing() {
        return clothing;
    }
    public void setClothing(String clothing) {
        this.clothing = clothing;
    }
    public String print() {
        String print = "\n************ Suspect *************" + super.print() + "\nTattoos: " + tattoos + "\nVehicle: " + vehicle + "\nLicense Plate: " + licensePlate
        + "\nAddress: " + address + "\nBank Account: " + bankAccount + "\nCredit Card: " + creditCard + "\nArmed: " + armed + "\nPublic Risk: " + publicRisk
        + "\nNicknames: " + nickNames + "\nMental State: " + mentalState + "\nHouseing Location: " + housingLocation + "\nEducation Level: " + educationLevel 
        + "\nHair Color: " + hairColor + "\nClothing: " + clothing;
        return print;
    }
}
