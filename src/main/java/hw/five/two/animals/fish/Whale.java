package hw.five.two.animals.fish;

public class Whale implements IFish
{
    @Override
    public void eat()
    {
        System.out.println("Whale eat.");
    }

    @Override
    public void sleep()
    {
        System.out.println("Whale sleep.");
    }

    @Override
    public void moveFin()
    {
        System.out.println("Whale move a fin.");
    }

    @Override
    public void swim()
    {
        System.out.println("Whale swim.");
    }
}