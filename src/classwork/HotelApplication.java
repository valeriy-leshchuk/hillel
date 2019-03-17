package classwork;

import classwork.hotel.demo.client.Client;
import classwork.hotel.demo.hotel.Hotel;
import classwork.hotel.demo.hotel.Room;

public class HotelApplication
{
    public static void main (String[] args)
    {
        Room [][] hiltonRooms = new Room[1][1];
        Hotel hiltonHotel = new Hotel ("Hilton", hiltonRooms);

        Client client1 = new Client("111", "client1");
        Client client2 = new Client("222", "client2");

        hiltonHotel.printCurrentStatus();

    }


}
