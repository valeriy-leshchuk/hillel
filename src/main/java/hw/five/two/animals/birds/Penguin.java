package hw.five.two.animals.birds;

public class Penguin implements IBird
{
    @Override
    public void eat()
    {
        System.out.println("Penguin eat.");
    }

    @Override
    public void sing()
    {
        System.out.println("Penguin sing.");
    }

    @Override
    public void sleep()
    {
        System.out.println("Penguin sleep.");
    }

    @Override
    public void fly()
    {
        System.out.println("Penguin fly.");
    }
}