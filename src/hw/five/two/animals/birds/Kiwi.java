package hw.five.two.animals.birds;

public class Kiwi implements IBird
{
    @Override
    public void eat()
    {
        System.out.println("Kiwi eat.");
    }

    @Override
    public void sing()
    {
        System.out.println("Kiwi sing.");
    }

    @Override
    public void sleep()
    {
        System.out.println("Kiwi sleep.");
    }

    @Override
    public void fly()
    {
        System.out.println("Kiwi fly.");
    }
}