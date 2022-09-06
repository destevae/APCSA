package projects;

public class HotelMain{
    public static void main(String[] args){
        HotelRoom room_one = new HotelRoom(1);
    Person firstGuest = new Person(67, 20, "Elaine", "Black");
    room_one.checkIn(firstGuest);

    }
    
}
