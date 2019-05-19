package classwork.hotel.demo.hotel;

import classwork.hotel.demo.client.Client;

public class Room
{
    private double square_;
    private int places_;
    private boolean occupied_;
    private Client occupiedBy_;

    private static double DEF_SQUARE = 1;
    private static int DEF_PLACES = 1;

    public Room(double square, int places)
    {
        square_ = square;
        places_ = places;
    }

    public Room()
    {
        square_ = DEF_SQUARE;
        places_ = DEF_PLACES;
    }

    public boolean book(Client client)
    {
        if (occupied_)
        {
            return false;
        }
        occupiedBy_ = client;
        occupied_ = true;
        return true;
    }

    @Override
    public String toString()
    {
        return "Room: [" + "square=" + square_ + ", places=" + places_ + ", occupied=" + occupied_ + ", occupiedBy=" + occupiedBy_ + ']';
    }
}
