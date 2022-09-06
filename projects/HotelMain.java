public class HotelMain{
    public static void main(String[] args){
        // making the hotel rooms and people
        HotelRoom room_one = new HotelRoom(1);
        Person firstGuest = new Person(67, 20, "Elaine", "Black");
        Person secondGuest = new Person(50, 19, "Mattie", "Brown");

        room_one.checkIn(firstGuest);
        System.out.println(room_one.GuestCounter);
        System.out.println(room_one.guestOne);

        room_one.checkIn(secondGuest);

        room_one.checkOut(firstGuest);
        System.out.println(room_one.GuestCounter);
    }
    
}
