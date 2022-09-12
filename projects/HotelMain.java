public class HotelMain{
    public static void main(String[] args){
        // making the hotel rooms and people
        HotelRoom room_one = new HotelRoom(1);
        Person firstGuest = new Person(67, 20, "Elaine", "Black");
        Person secondGuest = new Person(50, 19, "Mattie", "Brown");
        Person thirdGuest = new Person(50, 61, "Hello!!!!", "Blonde");

        // testing functions
        room_one.checkIn(secondGuest);
        room_one.checkOut(secondGuest);
        room_one.printGuestInfo();
    }
    
}
