package classwork.hotel.demo.hotel;

import classwork.hotel.demo.client.Client;

public class Hotel
{
    private String hotelName;
    private Room[][] rooms;

    public Hotel (String hotelName, Room[][] rooms)
    {
        this.hotelName = hotelName;
        this.rooms = rooms;
    }

    public boolean book (int floorNumber, int roomNumber, Client client)
    {
        if (floorNumber>0 && roomNumber>0 &&
                rooms.length>=floorNumber &&
                rooms[floorNumber-1].length>=roomNumber)
        {
            Room roomToBook = rooms[floorNumber][roomNumber];
            return roomToBook.book(client);
        }
        return false;
    }

    public void printCurrentStatus()
    {
        for (Room [] floor: rooms)
        {
            for (Room room : floor)
            {
                System.out.println(room.toString());
            }
        }
    }

}
