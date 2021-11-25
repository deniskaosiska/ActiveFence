import States.*;

import java.util.Scanner;


public class Main {
    public static String Key1 = "Den12345";
    public static String Key2 = "Sharon12";
    public static String Key3 = "AF123456";
    public static String inputKey1 = null;
    public static String inputKey2 = null;
    public static VaultState vaultState;
    static int length1;
    static int length2;
    public static int i;


    public static void enterKey() {

        //Loop for entering keys
        for (i = 0; i < 5; i++) {
            //Input for first key
            System.out.println("Please enter the first key");
            Scanner scanner1 = new Scanner(System.in);
            inputKey1 = scanner1.next();
            length1 = inputKey1.length();
            UnitTests.verifyLengthFirstKey();
            i++;
            //Validation if key match to existing keys, if yes user should enter the second key and status is Unlock
            if (inputKey1.equalsIgnoreCase(Key1) || inputKey1.equalsIgnoreCase(Key2) || inputKey1.equalsIgnoreCase(Key3)) {
                System.out.println("Great, please enter the second key");
                System.out.print("The vault state is: ");
                getState();
                UnitTests.verifyUnlockState();
                Scanner scanner2 = new Scanner(System.in);
                inputKey2 = scanner2.next();
                length2 = inputKey2.length();
                UnitTests.verifyLengthSecondKey();
                i++;
                //Validation if the second entered key is not the same first key, if yes status is Closed
                if (inputKey2.equalsIgnoreCase(inputKey1)) {
                    System.out.println("You entered the same key, please entered another one");
                    System.out.print("The vault state is: ");
                    getState();
                    UnitTests.verifyCloseState();
                }
                //Validation if the second entered key is matching to existing keys, if yes vault is Open
                else if (inputKey2.equalsIgnoreCase(Key1) || inputKey2.equalsIgnoreCase(Key2) || inputKey2.equalsIgnoreCase(Key3)) {
                    System.out.println("Great!");
                    System.out.print("The vault state is: ");
                    getState();
                    UnitTests.verifyOpenState();
                    i = 7;
                }
                //If user entered the second wrong key, but first was ok, he should start over and status is Close
                else {
                    System.out.println("You entered the wrong key, please start over");
                    i--;
                    System.out.print("The vault state is: ");
                    getState();
                    UnitTests.verifyCloseState();
                    inputKey2 = null;
                }
                //If user entered the first wrong key
            } else {
                System.out.println("You entered the wrong key");
                System.out.print("The vault state is: ");
               getState();
                if(i==5){
                    UnitTests.verifySealedState();
                }else {
                    UnitTests.verifyCloseState();
                }
                i--;
            }

        }
        //When user tried to enter 5 times the system is Sealed and waiting for Superman
        if (i == 5) {
            System.out.println("You enter 5 times the wrong key, now only superman can open the vault");
        }

    }

    //Function to defined the status of vault
    public static void getState() {
        //If user entered first matched key, so status is Unlock in process
        if ((inputKey1.equals(Key1) || inputKey1.equals(Key2) || inputKey1.equals(Key3)) && (inputKey2 == null)) {
            vaultState = new UnlockState();

            //If user entered 2 matched keys, so status is opened
        } else if ((inputKey1.equals(Key1) || inputKey1.equals(Key2) || inputKey1.equals(Key3)) && (inputKey2.equals(Key1) || inputKey2.equals(Key2) || inputKey2.equals(Key3)) && (!inputKey2.equals(inputKey1))) {
            vaultState = new OpenState();

            //If user tried 5 times, so status is Sealed
        } else if (i == 5) {
            vaultState = new SealedState();
        }
        //In any other situation the status is Close
        else {
            vaultState = new ClosedState();
        }
    }

    //Running the program
    public static void main(String[] args) {
        enterKey();
    }

}


