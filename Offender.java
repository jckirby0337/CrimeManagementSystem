package CrimeManagementSystem;

import java.util.ArrayList;

public class Offender extends Details{
    private boolean tattoos;
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
    private String nicknames;
    private String mentalState;
    private String housingLocations;
    private String educationLevel;
    private ArrayList<String> family;

    public Offender(String name, int age, char sex, String race, boolean tattoos, int crimeId, int offenderID, String vehicle, String licensePlate, int crimeLevels, 
                    String address, boolean bankAccount, boolean creditCard, boolean armed, boolean publicRisk,
                    String nicknames, String mentalState, String housingLocations, String educationLevel, ArrayList<String> family) {
         super(name, age, sex, race);
         this.tattoos = tattoos;
         this.crimeID = crimeId;
         this.offenderID = offenderID;
         this.vehicle = vehicle;
         this.licensePlate = licensePlate;
         this.crimeLevels = crimeLevels;
         this.address = address;
         this.bankAccount = bankAccount;
         this.creditCard = creditCard;
         this.armed = armed;
         this.publicRisk = publicRisk;
         this.nicknames = nicknames;
         this.mentalState = mentalState;
         this.housingLocations = housingLocations;
         this.educationLevel = educationLevel;
         this.family = family;
     }

    public boolean hasTattoos() {
        return this.tattoos;
    }

    public int getCrimeID() {
        return this.crimeID;
    }

    public int getOffenderID() {
        return this.offenderID;
    }


    public String getVehicle() {
        return this.vehicle;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }

    public int getCrimeLevels() {
        return this.crimeLevels;
    }

    public String getAddress() {
        return this.address;
    }

    public boolean hasBankAccount() {
        return this.bankAccount;
    }

    public boolean hasCreditCard() {
        return this.creditCard;
    }

    public boolean hasArmed() {
        return this.armed;
    }

    public boolean hasPublicRisk() {
        return this.publicRisk;
    }

    public String getNicknames() {
        return this.nicknames;
    }

    public String getMentalState() {
        return this.mentalState;
    }

    public String getHousingLocations() {
        return this.housingLocations;
    }

    public String getEducationLevel() {
        return this.educationLevel;
    }

    public ArrayList<String> getFamily() {
        return this.family;
    }
}
