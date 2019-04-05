package classwork.hotel.demo;

import classwork.hotel.demo.client.Client;
import classwork.hotel.demo.hotel.Hotel;

public class HotelApplication
{
    public static void main(String[] args)
    {
        Hotel hiltonHotel = new Hotel("Hilton", 3, 3);

        Client client1 = new Client("111", "client1");
        Client client2 = new Client("222", "client2");
        Client client3 = new Client("333", "client3");

        System.out.println("Initial state:");
        hiltonHotel.printCurrentStatus();

        hiltonHotel.book(1, 1, client1);
        System.out.println("Client 1 booked a room. Current status is:");
        hiltonHotel.printCurrentStatus();

        hiltonHotel.book(1, 1, client2);
        System.out.println("Client 2 tried to book the same room. Should have not been allowed. Current status is:");
        hiltonHotel.printCurrentStatus();

        hiltonHotel.book(3, 3, client3);
        System.out.println("Client 3 tried to book another room. Current status is:");
        hiltonHotel.printCurrentStatus();
    }
}
