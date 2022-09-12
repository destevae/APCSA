public class HotelRoom {
    int roomNumber;
    public Person guestOne;
    public Person guestTwo;
    int GuestCounter = 0;
    int guestAge;

    HotelRoom(int roomNum){ // hotel room constructor
        roomNumber = roomNum;
    }

    // checks in a guest to their room, making sure there is a max of 2 people in that room
    void checkIn(Person guest){
        if (GuestCounter == 0){
            guestOne = guest;
            GuestCounter++;
        }
        
        else if (GuestCounter == 1){
            guestTwo = guest;
            GuestCounter++;
        }

        else if (GuestCounter == 2){ // if the hotel room has reach max capacity
            System.out.println("The hotel room is already full.");
        }
        
    }

    // checks out a guest from their room
    void checkOut(Person guest){
        if (guest == guestOne){
            guestOne = null;
            GuestCounter--;
        }

        else if (guest == guestTwo){
            GuestCounter--;
            guestTwo = null;
        }

        // if there are no guests in the room
        else if (GuestCounter == 0){
            System.out.println("There are no guests to check out.");
        }

        // if the guest is not in that room to be checked out
        else { 
            System.out.println("The guest you are trying to remove is not in the room.");
        }
    }

    // prints out the number of guests in the room + returns the number of guests
    int checkCapacity(){
        if(GuestCounter == 0){
            System.out.println("There are 0 guests in this room.");
        }
        if(GuestCounter == 1){
            System.out.println("There are 1 guests in this room.");
        }
        if(GuestCounter == 2){
            System.out.println("There are 2 guests in this room.");
        }
        return GuestCounter;
    }

    // prints info of the guests that reside in the hotel room
    void printGuestInfo(){

        // makes sure that only the guests that are not null have their information printed
        if(guestOne != null){
            System.out.println("Guest One is called " + guestOne.name + ". They are " + guestOne.age + " years old and " + guestOne.height + " inches tall. Their hair color is " + guestOne.hairColor + ".");
        }
        
        if(guestTwo != null){
            System.out.println("Guest Two is called " + guestTwo.name + ". They are " + guestTwo.age + " years old and " + guestTwo.height + " inches tall. Their hair color is " + guestTwo.hairColor + ".");
        }
        
    }
}
