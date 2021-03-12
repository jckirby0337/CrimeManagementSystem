import java.util.Scanner;
public class SampleDialogue {
    public static void main (String[] args) {
        String userStatus = "";
        String newUserUsername = "";
        String newUserPassword = "";
        String action = "";
        String test2S = "";
        String registeredUsername = "";
        String registeredPassword = "";
        System.out.println("-----Welcome To The Crime Database System------");
        System.out.println("Are You A New Or Registered User?");
        System.out.println("1. New User");
        System.out.println("2. Registered User");
        Scanner keyboard = new Scanner(System.in);
        userStatus = keyboard.nextLine();
        // Getting Whether Or Not They Are New Or Registered
        if (userStatus.equalsIgnoreCase("1.") || userStatus.equalsIgnoreCase("1")) {
            System.out.println("Welcome new user. To start create new login information.");
            System.out.println("What would you like your username to be?");
            System.out.println("Username: ");
            newUserUsername = keyboard.next();
            System.out.println("What would you like your password to be?");
            System.out.println("Password: ");
            newUserPassword = keyboard.next();
        } else if (userStatus.equalsIgnoreCase("2.") || userStatus.equalsIgnoreCase("2")) {
            System.out.println("Welcome Back!");
            System.out.println("Please Enter Your Username: ");
            registeredUsername = keyboard.next();
            System.out.println("Please Enter Your Password: ");
            registeredPassword = keyboard.next();
        }
        // If The Username And Password Are Correct Then Proceed
        if (registeredUsername.equalsIgnoreCase(newUserUsername) && registeredPassword.equalsIgnoreCase(newUserPassword) || (newUserUsername.equalsIgnoreCase(newUserUsername) && (newUserPassword.equalsIgnoreCase(newUserPassword)))) {
            System.out.println();
            System.out.println("You Have Successfully Entered The System.");
            System.out.println();
            System.out.println("*****Main Menu******");
            System.out.println("What Would You Like To Do?");
            System.out.println("----------------------");
            System.out.println("1. Add/Remove a Criminal");
            System.out.println("2. Add/Remove a Crime");
            System.out.println("3. Access a Record");
            System.out.println("4. Leave The System.");
            String choiceA = "";
            String choiceB = "";
            String choiceC = "";
            String choiceD = "";
            String choiceE = "";
            String choiceF = "";
            String choiceG = "";
            String choiceH = "";
            String choiceI = "";
            String choiceJ = "";
            String choiceK = "";
            String choiceL = "";
            String choiceM = "";
            String choiceN = "";
            int criminalID = 1;
            int crimeID = 1;
            choiceA = keyboard.next();
            // Asking The User What They Would Like To Do
                if (choiceA.equalsIgnoreCase("1.") || (choiceA.equalsIgnoreCase("1"))) {
                    System.out.println("Would You Like To Add Or Remove A Criminal?\n 1. Add A Criminal\n 2. Remove A Criminal");
                    choiceB = keyboard.next();
                    // Removing A Criminal
                    if (choiceB.equalsIgnoreCase("2.") || choiceB.equalsIgnoreCase("2")) {
                        System.out.println("What CriminalID would you like to remove?");
                        String criminalIDE = keyboard.next();
                        if (criminalIDE.equalsIgnoreCase("1.") || criminalIDE.equalsIgnoreCase("1")) {
                            System.out.println("Criminal Captain Price Has Been Removed From The System.");
                        } else {
                            System.out.println("Criminal Captain Price Has Been Removed From The System.");
                        }
                    // Adding A Criminal
                    } else if (choiceB.equalsIgnoreCase("1.") || (choiceB.equalsIgnoreCase("1"))) {
                        System.out.println("What shall be The CrimeID?");
                        int Crimeid = keyboard.nextInt();
                        System.out.println("What shall be the victimID?");
                        int Victimid = keyboard.nextInt();
                        System.out.println("Does the criminal have Tattoos?\n----------------\nEnter Y for yes, or N for no.");
                        choiceJ = keyboard.nextLine();
                        String hasTattoos = "";
                        if (choiceJ.equalsIgnoreCase("Y") || choiceJ.equalsIgnoreCase("y")) {
                            hasTattoos = "Yes";
                        } else if (choiceJ.equalsIgnoreCase("N") || choiceJ.equalsIgnoreCase("n")) {
                            hasTattoos = "No";
                        } else {
                            hasTattoos = "No";
                        }
                        System.out.println("What is the vehicle of the criminal?");
                        choiceK = keyboard.nextLine();
                        String VehicleDescription = "";
                        if(choiceK.equalsIgnoreCase("Toyota Camry") || (choiceK.equalsIgnoreCase("toyota camry"))) {
                            VehicleDescription = "Toyota Camry";
                        } else {
                            VehicleDescription = "Toyota Camry";
                        }
                        choiceL = keyboard.nextLine();
                        String licensePlate = "";
                        System.out.println("What is the license plate of the vehicle?");
                        if (choiceL.equalsIgnoreCase("abc123") || (choiceL.equalsIgnoreCase("ABC123"))) {
                            licensePlate = "ABC123";
                        } else {
                            licensePlate = "ABC123";
                        }
                        System.out.println("What level of a crime did they commit?\n Enter 1 for infraction, 2 for misdemeanor, or 3 for felony.");
                        choiceC = keyboard.nextLine();
                        String crimeLevel = "";
                        if (choiceC.equalsIgnoreCase("1.") || (choiceC.equalsIgnoreCase("1"))) {
                            crimeLevel = "Infraction";
                        } else if (choiceC.equalsIgnoreCase("2.") || (choiceC.equalsIgnoreCase("2"))) {
                            crimeLevel = "Misdemeanor";
                        } else if (choiceC.equalsIgnoreCase("3.") || (choiceC.equalsIgnoreCase("3"))) {
                            crimeLevel = "Felony";
                        }
                        System.out.println("What is the address of the criminal?");
                        String criminalAddress = keyboard.nextLine();
                        System.out.println("Does the criminal have a bank account?\n Enter Y for yes, or N for no.");
                        choiceD = keyboard.nextLine();
                        String bankAccount = "";
                        if (choiceD.equalsIgnoreCase("Y") || choiceD.equalsIgnoreCase("y")) {
                            bankAccount = "Yes";
                        } else if (choiceD.equalsIgnoreCase("N") || choiceD.equalsIgnoreCase("n")) {
                            bankAccount = "No";
                        }
                        System.out.println("Does the criminal have a credit card?\n Enter Y for yes, or N for no.");
                        choiceE = keyboard.nextLine();
                        String creditCard = "";
                        if (choiceE.equalsIgnoreCase("Y") || choiceE.equalsIgnoreCase("y")) {
                            creditCard = "Yes";
                        } else if (choiceE.equalsIgnoreCase("N") || choiceE.equalsIgnoreCase("n")) {
                            creditCard = "No";
                        }
                        System.out.println("Is the criminal armed?\n Enter Y for yes, or N for no.");
                        choiceF = keyboard.nextLine();
                        String armed = "";
                        if (choiceF.equalsIgnoreCase("Y") || choiceF.equalsIgnoreCase("y")) {
                            armed = "Yes";
                        } else if (choiceF.equalsIgnoreCase("N") || choiceF.equalsIgnoreCase("n")) {
                            armed = "No";
                        }
                        System.out.println("Is the criminal a public risk?\n Enter Y for yes, or N for no.");
                        choiceG = keyboard.nextLine();
                        String publicRisk = "";
                        if (choiceG.equalsIgnoreCase("Y") || choiceG.equalsIgnoreCase("y")) {
                            publicRisk = "Yes";
                        } else if (choiceG.equalsIgnoreCase("N") || choiceG.equalsIgnoreCase("n")) {
                            publicRisk = "No";
                        }
                        System.out.println("Does the criminal have any nicknames?\n Enter nickname or enter N/A");
                        String nicknames = "";
                        nicknames = keyboard.nextLine();
                        System.out.println("What is the criminals mental state?\n1. No Mental Illness\n2. Any Mental Illness\n3. Serious Mental Illness");
                        String mentalState = "";
                        choiceH = keyboard.nextLine();
                        if (choiceH.equalsIgnoreCase("1.") || (choiceH.equalsIgnoreCase("1"))) {
                            mentalState = "No Mental Illness";
                        } else if (choiceH.equalsIgnoreCase("2.") || (choiceH.equalsIgnoreCase("2"))) {
                            mentalState = "Any Mental Illness";
                        } else if (choiceH.equalsIgnoreCase("3.") || (choiceH.equalsIgnoreCase("3"))) {
                            mentalState = "Serious Mental Illness";
                        }
                        System.out.println("Where is the criminals house located?\n (City followed by State)");
                        String housingLocation = "";
                        housingLocation = keyboard.nextLine();
                        System.out.println("What is their education level?\n 1. Middle School\n 2. High School\n 3. College Degree\n 4. None ");
                        String educationLevel = "";
                        choiceI = keyboard.nextLine();
                        if (choiceI.equalsIgnoreCase("1.") || (choiceI.equalsIgnoreCase("1"))) {
                            educationLevel = "Middle School";
                        } else if (choiceI.equalsIgnoreCase("2.") || (choiceI.equalsIgnoreCase("2"))) {
                            educationLevel = "High School";
                        } else if (choiceI.equalsIgnoreCase("3.") || (choiceI.equalsIgnoreCase("3"))) {
                            educationLevel = "College";
                        } else if (choiceI.equalsIgnoreCase("4.") || (choiceI.equalsIgnoreCase("4"))) {
                            educationLevel = "None";
                        }
                     System.out.println("A Criminal With The Following Characteristics Has Been Added To The Database: \n -------------------------------------------------------");
                     System.out.print(" CrimeID: "+Crimeid+"\n VictimID: "+Victimid+"\n Tattoos: "+hasTattoos+"\n Vehicle: "+VehicleDescription);
                     System.out.print("\n License Plate: "+licensePlate+"\n Crime Level: "+crimeLevel+"\n Address: "+criminalAddress);
                     System.out.print("\n Bank Account: "+bankAccount+"\n Credit Card: "+creditCard+"\n Armed: "+armed);
                     System.out.print("\n Public Risk: "+publicRisk+"\n Nickname: "+nicknames+"\n Mental State: "+mentalState);
                     System.out.print("\n House Location: "+housingLocation+"\n Education Level: "+educationLevel);
                    }
            // Adding Or Removing A Crime
            } else if (choiceA.equalsIgnoreCase("2.") || (choiceA.equalsIgnoreCase("2"))) {
                System.out.println("Would You Like To Add Or Remove A Crime?\n 1. Add A Crime\n 2. Remove A Crime");
                choiceB = keyboard.next();
                // Adding A Crime
                if (choiceB.equalsIgnoreCase("1.") || choiceB.equalsIgnoreCase("1")) {
                    System.out.println("What Is The CrimeID You Would Like To Add?");
                    choiceC = keyboard.next();
                    if (choiceC.equalsIgnoreCase("2")) {
                        System.out.println("What Is Going To Be The CriminalID?");
                        choiceD = keyboard.next();
                        String CriminalID = "";
                        if (choiceD.equalsIgnoreCase("2")) {
                            CriminalID = "2";
                        } else {
                            CriminalID = "2";
                        }
                        System.out.println("What Was The Crime Committed?");
                        choiceE = keyboard.next();
                        String crimeCommitted = "";
                        if (choiceE.equalsIgnoreCase("trespassing")) {
                            crimeCommitted = "Trespassing";
                        } else {
                            crimeCommitted = "Trespassing";
                        }
                        System.out.println("What Is The Crime Location?");
                        choiceF = keyboard.next();
                        String crimeLocation = "";
                        if (choiceF.equalsIgnoreCase("LaVergne, TN")) {
                            crimeLocation = "LaVergne, TN";
                        } else {
                            crimeLocation = "LaVergne, TN";
                        }
                        System.out.println("What Is The Date Of The Crime Committed?");
                        choiceG = keyboard.next();
                        String crimeDate = "";
                        if (choiceG.equalsIgnoreCase("09/01/2015")) {
                            crimeDate = "09/01/2015";
                        } else {
                            crimeDate = "09/01/2015";
                        }
                        System.out.println("What Is The Name Of The Criminal?");
                        choiceH = keyboard.next();
                        String criminalName = "";
                        if (choiceH.equalsIgnoreCase("Luke Skywalker")) {
                            criminalName = "Luke Skywalker";
                        } else {
                            criminalName = "Luke Skywalker";
                        }
                        System.out.println("Is The Criminal In Custody?\n Enter Y for Yes, or N for No");
                        choiceI = keyboard.next();
                        String criminalCustody = "";
                        if (choiceI.equalsIgnoreCase("Y") || choiceI.equalsIgnoreCase("y")) {
                            criminalCustody = "Yes";
                        } else if (choiceI.equalsIgnoreCase("N") || choiceI.equalsIgnoreCase("n")) {
                            criminalCustody = "No";
                        } else {
                            criminalCustody = "No";
                        }
                        System.out.println("What evidence did you use to figure this out?");
                        choiceJ = keyboard.next();
                        String evidence = "";
                        if (choiceJ.equalsIgnoreCase("Witnesses")) {
                            evidence = "Witnesses";
                        } else {
                            evidence = "Witnesses";
                        }
                        System.out.println("Is The Crime Solved?\n Enter Y for yes, or N for No.");
                        choiceK = keyboard.next();
                        String crimeSolved = "";
                        if (choiceK.equalsIgnoreCase("Y") || (choiceK.equalsIgnoreCase("y"))) {
                            crimeSolved = "Yes";
                        } else if (choiceK.equalsIgnoreCase("N") || (choiceK.equalsIgnoreCase("n"))) {
                            crimeSolved = "No";
                        } else {
                            crimeSolved = "Yes";
                        }
                        System.out.println("You Have Successfully Created A New Crime With The Following Characteristics:\n ---------------------------------------------");
                        System.out.println("CrimeID: 2\n CriminalID: 2\n Crime Committed: Trespassing\n Crime Location: LaVergne, TN");
                        System.out.println("\n Crime Date: 09/01/2015\n Criminal Name: Luke Skywalker\n Criminal Custody: Yes\n Evidence: Witnesses");
                        System.out.println("Crime Solved: Yes");
                    }
                // Removing A Crime
                } else if (choiceB.equalsIgnoreCase("2.") || choiceB.equalsIgnoreCase("2")) {
                    System.out.println("Which CrimeID Would You Like To Remove?");
                    choiceC = keyboard.next();
                    if (choiceC.equalsIgnoreCase("1")) {
                        System.out.println("Crime ID Entered: "+choiceC+"\n Captain Price Has Been Removed From The Database");
                    }
                }
            // Getting A Record
            } else if (choiceA.equalsIgnoreCase("3.") || (choiceA.equalsIgnoreCase("3"))) {
                System.out.println("Which Crime ID Record Would You Like To See?");
                choiceB = keyboard.next();
                if (choiceB.equalsIgnoreCase("1.") || (choiceB.equalsIgnoreCase("1"))) {
                    System.out.println("Would You Like To Access The Whole Record Or A Specific Characteristic?\n 1. Whole Record\n 2. Specific Characteristic");
                choiceC = keyboard.next();
                // Printing The Whole Record
                    if (choiceC.equalsIgnoreCase("1.") || (choiceC.equalsIgnoreCase("1"))) {
                        System.out.print(" CrimeID: 1\n VictimID: 1 \n Tattoos: No\n Vehicle: Toyota Camry\n");
                        System.out.print("\n License Plate: ABC123\n Crime Level: Infraction\n Address: 2366 Washington St 29204");
                        System.out.print("\n Bank Account: No\n Credit Card: No\n Armed: No");
                        System.out.print("\n Public Risk: Yes\n Nickname: Pricey\n Mental State: Any Mental Illness");
                        System.out.print("\n House Location: Columbia, SC\n Education Level: High School");
                    // Asking Which Characteristic They Want To See
                    } else if (choiceC.equalsIgnoreCase("2.") || (choiceC.equalsIgnoreCase("2"))) {
                        System.out.println("What Characteristic Would You Like To See?\n 1. CrimeID\n 2. VictimID\n 3. Tattoos");
                        System.out.print(" 4. Vehicle\n 5. License Plate\n 6. Crime Level\n 7. Address\n 8. Bank Account\n");
                        System.out.print(" 9. Credit Card\n 10. Armed\n 11. Public Risk\n 12. Nickname\n 13. Mental State\n");
                        System.out.print(" 14. House Location\n 15. Education Level\n");
                        choiceD = keyboard.next();
                        if (choiceD.equalsIgnoreCase("1.") || (choiceD.equalsIgnoreCase("1"))) {
                            System.out.println("Crime ID: 1");
                        } else if (choiceD.equalsIgnoreCase("2.") || (choiceD.equalsIgnoreCase("2"))) {
                            System.out.println("Victim ID: 1");
                        } else if (choiceD.equalsIgnoreCase("3.") || (choiceD.equalsIgnoreCase("3"))) {
                            System.out.println("Tattoos: Yes");
                        } else if (choiceD.equalsIgnoreCase("4.") || (choiceD.equalsIgnoreCase("4"))) {
                            System.out.println("Vehicle: Toyota Camry");
                        } else if (choiceD.equalsIgnoreCase("5.") || (choiceD.equalsIgnoreCase("5"))) {
                            System.out.println("License Plate: ABC123");
                        } else if (choiceD.equalsIgnoreCase("6.") || (choiceD.equalsIgnoreCase("6"))) {
                            System.out.println("Crime Level: Infraction");
                        } else if (choiceD.equalsIgnoreCase("7.") || (choiceD.equalsIgnoreCase("7"))) {
                            System.out.println("Address: 2366 Washington St 29204"); 
                        } else if (choiceD.equalsIgnoreCase("8.") || (choiceD.equalsIgnoreCase("8"))) {
                            System.out.println("Bank Account: No");
                        } else if (choiceD.equalsIgnoreCase("9.") || (choiceD.equalsIgnoreCase("9"))) {
                            System.out.println("Credit Card: No");
                        } else if (choiceD.equalsIgnoreCase("10.") || (choiceD.equalsIgnoreCase("10"))) {
                            System.out.println("Armed: No");
                        } else if (choiceD.equalsIgnoreCase("11.") || (choiceD.equalsIgnoreCase("11"))) {
                            System.out.println("Public Risk: Yes");
                        } else if (choiceD.equalsIgnoreCase("12.") || (choiceD.equalsIgnoreCase("12"))) {
                            System.out.println("Nickname: Pricey");
                        } else if (choiceD.equalsIgnoreCase("13.") || (choiceD.equalsIgnoreCase("13"))) {
                            System.out.println("Mental State: Any Mental Illness");
                        } else if (choiceD.equalsIgnoreCase("14.") || (choiceD.equalsIgnoreCase("14"))) {
                            System.out.println("House Location: Columbia, SC");
                        } else if (choiceD.equalsIgnoreCase("15.") || (choiceD.equalsIgnoreCase("15"))) {
                            System.out.println("Education Level: High School");
                        // In Case They Enter Anything Wrong
                        } else {
                            System.out.print(" CrimeID: 1\n VictimID: 1 \n Tattoos: No\n Vehicle: Toyota Camry\n");
                            System.out.print("\n License Plate: ABC123\n Crime Level: Infraction\n Address: 2366 Washington St 29204");
                            System.out.print("\n Bank Account: No\n Credit Card: No\n Armed: No");
                            System.out.print("\n Public Risk: Yes\n Nickname: Pricey\n Mental State: Any Mental Illness");
                            System.out.print("\n House Location: Columbia, SC\n Education Level: High School");
                        }
                        
                }
            }  
        } else if (choiceA.equalsIgnoreCase("4.") || choiceA.equalsIgnoreCase("4")) {
            System.out.println("Thank You For Using Our System Come Back Anytime.");
            System.exit(0);
            }
        }
    }
}