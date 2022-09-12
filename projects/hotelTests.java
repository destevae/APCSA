import java.util.*;
public class hotelTests {
    Scanner input_scanner;
    hotelTests(){
        input_scanner = new Scanner(System.in);
        runTest();
    }
// Helper Methods // -------------------------------------------------//
    void printGuestNames(HotelRoom room){
        System.out.println("\n--- Guests Currently In HotelRoom " + room.roomNumber +" :");
        if(room.guestOne != null){
            System.out.println("    guestOne is " + room.guestOne.name);
        }
        if(room.guestTwo != null){
            System.out.println("    guestTwo is " + room.guestTwo.name);
        }
        if(room.guestOne==null && room.guestTwo==null){
            System.out.println("    Empty");
        }
        System.out.println("\n");
    }

    // tests to see if person is checked into a hotel room
    boolean checkedInRoom(HotelRoom room, Person guest){
        if(room.guestOne!=guest && room.guestTwo!=guest){
            System.out.println(guest.name + " is not checked in.");
            printGuestNames(room);
            return false;
        }
        System.out.println(guest.name + " is in room " + room.roomNumber);
        return true;
    }

    // Checks if a Person's constructor correctly assigned their attributes
    boolean properAttributes(Person guest, double h, int a, String n, String hC){
        boolean passed = true;
        System.out.println("\nVerifying " + guest + " Constructor");

        // verifying height attribute
        if(guest.height == h){
            System.out.println("        " + guest + " height: correct value, " + h);
        }
        else{
            System.out.println("        " + guest + " height: incorrect value, should be " + h);
            passed = false;
        }

        // verifying age attribute
        if(guest.age == a){
            System.out.println("        " + guest + " age: correct value, " + a);
        }
        else{
            System.out.println("        " + guest + " age: incorrect value, should be " + a);
            passed = false;
        }

        // verifying name attribute
        if(guest.name.equals(n)){
            System.out.println("        " + guest + " name: correct value, " + n);
        }
        else{
            System.out.println("        " + guest + " name: incorrect value, should be " + n);
            passed = false;
        }

        // verifying hairColor attribute
        if(guest.hairColor.equals(hC)){
            System.out.println("        " + guest + " hairColor: correct value, " + hC);
        }
        else{
            System.out.println("        " + guest + " hairColor: incorrect value, should be " + hC);
            passed = false;
        }

        if(passed){
            System.out.println("    " + guest + " has passed constructor verification.");
        }
        else{
            System.out.println("    " + guest + " has failed constructor verification. See above for details.");
        }
        return passed;
    }
    // Checks if a HotelRoom's constructor correctly assigned its attributes
    boolean properAttributes(HotelRoom room, int rN){
        System.out.println("\nVerifying " + room + " Constructor");

        if(room.roomNumber == rN){
            System.out.println("        Room " + room.roomNumber + " has been properly initialized.");
            System.out.println("    " + room + " has passed constructor verification.");
            return true;
        }
        System.out.println("Room " + room + "'s roomNumber does not match argument: " + rN);
        System.out.println("    " + room + " has failed constructor verification. See above for details.");
        return false;
    }

    // Checks if HotelRoom keeps track of correct capacity
    boolean verifyCapacity(HotelRoom room, int realCap){
        if(room.checkCapacity() != realCap){
            System.out.println(room + " failed capacity check. Should be " + realCap + " but got " + room.checkCapacity());
            return false;
        }
        System.out.println(room + " passed capacity check. Contains " + realCap + " Person Objects");
        return true;
    }

// Testing Methods ---------------------------------------------//
    // User types in 1,2,3 to run that specific test. All 3 must pass to receive full credit.
    void runTest(){
        String input = "";
        boolean passed = false;
        while(true){
            System.out.println("\nType in 1, 2, or 3 to run a test. Type 'e' to exit.");
            input = input_scanner.nextLine();
            System.out.println("--------------------------------------------------");
            switch(input){
                case "1":
                    passed = runTestOne();
                    break;
                case "2":
                    passed = runTestTwo();
                    break;
                case "3":
                    passed = runTestThree();
                    break;
                case "e":
                    System.exit(0);
                default:
                    System.out.println("Please enter in a valid input.");
            }
            if(passed){
                System.out.println("- - - - - - - - - - - - - - - - - - - - - -");
                System.out.println("Ran test " + input + " correctly.");
            }
            else{
                System.out.println("failed test " + input + ".");
            }
            System.out.println("--------------------------------------------------");
        }
    }

    // Testing checkIn and checkOut functions for errors
    boolean runTestOne(){
        System.out.println("Running Test 1...");
        System.out.println("--------------------------------------------------");
        try{
            HotelRoom room_one = new HotelRoom(1);
            Person person_one = new Person(5.7, 16, "George", "Brown");
            Person person_two = new Person(3.4, 34, "Joe", "Purple");

            System.out.println("\nChecking in " + person_one.name);
            room_one.checkIn(person_one);
            System.out.println("\nChecking in " + person_two.name);
            room_one.checkIn(person_two);

            System.out.println("\nChecking out " + person_one.name);
            room_one.checkOut(person_one);
            System.out.println("\nChecking out " + person_two.name);
            room_one.checkOut(person_two);
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    // tests for people being checked in/out correctly
    boolean runTestTwo(){
        System.out.println("Running Test 2...");
        System.out.println("--------------------------------------------------");
        try{
            boolean failure = false;
            HotelRoom room_one = new HotelRoom(2);
            Person person_one = new Person(5.7, 16, "George", "Brown");
            Person person_two = new Person(3.4, 34, "Joe", "Purple");
            
            // check in test
            System.out.println("\nChecking in " + person_one.name);
            room_one.checkIn(person_one);
            System.out.println("\nChecking in " + person_two.name);
            room_one.checkIn(person_two);

            if(!checkedInRoom(room_one, person_one)){
                failure = true;
            }
            if(!checkedInRoom(room_one, person_two)){
                failure = true;
            }

            System.out.println("");
            // check out test
            System.out.println("\nChecking out " + person_one.name);
            room_one.checkOut(person_one);
            if(checkedInRoom(room_one, person_one)){
                System.out.print(person_one.name + " was not checked out properly.\n");
                printGuestNames(room_one);
                failure = true;
            }
            System.out.println("\nChecking out " + person_two.name);
            room_one.checkOut(person_two);
            if(checkedInRoom(room_one, person_two)){
                System.out.print(person_two.name + " was not checked out properly.\n");
                printGuestNames(room_one);
                failure = true;
            }
            System.out.println("");
            // third person check
            Person person_three = new Person(6.7, 280, "Old Bill", "Gray");
            System.out.println("\nChecking in " + person_three.name);
            room_one.checkIn(person_three);
            if(!checkedInRoom(room_one, person_three)){
                printGuestNames(room_one);
                failure = true;
            }
            System.out.println("\nChecking in " + person_one.name);
            room_one.checkIn(person_one);
            System.out.println("\nChecking in " + person_two.name);
            room_one.checkIn(person_two);
            if(checkedInRoom(room_one, person_two)){
                System.out.println(person_two.name + " should not be checked in as the room is at maximum capacity.");
                failure = true;
            }

            if(failure){
                return false;
            }
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }    
    }

    // Testing constructors, printGuestInfo and getCapacity
    boolean runTestThree(){
        System.out.println("Running Test 3...");
        System.out.println("--------------------------------------------------");
        boolean failure = false;
        try{
            int realCapacity = 0;
            Person person_one = new Person(5.7, 16, "George", "Brown");
            Person person_two = new Person(3.4, 34, "Joe", "Purple");
            HotelRoom room_one = new HotelRoom(3);

            // constructor test
            if(!properAttributes(person_one, 5.7, 16, "George", "Brown") || 
            !properAttributes(person_two, 3.4, 34, "Joe", "Purple") || 
            !properAttributes(room_one, 3)){
                failure = true;
            }

            
            System.out.println("");
            // checkCapacity test
            failure = !(verifyCapacity(room_one, realCapacity) && failure);

            System.out.println("\nChecking in " + person_one.name);
            room_one.checkIn(person_one);
            realCapacity++;
            failure = !(verifyCapacity(room_one, realCapacity) && failure);

            System.out.println("\nChecking in " + person_two.name);
            room_one.checkIn(person_two);
            realCapacity++;
            failure = !(verifyCapacity(room_one, realCapacity) && failure);

            System.out.println("\nChecking out " + person_one.name);
            room_one.checkOut(person_one);
            realCapacity--;
            failure = !(verifyCapacity(room_one, realCapacity) && failure);

            System.out.println("\nChecking out " + person_two.name);
            room_one.checkOut(person_two);
            realCapacity--;
            failure = !(verifyCapacity(room_one, realCapacity) && failure);


            // printGuestInfo test
            System.out.println("\n\nTesting printGuestInfo(), IF NOTHING PRINTS OUT, IT FAILED regardless of whether or not it says test 3 passed.");
            room_one.checkIn(person_two);
            room_one.checkIn(person_one);
            room_one.printGuestInfo();
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}