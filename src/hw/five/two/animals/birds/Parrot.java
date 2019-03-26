package hw.five.two.animals.birds;

public class Parrot implements IBird
{
    @Override
    public void eat()
    {
        System.out.println("Parrot eat.");
    }

    @Override
    public void sing()
    {
        System.out.println("Parrot sing.");
    }

    @Override
    public void sleep()
    {
        System.out.println("Parrot sleep.");
    }

    @Override
    public void fly()
    {
        System.out.println("Parrot fly.");
    }
}