package hw.five.two.animals.fish;

public class Shark implements IFish
{
    @Override
    public void eat()
    {
        System.out.println("Shark eat.");
    }

    @Override
    public void sleep()
    {
        System.out.println("Shark sleep.");
    }

    @Override
    public void moveFin()
    {
        System.out.println("Shark move a fin.");
    }

    @Override
    public void swim()
    {
        System.out.println("Shark swim.");
    }
}