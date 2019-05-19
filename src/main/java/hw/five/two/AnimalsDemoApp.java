package hw.five.two;

import hw.five.two.animals.birds.*;
import hw.five.two.animals.fish.*;

public class AnimalsDemoApp
{
    public static void main(String[] args)
    {
        IAnimal penguin = new Kiwi();   //can eat, sleep
        IFlyable parrot = new Parrot(); //can eat, sleep and fly
        IBird kiwi = new Penguin();     //can eat, sleep and fly and sing

        IAnimal shark = new Shark();    //can eat, sleep
        ISwimmable whale = new Whale(); //can eat, sleep and swim
        IFish dolphin = new Dolphin();  //can eat, sleep and swim and moveFin
    }
}