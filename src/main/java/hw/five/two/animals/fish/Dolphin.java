package hw.five.two.animals.fish;

public class Dolphin implements IFish
{
    @Override
    public void eat()
    {
        System.out.println("Dolphin eat.");
    }

    @Override
    public void sleep()
    {
        System.out.println("Dolphin sleep.");
    }

    @Override
    public void moveFin()
    {
        System.out.println("Dolphin move a fin.");
    }

    @Override
    public void swim()
    {
        System.out.println("Dolphin swim.");
    }
}