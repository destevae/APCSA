public class HotelRoom {
    int roomNumber;
    Person guestOne;
    Person guestTwo;
    int GuestCounter = 0;

    HotelRoom(int roomNum){
        roomNumber = roomNum;
    }

    // checks in a guest to their room
    void checkIn(Person guest){
        if (GuestCounter == 0){
            guest = guestOne;
            GuestCounter++;
        }
        
        else if (GuestCounter == 1){
            guest = guestTwo;
            GuestCounter++;
        }

        else if (GuestCounter == 2){
            System.out.println("The hotel room is full!!!!!!!");
        }
        
    }

    // checks out a guest from their room
    void checkOut(Person guest){
        if (guest == guestOne){
            guestOne.reset();
            GuestCounter--;
            
        }

        else if (guest == guestTwo){
            GuestCounter--;
            guestTwo = null;
        }

        else {
            System.out.println("The guest you are trying to remove is not in the room.");
        }
    }

    // checks if a hotel room is full or not
    boolean checkCapacity(){
        return true;
    }

    // prints info of the guests that reside in the hotel room
    void printGuestInfo(){

    }
}
