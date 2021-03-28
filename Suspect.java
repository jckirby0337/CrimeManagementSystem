import java.util.UUID;

/**
 * Creates the suspect object
 * @author Team Coalition
 */
public class Suspect extends Person{
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
    private String conviction;
    private boolean isInPrison;

    /**
     * consstructs suspects with the following characteristics
     * @param name of the Suspect
     * @param age of the Suspect
     * @param sex of the Suspect
     * @param race of the Suspect
     * @param phoneNumber of the Suspect
     * @param height of the Suspect
     * @param email of the Suspect
     * @param tattoos of the Suspect
     * @param vehicle of the Suspect
     * @param licensePlate of the Suspect
     * @param address of the Suspect
     * @param bankAccount of the Suspect
     * @param creditCard of the Suspect
     * @param armed if Supect has a weapon
     * @param publicRisk of the Suspect
     * @param nickNames of the Suspect
     * @param mentalState of the Suspect
     * @param housingLocation of the Suspect
     * @param educationLevel of the Suspect
     * @param hairColor of the Suspect
     * @param clothing of the Suspect
     * @param conviction of the Suspect
     * @param isInPrison if suspect is in prison
     */
    public Suspect(String name, int age, String sex, String race, String phoneNumber, String height, String email, String tattoos,
                   String vehicle, String licensePlate, String address, Boolean bankAccount,
                   Boolean creditCard, Boolean armed, Boolean publicRisk, String nickNames,
                   String mentalState, String housingLocation, String educationLevel, String hairColor, String clothing, String conviction, boolean isInPrison) {
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
        this.conviction = conviction;
        this.isInPrison = isInPrison;
    }

    /**
     * constructs suspects with the following characteristics
     * @param name of the Suspect
     * @param age of the Suspect
     * @param sex of the Suspect
     * @param race of the Suspect
     * @param phoneNumber of the Suspect
     * @param height of the Suspect
     * @param email of the Suspect
     * @param tattoos of the Suspect
     * @param vehicle of the Suspect
     * @param licensePlate of the Suspect
     * @param address of the Suspect
     * @param bankAccount of the Suspect
     * @param creditCard of the Suspect
     * @param armed if Supect has a weapon
     * @param publicRisk of the Suspect
     * @param nickNames of the Suspect
     * @param mentalState of the Suspect
     * @param housingLocation of the Suspect
     * @param educationLevel of the Suspect
     * @param hairColor of the Suspect
     * @param clothing of the Suspect
     * @param conviction of the Suspect
     * @param isInPrison if suspect is in prison
     */
    public Suspect(UUID suspectID, String name, int age, String sex, String race, String phoneNumber, String height, String email, String tattoos,
                   String vehicle, String licensePlate, String address, Boolean bankAccount,
                   Boolean creditCard, Boolean armed, Boolean publicRisk, String nickNames,
                   String mentalState, String housingLocation, String educationLevel, String hairColor, String clothing, String conviction, boolean isInPrison) {
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
        this.conviction = conviction;
        this.isInPrison = isInPrison;
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
    public void setConviction(String conviction) {
        this.conviction = conviction;
    }
    public String getConviction() {
        return this.conviction;
    }
    public void setIsInPrison(boolean isInPrison) {
        this.isInPrison = isInPrison;
    }
    public boolean getIsInPrison() {
        return isInPrison;
    }
    public String printIsInPrison() {
        if(isInPrison) {
            return "Is in prison";
        }
        return "Not in prison";
    }

    /**
    * Prints the Object Suspect
    * @return a String representation of the Suspect object
    */
    public String print() {
        String print = "\n************ Suspect *************" + super.print() + "\nTattoos: " + tattoos + "\nVehicle: " + vehicle + "\nLicense Plate: " + licensePlate
        + "\nAddress: " + address + "\nBank Account: " + bankAccount + "\nCredit Card: " + creditCard + "\nArmed: " + armed + "\nPublic Risk: " + publicRisk
        + "\nNicknames: " + nickNames + "\nMental State: " + mentalState + "\nHouseing Location: " + housingLocation + "\nEducation Level: " + educationLevel 
        + "\nHair Color: " + hairColor + "\nClothing: " + clothing + "\nConviction: " + conviction + "\n" + printIsInPrison();
        return print;
    }
}
