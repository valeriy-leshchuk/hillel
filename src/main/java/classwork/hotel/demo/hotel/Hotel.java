package classwork.hotel.demo.hotel;

import classwork.hotel.demo.client.Client;

public class Hotel
{
    private String hotelName_;
    private Room[][] rooms_;

    public Hotel(String hotelName, int floors, int roomsOnFloor)
    {
        hotelName_ = hotelName;
        rooms_ = new Room[floors][roomsOnFloor];

        initDefault(rooms_);
    }

    public boolean book(int floorNumber, int roomNumber, Client client)
    {
        if (floorNumber > 0 && roomNumber > 0 &&
            rooms_.length >= floorNumber &&
            rooms_[floorNumber - 1].length >= roomNumber)
        {
            Room roomToBook = rooms_[floorNumber - 1][roomNumber - 1];
            return roomToBook.book(client);
        }
        return false;
    }

    public void printCurrentStatus()
    {
        for (int i = 0; i < rooms_.length; i++)
        {
            for (int j = 0; j < rooms_[i].length; j++)
            {
                System.out.println("Room #" + (j + 1) + " on " + (i + 1) + " floor. " + rooms_[i][j].toString());
            }
            System.out.println();
        }
    }

    private static void initDefault(Room[][] rooms)
    {
        for (int i = 0; i < rooms.length; i++)
        {
            for (int j = 0; j < rooms[i].length; j++)
            {
                rooms[i][j] = new Room();
            }
        }
    }
}
